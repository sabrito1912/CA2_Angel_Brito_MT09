package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class InscripcionRequestDTO {

    @NotNull(message = "El ID del curso es obligatorio")
    private Long cursoId;

    @NotBlank(message = "El nombre del participante no puede estar vacío")
    private String nombreParticipante;

    @NotNull(message = "La edad del participante es obligatoria")
    @Positive(message = "La edad debe ser un número positivo")
    private Integer edadParticipante;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico debe tener un formato válido")
    private String correo;
}
