package mx.edu.utez.MT09_Angel_Brito_CA2.repository;

import mx.edu.utez.MT09_Angel_Brito_CA2.model.Inscripcion;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.estadoInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface inscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByCorreo(String correo);
    List<Inscripcion> findByCursoId(Long cursoId);
    List<Inscripcion> findByEstado(estadoInscripcion estado);
}
