package com.mimacom.carlos.mimacom.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.service.ProyectoService;

@RestController
@RequestMapping("proyecto")
public class ProyectoController {
	
	@Autowired
	private ProyectoService proyectoService;
	
	@GetMapping
	public ResponseEntity<List<Proyecto>> getAllProyectos(){
		
		Optional<List<Proyecto>> opProyecto = this.proyectoService.getAllProyectos();
		
		if(opProyecto.isPresent()) {
			return new ResponseEntity<List<Proyecto>>(opProyecto.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<List<Proyecto>>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> getProyectoById(@PathVariable Long id){
		
		Optional<Proyecto> opProyecto = this.proyectoService.getProyectoById(id);
		
		if(opProyecto.isPresent()) {
			return new ResponseEntity<Proyecto>(opProyecto.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<Proyecto> createProyecto(@RequestBody Proyecto proyecto){
		
		if(Objects.nonNull(proyecto)) {
			Optional<Proyecto> opProyecto = this.proyectoService.createProyecto(proyecto);
			if(opProyecto.isPresent()) {
				return new ResponseEntity<Proyecto>(opProyecto.get(), HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Proyecto>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Proyecto>(HttpStatus.BAD_REQUEST);
	}
}
