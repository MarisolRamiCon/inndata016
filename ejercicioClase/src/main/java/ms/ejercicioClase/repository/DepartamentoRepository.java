package ms.ejercicioClase.repository;

import ms.ejercicioClase.entity.DepartamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, Integer> {
    //el metodo personalizado que vamos ha crear es buscar los departamentos
    //que tienen mayor o igual m2
    public List<DepartamentoEntity> findByM2GreaterThan(Integer m2);
    //un metodo donde me muestre departamentos que tengas menos de los m2
    // y un precio mayor al precio que tengo de argumento
    public List<DepartamentoEntity> findByM2LessThanAndPrecioGreaterThan(Integer m2, Double precio);
    // Un metodo personalizado por medio de Queries
    @Query(value = "select * from departamento where m2<:m2 and precio>:precio;",nativeQuery = true)
    public List<DepartamentoEntity> m2MenorAndPrecio (Integer m2, Double precio);
}

