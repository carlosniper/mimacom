package com.mimacom.carlos.mimacom.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.service.ProyectoService;
import com.mimacom.carlos.utils.MimacomConstanst;

@ExtendWith(MockitoExtension.class)
public class ProyectoControllerTest implements MimacomConstanst{

	@Mock
	private ProyectoService proyectoService;
	
	@InjectMocks
	private ProyectoController proyectoController;
	
	@Test
	public void getAllProyectosOk() {
		
		when(this.proyectoService.getAllProyectos()).thenReturn(Optional.of(LISTA_PROYECTOS));
		
		ResponseEntity<List<Proyecto>> response = this.proyectoController.getAllProyectos();
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertFalse(response.getBody().isEmpty());
		assertEquals(response.getBody().get(0).getId_proyecto(), ID);
		assertEquals(response.getBody().get(0).getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void getAllProyectosNoContent() {
		
		when(this.proyectoService.getAllProyectos()).thenReturn(Optional.empty());
		
		ResponseEntity<List<Proyecto>> response = this.proyectoController.getAllProyectos();
		
		assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
	}
	
	@Test
	public void getProyectoByIdOk() {
		
		when(this.proyectoService.getProyectoById(ID)).thenReturn(Optional.of(PROYECTO));
		
		ResponseEntity<Proyecto> response = this.proyectoController.getProyectoById(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertEquals(response.getBody().getId_proyecto(), ID);
		assertEquals(response.getBody().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void getProyectoByIdNotFound() {
		
		when(this.proyectoService.getProyectoById(ID)).thenReturn(Optional.empty());
		
		ResponseEntity<Proyecto> response = this.proyectoController.getProyectoById(ID);
		
		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void createProyectoOk() {
		
		when(this.proyectoService.createProyecto(PROYECTO)).thenReturn(Optional.of(PROYECTO));
		
		ResponseEntity<Proyecto> response = this.proyectoController.createProyecto(PROYECTO);
		
		assertEquals(response.getStatusCode(), HttpStatus.CREATED);
		assertEquals(response.getBody().getId_proyecto(), ID);
		assertEquals(response.getBody().getNombre(), NOMBRE_PROYECTO);
	}
	
	@Test
	public void createProyectoKo() {
		
		when(this.proyectoService.createProyecto(PROYECTO)).thenReturn(Optional.empty());
		
		ResponseEntity<Proyecto> response = this.proyectoController.createProyecto(PROYECTO);
		
		assertEquals(response.getStatusCode(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Test
	public void createProyectoBadRequest() {
		
		ResponseEntity<Proyecto> response = this.proyectoController.createProyecto(null);
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
	}
}
