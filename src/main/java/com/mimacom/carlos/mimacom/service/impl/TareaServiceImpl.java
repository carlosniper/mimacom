package com.mimacom.carlos.mimacom.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.repositories.TareaRepository;
import com.mimacom.carlos.mimacom.service.TareaService;

/**
 * The Class TareaServiceImpl.
 */
@Service
public class TareaServiceImpl implements TareaService {
	
	/** The tarea repository. */
	@Autowired
	private TareaRepository tareaRepository;

	/**
	 * Gets the all tareas.
	 *
	 * @return the all tareas
	 */
	@Override
	public Optional<List<Tarea>> getAllTareas() {

		List<Tarea> allTareas = this.tareaRepository.findAll();
		
		return (Objects.isNull(allTareas) || allTareas.isEmpty()) ? Optional.empty() : Optional.of(allTareas);
	}

	/**
	 * Gets the tarea by id.
	 *
	 * @param id the id
	 * @return the tarea by id
	 */
	@Override
	public Optional<Tarea> getTareaById(Long id) {
		
		if(Objects.nonNull(id)) {
			return this.tareaRepository.findById(id);
		}
		return Optional.empty();
	}

	/**
	 * Creates the tarea.
	 *
	 * @param tarea the tarea
	 * @return the optional
	 */
	@Override
	public Optional<Tarea> createTarea(Tarea tarea) {

		if(Objects.nonNull(tarea)) {
			return Optional.of(this.tareaRepository.save(tarea));
		}
		return Optional.empty();
	}

	/**
	 * Update tarea.
	 *
	 * @param tarea the tarea
	 * @return the optional
	 */
	@Override
	public Optional<Tarea> updateTarea(Tarea tarea) {

		if(Objects.nonNull(tarea)) {
			Optional<Tarea> oTarea = this.tareaRepository.findById(tarea.getId_tarea());
			if(oTarea.isPresent()) {
				Tarea tareaToSave = updateTareaFields(oTarea.get(), tarea);
				return Optional.of(this.tareaRepository.save(tareaToSave));
			}
			return Optional.empty();
		}
		return Optional.empty();
	}

	/**
	 * Delete tarea.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	@Override
	public boolean deleteTarea(Long id) {
		
		if(Objects.nonNull(id)) {
			this.tareaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	/**
	 * Update tarea fields.
	 *
	 * @param tareaDB the tarea DB
	 * @param tarea the tarea
	 * @return the tarea
	 */
	private Tarea updateTareaFields(Tarea tareaDB, Tarea tarea) {
		
		Tarea newTarea = new Tarea();
		newTarea.setId_tarea(tareaDB.getId_tarea());
		if(!Objects.isNull(tarea.getDescripcion())) {
			newTarea.setDescripcion(tarea.getDescripcion());
		}else {
			newTarea.setDescripcion(tareaDB.getDescripcion());
		}
		if(!Objects.isNull(tarea.getEstado())) {
			newTarea.setEstado(tarea.getEstado());
		}else {
			newTarea.setEstado(tareaDB.getEstado());
		}
		if(!Objects.isNull(tarea.getProyecto())) {
			newTarea.setProyecto(tarea.getProyecto());
		}else {
			newTarea.setProyecto(tareaDB.getProyecto());
		}
		if(!Objects.isNull(tarea.getTitulo())) {
			newTarea.setTitulo(tarea.getTitulo());
		}else {
			newTarea.setTitulo(tareaDB.getTitulo());
		}
		
		return newTarea;
	}

}
