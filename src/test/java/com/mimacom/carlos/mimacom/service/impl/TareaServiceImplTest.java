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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.repositories.TareaRepository;
import com.mimacom.carlos.utils.MimacomConstanst;

@ExtendWith(MockitoExtension.class)
public class TareaServiceImplTest implements MimacomConstanst{
	
	@Mock
	private TareaRepository tareaRepository;
	
	@InjectMocks
	private TareaServiceImpl tareaService;
	
	@Test
	public void getAllTareasOk() {
		
		when(this.tareaRepository.findAll()).thenReturn(LISTA_TAREAS);
		
		Optional<List<Tarea>> opTareas = this.tareaService.getAllTareas();
		
		assertTrue(opTareas.isPresent());
		assertEquals(opTareas.get().get(0).getDescripcion(), DESCRIPCION);
		assertEquals(opTareas.get().get(0).getEstado().getEstado(), EstadoTareaEnum.NUEVO.getEstado());
		assertEquals(opTareas.get().get(0).getId_tarea(), ID);
		assertEquals(opTareas.get().get(0).getProyecto().getId_proyecto(), ID);
		assertEquals(opTareas.get().get(0).getProyecto().getNombre(), NOMBRE_PROYECTO);
		assertEquals(opTareas.get().get(0).getTitulo(), TITULO);
	}
	
	@Test
	public void getAllTareasNull() {
		when(this.tareaRepository.findAll()).thenReturn(null);
		
		Optional<List<Tarea>> opTareas = this.tareaService.getAllTareas();
		
		assertFalse(opTareas.isPresent());
	}
	
	@Test
	public void getTareaByIdOk() {
		when(this.tareaRepository.findById(ID)).thenReturn(Optional.of(TAREA));
		
		Optional<Tarea> oTarea = this.tareaService.getTareaById(ID);
		
		assertTrue(oTarea.isPresent());
		assertEquals(oTarea.get().getDescripcion(), DESCRIPCION);
		assertEquals(oTarea.get().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(oTarea.get().getId_tarea(), ID);
		assertEquals(oTarea.get().getTitulo(), TITULO);
		assertEquals(oTarea.get().getProyecto().getId_proyecto(), ID);
		assertEquals(oTarea.get().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void createTareaOk() {
		
		when(this.tareaRepository.save(TAREA)).thenReturn(TAREA);
		
		Optional<Tarea> oTarea = this.tareaService.createTarea(TAREA);
		
		assertTrue(oTarea.isPresent());
		assertEquals(oTarea.get().getDescripcion(), DESCRIPCION);
		assertEquals(oTarea.get().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(oTarea.get().getId_tarea(), ID);
		assertEquals(oTarea.get().getTitulo(), TITULO);
		assertEquals(oTarea.get().getProyecto().getId_proyecto(), ID);
		assertEquals(oTarea.get().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void updateTareaOk() {
		
		when(this.tareaRepository.findById(ID)).thenReturn(Optional.of(TAREA));
		when(this.tareaRepository.save(Mockito.any(Tarea.class))).thenReturn(TAREA);
		
		Optional<Tarea> oTarea = this.tareaService.updateTarea(TAREA);
		
		assertTrue(oTarea.isPresent());
		assertEquals(oTarea.get().getDescripcion(), DESCRIPCION);
		assertEquals(oTarea.get().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(oTarea.get().getId_tarea(), ID);
		assertEquals(oTarea.get().getTitulo(), TITULO);
		assertEquals(oTarea.get().getProyecto().getId_proyecto(), ID);
		assertEquals(oTarea.get().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void updateTareaNull() {
		
		Optional<Tarea> oTarea = this.tareaService.updateTarea(null);
		
		assertFalse(oTarea.isPresent());
	}
	
	@Test
	public void updateTareaNotExist() {
		
		when(this.tareaRepository.findById(ID)).thenReturn(Optional.empty());
		
		Optional<Tarea> oTarea = this.tareaService.updateTarea(TAREA);
		
		assertFalse(oTarea.isPresent());
	}
	
	@Test
	public void deleteTareaOk() {
		
		boolean result = this.tareaService.deleteTarea(ID);
		
		assertTrue(result);
	}
	
	@Test
	public void deleteTareaKo() {
		
		boolean result = this.tareaService.deleteTarea(null);
		
		assertFalse(result);
	}
}

