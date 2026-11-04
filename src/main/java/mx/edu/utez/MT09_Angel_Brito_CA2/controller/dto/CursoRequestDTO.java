package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CursoRequestDTO {

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    private String nombre;

    private String descripcion;

    @NotNull(message = "La fecha de inicio es requerida")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de fin es requerida")
    private LocalDate fechaFin;
}
