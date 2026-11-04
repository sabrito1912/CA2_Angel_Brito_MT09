package mx.edu.utez.MT09_Angel_Brito_CA2.repository;


import mx.edu.utez.MT09_Angel_Brito_CA2.model.Curso;
import mx.edu.utez.MT09_Angel_Brito_CA2.model.estadoCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface cursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByEstado(estadoCurso estado);
}
