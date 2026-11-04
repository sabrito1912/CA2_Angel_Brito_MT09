package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;

import lombok.Builder;
import lombok.Data;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.estadoInscripcion;

import java.time.LocalDate;

@Data
@Builder
public class InscripcionResponseDTO {
    private Long id;
    private String nombreParticipante;
    private Integer edadParticipante;
    private String correo;
    private LocalDate fechaInscripcion;
    private estadoInscripcion estado;
    private Double calificacion;
    private Long cursoId;
    private String nombreCurso;
}
