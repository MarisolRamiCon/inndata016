package ms.ejercicioClase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor //Constructor con todos los argumentos
@NoArgsConstructor //Constructor sin argumentos
@Data //getters y setters
@Table(name = "departamento")
public class Departamento{
    //Mapear sus atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;
    @Column(name = "m2")
    private Integer m2;
    @Column(name="precio")
    private Double precio;
    @Column(name = "activo")
    private Boolean activo;
    //Generar los constructores y los getter y setter
}
