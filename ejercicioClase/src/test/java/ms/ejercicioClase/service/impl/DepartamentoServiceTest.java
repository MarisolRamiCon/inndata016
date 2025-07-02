package ms.ejercicioClase.service.impl;

import ms.ejercicioClase.entity.DepartamentoEntity;
import ms.ejercicioClase.repository.DepartamentoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DepartamentoServiceTest {
    @InjectMocks
    DepartamentoService departamentoService;

    @Mock
    DepartamentoRepository departamentoRepository;
    DepartamentoEntity departamento;
    DepartamentoEntity departamento2;

    @BeforeEach
    void setUp() {
        departamento=new DepartamentoEntity(1,500,5000.0,true);
        departamento2=new DepartamentoEntity();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void suma() {
        double r = departamentoService.suma(8.0,8.5);
        assertEquals(16.5, r);
    }

    @Test
    void readById() {
        DepartamentoEntity departamento= new DepartamentoEntity(1,200,525.4,true);
        Mockito.when(departamentoRepository.findById(1)).thenReturn(Optional.of(departamento));
        Optional<DepartamentoEntity> departamentoActual= departamentoService.readById(1);
        assertEquals(departamento, departamentoActual.get());

    }

    @Test
    void update() {
        DepartamentoEntity departamentoNuevo= new DepartamentoEntity(2,300,600.0,true);
        Mockito.when(departamentoRepository.save(departamentoNuevo)).thenReturn(departamentoNuevo);
        DepartamentoEntity depa= departamentoService.update(departamentoNuevo);
        assertEquals(departamentoNuevo,depa);
    }

    @Test
    void deletebyId() {
        DepartamentoEntity departamento=new DepartamentoEntity(1,500,5000.0,true);
        Mockito.when(departamentoRepository.findById(1)).thenReturn(Optional.of(departamento));
        departamento.setActivo(false);
        Mockito.when(departamentoRepository.save(departamento)).thenReturn(departamento);
        assertEquals("El departamento se elimino",departamentoService.deletebyId(1));

    }

    @Test
    void deletebyIdElse() {
        Mockito.when(departamentoRepository.findById(1)).thenReturn(Optional.empty());
        assertEquals("No existia el departamento",departamentoService.deletebyId(1));

    }

    @Test
    void createTry() {
        Mockito.when(departamentoRepository.save(departamento)).thenReturn(departamento);
        assertEquals("Departamento creado exitosamente",departamentoService.create(departamento));

    }

    @Test
    void createCatch() {
        Mockito.when(departamentoRepository.save(departamento2)).thenThrow(new RuntimeException("Lanzado desde test"));
        assertEquals("Departamento que no pudo crearse",departamentoService.create(departamento2));

    }
}