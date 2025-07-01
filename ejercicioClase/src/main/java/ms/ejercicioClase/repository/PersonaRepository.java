package ms.ejercicioClase.repository;

import ms.ejercicioClase.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
}
