package com.mimacom.carlos.mimacom;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mimacom.carlos.mimacom.controllers.TareaController;
import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.utils.MimacomConstanst;

/**
 * The Class MimacomApplicationTests.
 */
@SpringBootTest
class MimacomApplicationTests implements MimacomConstanst{
	
	/** The tarea controller. */
	@Autowired
	private TareaController tareaController;
	
	/**
	 * Gets the all tareas.
	 *
	 * @return the all tareas
	 */
	@Test
	public void getAllTareas() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		ResponseEntity<List<Tarea>> response = this.tareaController.getAllTareas();
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
	}
	
	/**
	 * Gets the tarea by id.
	 *
	 * @return the tarea by id
	 */
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
	
	/**
	 * Creates the tarea.
	 */
	@Test
	public void createTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
	}
	
	/**
	 * Update tarea.
	 */
	@Test
	public void updateTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
		Tarea newTarea = new Tarea(responseTarea.getBody().getId_tarea(), TITULO_MOD, DESCRIPCION_MOD, NOMBRE_PROYECTO, EstadoTareaEnum.FINALIZADO);
		ResponseEntity<Tarea> response = this.tareaController.updateTarea(newTarea);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getDescripcion(), DESCRIPCION_MOD);
		assertEquals(response.getBody().getEstado(), EstadoTareaEnum.FINALIZADO);
		assertEquals(response.getBody().getId_tarea(), responseTarea.getBody().getId_tarea());
		assertEquals(response.getBody().getTitulo(), TITULO_MOD);
		assertEquals(response.getBody().getProyecto(), NOMBRE_PROYECTO);
	}
	
	/**
	 * Delete tarea.
	 */
	@Test
	public void deleteTarea() {
		ResponseEntity<Tarea> responseTarea = this.tareaController.createTarea(TAREA);
		assertEquals(responseTarea.getStatusCode(), HttpStatus.CREATED);
		assertTrue(Objects.nonNull(responseTarea.getBody()));
		ResponseEntity<Tarea> response = this.tareaController.deleteTarea(responseTarea.getBody().getId_tarea());
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

}
