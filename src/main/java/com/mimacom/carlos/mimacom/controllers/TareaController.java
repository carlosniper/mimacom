package com.mimacom.carlos.mimacom.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.service.TareaService;

/**
 * The Class TareaController.
 */
@RestController
@RequestMapping("tarea")
public class TareaController {
	
	/** The tarea service. */
	@Autowired
	private TareaService tareaService;
	
	/**
	 * Gets the all tareas.
	 *
	 * @return the all tareas
	 */
	@GetMapping
	public ResponseEntity<List<Tarea>> getAllTareas(){
		
		Optional<List<Tarea>> oTarea = this.tareaService.getAllTareas();
		
		if(oTarea.isPresent()) {
			return new ResponseEntity<List<Tarea>>(oTarea.get(), HttpStatus.OK);
		}
		return new ResponseEntity<List<Tarea>>(HttpStatus.NO_CONTENT);
	}
	
	/**
	 * Gets the tarea.
	 *
	 * @param id the id
	 * @return the tarea
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Tarea> getTarea(@PathVariable Long id){
		
		Optional<Tarea> oTarea = this.tareaService.getTareaById(id);
		
		if(oTarea.isPresent()) {
			return new ResponseEntity<Tarea>(oTarea.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Creates the tarea.
	 *
	 * @param tarea the tarea
	 * @return the response entity
	 */
	@PostMapping
	public ResponseEntity<Tarea> createTarea(@RequestBody Tarea tarea){
		
		if(Objects.nonNull(tarea)) {
			Optional<Tarea> oTarea = this.tareaService.createTarea(tarea);
			if(oTarea.isPresent()) {
				return new ResponseEntity<Tarea>(oTarea.get(), HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<Tarea>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Tarea>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Update tarea.
	 *
	 * @param tarea the tarea
	 * @return the response entity
	 */
	@PutMapping
	public ResponseEntity<Tarea> updateTarea(@RequestBody Tarea tarea){
		if(Objects.nonNull(tarea) && Objects.nonNull(tarea.getId_tarea())) {
			Optional<Tarea> oTarea = this.tareaService.updateTarea(tarea);
			if(oTarea.isPresent()) {
				return new ResponseEntity<Tarea>(oTarea.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity<Tarea>(HttpStatus.NOT_FOUND);
			}
		}
		return new ResponseEntity<Tarea>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Delete tarea.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Tarea> deleteTarea(@PathVariable Long id){
		if(Objects.nonNull(id)) {
			if(this.tareaService.deleteTarea(id)) {
				return new ResponseEntity<Tarea>(HttpStatus.OK);
			}else {
				return new ResponseEntity<Tarea>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Tarea>(HttpStatus.BAD_REQUEST);
	}

}
