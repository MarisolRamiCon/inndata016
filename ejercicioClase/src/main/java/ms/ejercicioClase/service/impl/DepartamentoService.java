package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.entity.Departamento;
import ms.ejercicioClase.repository.DepartamentoRepository;
import ms.ejercicioClase.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<Departamento> readAll() {
        return departamentoRepository.findAll().stream().
                filter(depa->depa.getActivo()).toList();
    }

    @Override
    public Optional<Departamento> readById(Integer id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public Departamento create(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento update(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public String deletebyId(Integer id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()) {
            Departamento departamentoValor= departamento.get();
            departamentoValor.setActivo(false);
            departamentoRepository.save(departamentoValor);
            return("El departamento se elimino");
        }else{
            return("No existia el departamento");
        }
    }

    @Override
    public List<Departamento> m2MayorQue(Integer m2) {
        return departamentoRepository.findByM2GreaterThan(m2);
    }

    @Override
    public List<Departamento> m2AndPrecio(Integer m2, Double precio) {
        return departamentoRepository.findByM2LessThanAndPrecioGreaterThan(m2,precio);
    }

    @Override
    public List<Departamento> m2MenorPrecioMayor(Integer m2, Double precio) {
        return departamentoRepository.m2MenorAndPrecio(m2,precio);
    }


}
