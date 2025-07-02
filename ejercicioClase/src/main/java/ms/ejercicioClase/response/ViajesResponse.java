package ms.ejercicioClase.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViajesResponse {
    private Integer id;
    private String destino;
    private Double precio;
    private LocalDateTime fechaSalida;

}
