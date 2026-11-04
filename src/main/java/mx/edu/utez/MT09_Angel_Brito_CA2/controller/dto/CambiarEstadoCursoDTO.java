package mx.edu.utez.MT09_Angel_Brito_CA2.controller.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.estadoCurso;

@Data
public class CambiarEstadoCursoDTO {

    @NotNull(message = "El nuevo estado del curso es obligatorio")
    private estadoCurso nuevoEstado;
}