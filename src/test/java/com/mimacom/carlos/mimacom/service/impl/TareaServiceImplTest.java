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

/**
 * The Class TareaServiceImplTest.
 */
@ExtendWith(MockitoExtension.class)
public class TareaServiceImplTest implements MimacomConstanst{
	
	/** The tarea repository. */
	@Mock
	private TareaRepository tareaRepository;
	
	/** The tarea service. */
	@InjectMocks
	private TareaServiceImpl tareaService;
	
	/**
	 * Gets the all tareas ok.
	 *
	 * @return the all tareas ok
	 */
	@Test
	public void getAllTareasOk() {
		
		when(this.tareaRepository.findAll()).thenReturn(LISTA_TAREAS);
		
		Optional<List<Tarea>> opTareas = this.tareaService.getAllTareas();
		
		assertTrue(opTareas.isPresent());
		assertEquals(opTareas.get().get(0).getDescripcion(), DESCRIPCION);
		assertEquals(opTareas.get().get(0).getEstado().getEstado(), EstadoTareaEnum.NUEVO.getEstado());
		assertEquals(opTareas.get().get(0).getId_tarea(), ID);
		assertEquals(opTareas.get().get(0).getProyecto(), NOMBRE_PROYECTO);
		assertEquals(opTareas.get().get(0).getTitulo(), TITULO);
	}
	
	/**
	 * Gets the all tareas null.
	 *
	 * @return the all tareas null
	 */
	@Test
	public void getAllTareasNull() {
		when(this.tareaRepository.findAll()).thenReturn(null);
		
		Optional<List<Tarea>> opTareas = this.tareaService.getAllTareas();
		
		assertFalse(opTareas.isPresent());
	}
	
	/**
	 * Gets the tarea by id ok.
	 *
	 * @return the tarea by id ok
	 */
	@Test
	public void getTareaByIdOk() {
		when(this.tareaRepository.findById(ID)).thenReturn(Optional.of(TAREA));
		
		Optional<Tarea> oTarea = this.tareaService.getTareaById(ID);
		
		assertTrue(oTarea.isPresent());
		assertEquals(oTarea.get().getDescripcion(), DESCRIPCION);
		assertEquals(oTarea.get().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(oTarea.get().getId_tarea(), ID);
		assertEquals(oTarea.get().getTitulo(), TITULO);
		assertEquals(oTarea.get().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Creates the tarea ok.
	 */
	@Test
	public void createTareaOk() {
		
		when(this.tareaRepository.save(TAREA)).thenReturn(TAREA);
		
		Optional<Tarea> oTarea = this.tareaService.createTarea(TAREA);
		
		assertTrue(oTarea.isPresent());
		assertEquals(oTarea.get().getDescripcion(), DESCRIPCION);
		assertEquals(oTarea.get().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(oTarea.get().getId_tarea(), ID);
		assertEquals(oTarea.get().getTitulo(), TITULO);
		assertEquals(oTarea.get().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Update tarea ok.
	 */
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
		assertEquals(oTarea.get().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Update tarea null.
	 */
	@Test
	public void updateTareaNull() {
		
		Optional<Tarea> oTarea = this.tareaService.updateTarea(null);
		
		assertFalse(oTarea.isPresent());
	}
	
	/**
	 * Update tarea not exist.
	 */
	@Test
	public void updateTareaNotExist() {
		
		when(this.tareaRepository.findById(ID)).thenReturn(Optional.empty());
		
		Optional<Tarea> oTarea = this.tareaService.updateTarea(TAREA);
		
		assertFalse(oTarea.isPresent());
	}
	
	/**
	 * Delete tarea ok.
	 */
	@Test
	public void deleteTareaOk() {
		
		boolean result = this.tareaService.deleteTarea(ID);
		
		assertTrue(result);
	}
	
	/**
	 * Delete tarea ko.
	 */
	@Test
	public void deleteTareaKo() {
		
		boolean result = this.tareaService.deleteTarea(null);
		
		assertFalse(result);
	}
}

