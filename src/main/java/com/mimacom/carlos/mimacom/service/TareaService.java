package com.mimacom.carlos.mimacom.service;

import java.util.List;
import java.util.Optional;

import com.mimacom.carlos.mimacom.model.Tarea;

/**
 * The Interface TareaService.
 */
public interface TareaService {
	
	/**
	 * Gets the all tareas.
	 *
	 * @return the all tareas
	 */
	public Optional<List<Tarea>> getAllTareas();
	
	/**
	 * Gets the tarea by id.
	 *
	 * @param id the id
	 * @return the tarea by id
	 */
	public Optional<Tarea> getTareaById(Long id);
	
	/**
	 * Creates the tarea.
	 *
	 * @param tarea the tarea
	 * @return the optional
	 */
	public Optional<Tarea> createTarea(Tarea tarea);
	
	/**
	 * Update tarea.
	 *
	 * @param tarea the tarea
	 * @return the optional
	 */
	public Optional<Tarea> updateTarea(Tarea tarea);
	
	/**
	 * Delete tarea.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteTarea(Long id);

}
