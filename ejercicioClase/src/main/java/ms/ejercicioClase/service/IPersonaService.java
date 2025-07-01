package ms.ejercicioClase.service;

import ms.ejercicioClase.entity.PersonaEntity;

import java.util.List;

public interface IPersonaService {
    public List<PersonaEntity> readAll();
}
