package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;

import lombok.Builder;
import lombok.Data;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.estadoCurso;

import java.time.LocalDate;

@Data
@Builder
public class CursoResponseDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private estadoCurso estado;
}