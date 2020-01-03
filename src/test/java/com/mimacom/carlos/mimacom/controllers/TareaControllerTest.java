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

import com.mimacom.carlos.mimacom.model.ErrorResponse;
import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.service.TareaService;
import com.mimacom.carlos.utils.MimacomConstanst;

@ExtendWith(MockitoExtension.class)
public class TareaControllerTest implements MimacomConstanst{
	
	@Mock
	private TareaService tareaService;
	
	@InjectMocks
	private TareaController tareaController;
	
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
		assertEquals(response.getBody().get(0).getProyecto().getId_proyecto(), ID);
		assertEquals(response.getBody().get(0).getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void getTareasNoContent() {
		
		Mockito.when(this.tareaService.getAllTareas()).thenReturn(Optional.empty());
		
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		
		assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void getTareaByIdOk() {
		
		Mockito.when(this.tareaService.getTareaById(ID)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.getTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto().getId_proyecto(), ID);
		assertEquals(response.getBody().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void getTareaByIdNotFound() {
		Mockito.when(this.tareaService.getTareaById(ID)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.getTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void createTareaOk() {
		
		Mockito.when(this.tareaService.createTarea(TAREA)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto().getId_proyecto(), ID);
		assertEquals(response.getBody().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void createTareaKo() {
		
		Mockito.when(this.tareaService.createTarea(TAREA)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void createTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.createTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void updateTareaOk() {
		
		Mockito.when(this.tareaService.updateTarea(TAREA)).thenReturn(Optional.of(TAREA));
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.NUEVO);
		assertEquals(response.getBody().getId_tarea(), ID);
		assertEquals(response.getBody().getTitulo(), TITULO);
		assertEquals(response.getBody().getProyecto().getId_proyecto(), ID);
		assertEquals(response.getBody().getProyecto().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void updateTareaKo() {
		
		Mockito.when(this.tareaService.updateTarea(TAREA)).thenReturn(Optional.empty());
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(TAREA);
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void updateTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
	
	@Test
	public void deleteTareaOk() {
		
		Mockito.when(this.tareaService.deleteTarea(ID)).thenReturn(true);
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void deleteTareaKo() {
		
		Mockito.when(this.tareaService.deleteTarea(ID)).thenReturn(false);
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void deleteTareaBadRequest() {
		
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

}
