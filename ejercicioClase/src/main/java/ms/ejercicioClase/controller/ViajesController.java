package ms.ejercicioClase.controller;

import ms.ejercicioClase.response.ViajesResponse;
import ms.ejercicioClase.service.impl.ViajesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v3")
public class ViajesController {
    @Autowired
    ViajesService viajesService;
    @GetMapping("/viaje")
    public List<ViajesResponse> readAll(){
        return viajesService.readAll();
    }
}
