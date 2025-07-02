package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.feign.ViajeClient;
import ms.ejercicioClase.response.ViajesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ViajesService implements ViajeClient {
    @Autowired
    ViajeClient viajeClient;
    @Override
    public List<ViajesResponse> readAll() {
        return viajeClient.readAll();
    }
}
