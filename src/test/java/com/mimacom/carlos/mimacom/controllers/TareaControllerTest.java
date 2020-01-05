package com.mimacom.carlos.mimacom.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.service.TareaService;
import com.mimacom.carlos.utils.MimacomConstanst;

/**
 * The Class TareaControllerTest.
 */
@ExtendWith(MockitoExtension.class)
public class TareaControllerTest implements MimacomConstanst{
	
	/** The tarea service. */
	@Mock
	private TareaService tareaService;
	
	/** The tarea controller. */
	@InjectMocks
	private TareaController tareaController;
	
	/**
	 * Gets the tareas ok.
	 *
	 * @return the tareas ok
	 */
	@Test
	public void getTareasOk() {
		
		Mockito.when(this.tareaService.getAllTareas()).thenReturn(Optional.of(LISTA_TAREAS));
		
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
		assertEquals(response.getBody().get(0).getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().get(0).getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().get(0).getId_tarea(), ID);
		assertEquals(response.getBody().get(0).getTitulo(), TITULO);
		assertEquals(response.getBody().get(0).getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Gets the tareas no content.
	 *
	 * @return the tareas no content
	 */
	@Test
	public void getTareasNoContent() {
		
		Mockito.when(this.tareaService.getAllTareas()).thenReturn(Optional.empty());
		
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		
		assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Gets the tarea by id ok.
	 *
	 * @return the tarea by id ok
	 */
	@Test
	public void getTareaByIdOk() {
		
		Mockito.when(this.tareaService.getTareaById(ID)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.getTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Gets the tarea by id not found.
	 *
	 * @return the tarea by id not found
	 */
	@Test
	public void getTareaByIdNotFound() {
		Mockito.when(this.tareaService.getTareaById(ID)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.getTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Creates the tarea ok.
	 */
	@Test
	public void createTareaOk() {
		
		Mockito.when(this.tareaService.createTarea(TAREA)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Creates the tarea ko.
	 */
	@Test
	public void createTareaKo() {
		
		Mockito.when(this.tareaService.createTarea(TAREA)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Creates the tarea bad request.
	 */
	@Test
	public void createTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Update tarea ok.
	 */
	@Test
	public void updateTareaOk() {
		
		Mockito.when(this.tareaService.updateTarea(TAREA)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Update tarea ko.
	 */
	@Test
	public void updateTareaKo() {
		
		Mockito.when(this.tareaService.updateTarea(TAREA)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Update tarea bad request.
	 */
	@Test
	public void updateTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Delete tarea ok.
	 */
	@Test
	public void deleteTareaOk() {
		
		Mockito.when(this.tareaService.deleteTarea(ID)).thenReturn(true);
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	/**
	 * Delete tarea ko.
	 */
	@Test
	public void deleteTareaKo() {
		
		Mockito.when(this.tareaService.deleteTarea(ID)).thenReturn(false);
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * Delete tarea bad request.
	 */
	@Test
	public void deleteTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

}
