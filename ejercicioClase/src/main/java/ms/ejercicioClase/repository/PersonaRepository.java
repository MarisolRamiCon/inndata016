package ms.ejercicioClase.repository;

import ms.ejercicioClase.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
