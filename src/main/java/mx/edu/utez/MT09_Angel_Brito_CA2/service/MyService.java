package mx.edu.utez.MT09_Angel_Brito_CA2.service;

import mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto.*;
import mx.edu.utez.MT09_Angel_Brito_CA2.exception.BadRequestException;
import mx.edu.utez.MT09_Angel_Brito_CA2.exception.ResourceNotFoundException;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.*;
import mx.edu.utez.MT09_Angel_Brito_CA2.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyService {

    private final cursoRepository cursoRepository;
    private final inscripcionRepository inscripcionRepository;

    public InscripcionResponseDTO inscribirParticipante(InscripcionRequestDTO dto) {
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new ResourceNotFoundException("El curso con ID " + dto.getCursoId() + " no existe"));

        if (curso.getEstado() != estadoCurso.DISPONIBLE) {
            throw new BadRequestException("El curso debe estar en estado DISPONIBLE para inscribir participantes");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setNombreParticipante(dto.getNombreParticipante());
        inscripcion.setEdadParticipante(dto.getEdadParticipante());
        inscripcion.setCorreo(dto.getCorreo());
        inscripcion.setFechaInscripcion(LocalDate.now());
        inscripcion.setEstado(estadoInscripcion.ACTIVA);
        inscripcion.setCurso(curso);

        Inscripcion guardada = inscripcionRepository.save(inscripcion);
        return mapToInscripcionDTO(guardada);
    }

    public InscripcionResponseDTO cancelarInscripcion(Long id) {
        Inscripcion inscripcion = inscripcionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("La inscripción con ID " + id + " no existe"));

        if (inscripcion.getEstado() != estadoInscripcion.ACTIVA) {
            throw new BadRequestException("Únicamente se pueden cancelar inscripciones en estado ACTIVA");
        }

        if (!LocalDate.now().isBefore(inscripcion.getCurso().getFechaInicio())) {
            throw new BadRequestException("No se puede cancelar la inscripción porque el curso ya ha comenzado");
        }

        inscripcion.setEstado(estadoInscripcion.CANCELADA);
        Inscripcion actualizada = inscripcionRepository.save(inscripcion);
        return mapToInscripcionDTO(actualizada);
    }

    public CursoResponseDTO registrarCurso(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setDescripcion(dto.getDescripcion());
        curso.setFechaInicio(dto.getFechaInicio());
        curso.setFechaFin(dto.getFechaFin());
        curso.setEstado(estadoCurso.DISPONIBLE);

        Curso guardado = cursoRepository.save(curso);
        return mapToCursoDTO(guardado);
    }

    public List<CursoResponseDTO> listarCursosDisponibles() {
        List<Curso> cursos = cursoRepository.findByEstado(estadoCurso.DISPONIBLE);
        List<CursoResponseDTO> respuesta = new ArrayList<>();
        for (Curso c : cursos) {
            respuesta.add(mapToCursoDTO(c));
        }
        return respuesta;
    }

    private CursoResponseDTO mapToCursoDTO(Curso curso) {
        CursoResponseDTO dto = CursoResponseDTO.builder()
                .id(curso.getId())
                .nombre(curso.getNombre())
                .descripcion(curso.getDescripcion())
                .fechaInicio(curso.getFechaInicio())
                .fechaFin(curso.getFechaFin())
                .estado(curso.getEstado())
                .build();
        return dto;
    }

    private InscripcionResponseDTO mapToInscripcionDTO(Inscripcion inscripcion) {
        InscripcionResponseDTO dto = InscripcionResponseDTO.builder()
                .id(inscripcion.getId())
                .nombreParticipante(inscripcion.getNombreParticipante())
                .edadParticipante(inscripcion.getEdadParticipante())
                .correo(inscripcion.getCorreo())
                .fechaInscripcion(inscripcion.getFechaInscripcion())
                .estado(inscripcion.getEstado())
                .calificacion(inscripcion.getCalificacion())
                .cursoId(inscripcion.getCurso().getId())
                .nombreCurso(inscripcion.getCurso().getNombre())
                .build();
        return dto;
    }
}