package ms.ejercicioClase.entity;

import jakarta.persistence.*;
import org.hibernate.id.IdentityGenerator;

@Entity
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
    //Generar los constructores y los getter y setter


    public Departamento() {
    }

    public Departamento(Integer idDepartamento, Integer m2, Double precio) {
        this.idDepartamento = idDepartamento;
        this.m2 = m2;
        this.precio = precio;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Integer getM2() {
        return m2;
    }

    public void setM2(Integer m2) {
        this.m2 = m2;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
