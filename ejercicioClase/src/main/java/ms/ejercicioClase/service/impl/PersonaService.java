package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.entity.PersonaEntity;
import ms.ejercicioClase.repository.PersonaRepository;
import ms.ejercicioClase.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {
    @Autowired
    PersonaRepository personaRepository;
    @Override
    public List<PersonaEntity> readAll() {
        return personaRepository.findAll();
    }
}
