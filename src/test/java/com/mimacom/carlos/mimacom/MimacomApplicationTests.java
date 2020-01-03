package com.mimacom.carlos.mimacom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mimacom.carlos.mimacom.controllers.ProyectoController;
import com.mimacom.carlos.mimacom.controllers.TareaController;
import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.service.ProyectoService;
import com.mimacom.carlos.mimacom.service.TareaService;
import com.mimacom.carlos.utils.MimacomConstanst;

@SpringBootTest
class MimacomApplicationTests implements MimacomConstanst{
	
	@Autowired
	private TareaService tareaService;
	
	@Autowired
	private ProyectoService proyectoService;
	
	@Autowired
	private TareaController tareaController;
	
	@Autowired
	private ProyectoController proyectoController;
	
	private Proyecto proyecto;
	
	private Tarea tarea;

	@Test
	public void createProyecto() {
		ResponseEntity<Proyecto> response = this.proyectoController.createProyecto(PROYECTO);
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertFalse(Objects.isNull(response.getBody()));
	}
	
	@Test
	public void getAllProyectos() {
		ResponseEntity<Proyecto> responseProyecto = this.proyectoController.createProyecto(PROYECTO);
		assertEquals(responseProyecto.getStatusCode(), HttpStatus.CREATED);
		ResponseEntity<List<Proyecto>> response = this.proyectoController.getAllProyectos();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
	}
	
	@Test
	public void getProyectoById() {
		ResponseEntity<Proyecto> responseProyecto = this.proyectoController.getProyectoById(ID);
		assertEquals(responseProyecto.getStatusCode(), HttpStatus.OK);
		assertFalse(Objects.isNull(responseProyecto.getBody()));
	}
	
	@Test
	public void getAllTareas() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
	}
	
	@Test
	public void getTareaById() {
		ResponseEntity<Tarea> responseCreate = this.tareaController.createTarea(TAREA);
		assertEquals(responseCreate.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseCreate.getBody()));
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		ResponseEntity<Tarea> responseTarea = this.tareaController.getTarea(response.getBody().get(0).getId_tarea());
		assertEquals(responseTarea.getStatusCode(), HttpStatus.OK);
		assertFalse(Objects.isNull(responseTarea.getBody()));
	}
	
	@Test
	public void createTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
	}
	
	@Test
	public void updateTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
		Tarea newTarea = new Tarea(responseTarea.getBody().getId_tarea(), TITULO_MOD, DESCRIPCION_MOD, PROYECTO, EstadoTareaEnum.FINALIZADO);
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(newTarea);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION_MOD);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.FINALIZADO);
		assertEquals(response.getBody().getId_tarea(), responseTarea.getBody().getId_tarea());
		assertEquals(response.getBody().getTitulo(), TITULO_MOD);
		assertEquals(response.getBody().getProyecto().getNombre(), NOMBRE_PROYECTO);
		assertEquals(response.getBody().getProyecto().getId_proyecto(), ID);
	}
	
	@Test
	public void deleteTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(responseTarea.getBody().getId_tarea());
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
