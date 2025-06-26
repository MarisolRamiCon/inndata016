package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.entity.Departamento;
import ms.ejercicioClase.repository.DepartamentoRepository;
import ms.ejercicioClase.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll();
    }
}
