package ms.ejercicioClase.service;

import ms.ejercicioClase.entity.DepartamentoEntity;
import ms.ejercicioClase.response.DepartamentoResponse;

import java.util.List;
import java.util.Optional;

public interface IDepartamentoService {
    //Metodos Read
    public List<DepartamentoResponse> readAll();
    public Optional<DepartamentoEntity> readById(Integer id);
    //Metodo create
    public DepartamentoResponse create(DepartamentoEntity departamentoEntity);
    //Metodo update
    public DepartamentoEntity update(DepartamentoEntity departamentoEntity);
    //Metodo Delete
    public String deletebyId(Integer id);
    //MetodoPersonalizado
    public List<DepartamentoEntity> m2MayorQue(Integer m2);

    public List<DepartamentoEntity> m2AndPrecio(Integer m2, Double precio);

    public List<DepartamentoEntity> m2MenorPrecioMayor(Integer m2, Double precio);
}
