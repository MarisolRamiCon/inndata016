package ms.ejercicioClase.controller;

import jakarta.websocket.server.PathParam;
import ms.ejercicioClase.entity.DepartamentoEntity;
import ms.ejercicioClase.response.DepartamentoResponse;
import ms.ejercicioClase.service.impl.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class DepartamentoController {
    @Autowired
    DepartamentoService departamentoService;
    //GetMapping son para los metodos de lectura
    @GetMapping("/departamentos")
    public List<DepartamentoResponse> readAll(){
         return departamentoService.readAll();
    }
    @GetMapping("/departamentos/{id}")
    public Optional<DepartamentoEntity> readById(@PathVariable Integer id){
        return departamentoService.readById(id);
    }
    //La diferencia entre create y update es que uno es PutMapping(update)
    // y el otro es PostMapping(create)
    @PostMapping("/departamentos")
    public String create(@RequestBody DepartamentoEntity departamentoEntity){
        return departamentoService.create(departamentoEntity);
    }

    @PutMapping("/departamentos")
    public DepartamentoEntity update(@RequestBody DepartamentoEntity departamentoEntity){
        return departamentoService.update(departamentoEntity);
    }

    @DeleteMapping("/departamentos/{id}")
    public String delete(@PathVariable Integer id){
        return departamentoService.deletebyId(id);
    }

    @GetMapping("/departamentos/m2")
    public List<DepartamentoEntity> m2MayorQue(@PathParam("m2") Integer m2){
        return departamentoService.m2MayorQue(m2);

    }
    @GetMapping("/departamentos/precioM2")
    public List<DepartamentoEntity> m2AndPrecio(@PathParam("m2") Integer m2,
                                                @PathParam("precio") Double precio){
        return departamentoService.m2AndPrecio(m2,precio);
    }

    @GetMapping("/departamentos/precioAndM2")
    public List<DepartamentoEntity> m2MenorPrecioMayor(@PathParam("m2") Integer m2,
                                                       @PathParam("precio") Double precio){
        return departamentoService.m2MenorPrecioMayor(m2,precio);
    }
}
