package com.mimacom.carlos.mimacom.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.repositories.ProyectoRepository;
import com.mimacom.carlos.utils.MimacomConstanst;

@ExtendWith(MockitoExtension.class)
public class ProyectoServiceImplTest implements MimacomConstanst{
	
	@Mock
    private ProyectoRepository proyectoRepository;
	
	@InjectMocks
	private ProyectoServiceImpl proyectoService;
    
    @Test
    public void getAllProyectosOk() {
    	
    	when(this.proyectoRepository.findAll()).thenReturn(LISTA_PROYECTOS);
    	
    	Optional<List<Proyecto>> opProyectos = this.proyectoService.getAllProyectos();
    	
    	assertFalse(opProyectos.get().isEmpty());
    	assertEquals(opProyectos.get().get(0).getId_proyecto(), ID);
    	assertEquals(opProyectos.get().get(0).getNombre(), NOMBRE_PROYECTO);
    }
    
    @Test
    public void getAllProyectosNull() {
    	
    	when(this.proyectoRepository.findAll()).thenReturn(null);
    	
    	Optional<List<Proyecto>> opProyectos = this.proyectoService.getAllProyectos();
    	
    	assertFalse(opProyectos.isPresent());
    }
    
    @Test
    public void getProyectoByIdOk() {
    	
    	when(this.proyectoRepository.findById(ID)).thenReturn(Optional.of(PROYECTO));
    	
    	Optional<Proyecto> opProyecto = this.proyectoService.getProyectoById(ID);
    	
    	assertTrue(opProyecto.isPresent());
    	assertEquals(opProyecto.get().getId_proyecto(), ID);
    	assertEquals(opProyecto.get().getNombre(), NOMBRE_PROYECTO);
    }
    
    @Test
    public void createProyectoOk() {
    	
    	when(this.proyectoRepository.save(PROYECTO)).thenReturn(PROYECTO);
    	
    	Optional<Proyecto> opProyecto = this.proyectoService.createProyecto(PROYECTO);
    	
    	assertTrue(opProyecto.isPresent());
    	assertEquals(opProyecto.get().getId_proyecto(), ID);
    	assertEquals(opProyecto.get().getNombre(), NOMBRE_PROYECTO);
    }
}
