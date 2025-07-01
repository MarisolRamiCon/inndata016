package ms.ejercicioClase.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class PersonaResponse {
    private Integer id;
    private String nombre;
    private Integer edad;
    private Integer idDepartamento;
    private Double precio;
}
