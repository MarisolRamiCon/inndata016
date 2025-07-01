package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.entity.DepartamentoEntity;
import ms.ejercicioClase.repository.DepartamentoRepository;
import ms.ejercicioClase.response.DepartamentoResponse;
import ms.ejercicioClase.service.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class DepartamentoService implements IDepartamentoService {
    @Autowired
    DepartamentoRepository departamentoRepository;
    @Override
    public List<DepartamentoResponse> readAll() {
        Function<DepartamentoEntity,DepartamentoResponse> var= new Function<DepartamentoEntity, DepartamentoResponse>() {
            @Override
            public DepartamentoResponse apply(DepartamentoEntity departamentoEntity) {
                return new DepartamentoResponse(departamentoEntity.getIdDepartamento(),departamentoEntity.getPrecio());
            }
        };
        List<DepartamentoResponse> listaDepartamentos=departamentoRepository.findAll().stream().
                filter(depa->depa.getActivo()).map(var).toList();

        return listaDepartamentos;
        /*
        List<DepartamentoResponse> listaResultante= new ArrayList<>();*/
    }

    @Override
    public Optional<DepartamentoEntity> readById(Integer id) {
        return departamentoRepository.findById(id);
    }

    @Override
    public DepartamentoResponse create(DepartamentoEntity departamentoEntity) {
        departamentoRepository.save(departamentoEntity);
        DepartamentoResponse departamentoR=
                new DepartamentoResponse(departamentoEntity.getIdDepartamento(), departamentoEntity.getPrecio());
        return departamentoR;
    }

    @Override
    public DepartamentoEntity update(DepartamentoEntity departamentoEntity) {
        return departamentoRepository.save(departamentoEntity);
    }

    @Override
    public String deletebyId(Integer id) {
        Optional<DepartamentoEntity> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()) {
            DepartamentoEntity departamentoEntityValor = departamento.get();
            departamentoEntityValor.setActivo(false);
            departamentoRepository.save(departamentoEntityValor);
            return("El departamento se elimino");
        }else{
            return("No existia el departamento");
        }
    }

    @Override
    public List<DepartamentoEntity> m2MayorQue(Integer m2) {
        return departamentoRepository.findByM2GreaterThan(m2);
    }

    @Override
    public List<DepartamentoEntity> m2AndPrecio(Integer m2, Double precio) {
        return departamentoRepository.findByM2LessThanAndPrecioGreaterThan(m2,precio);
    }

    @Override
    public List<DepartamentoEntity> m2MenorPrecioMayor(Integer m2, Double precio) {
        return departamentoRepository.m2MenorAndPrecio(m2,precio);
    }


}
