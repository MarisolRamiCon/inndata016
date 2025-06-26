package ms.ejercicioClase.service;

import ms.ejercicioClase.entity.Departamento;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    //Metodos Read
    public List<Departamento> readAll();
    public Optional<Departamento> readById(Integer id);
    //Metodo create
    public Departamento create(Departamento departamento);
    //Metodo update
    public Departamento update(Departamento departamento);
    //Metodo Delete
    public String deletebyId(Integer id);

}
