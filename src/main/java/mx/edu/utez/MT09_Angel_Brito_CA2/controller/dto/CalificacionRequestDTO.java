package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CalificacionRequestDTO {

    @NotNull(message = "La calificación es obligatoria")
    @Min(value = 0, message = "La calificación mínima permitida es 0")
    @Max(value = 10, message = "La calificación máxima permitida es 10")
    private Double calificacion;
}
