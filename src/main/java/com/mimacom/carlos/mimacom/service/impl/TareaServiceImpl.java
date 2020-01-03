package com.mimacom.carlos.mimacom.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimacom.carlos.mimacom.model.Tarea;
import com.mimacom.carlos.mimacom.repositories.TareaRepository;
import com.mimacom.carlos.mimacom.service.TareaService;

@Service
public class TareaServiceImpl implements TareaService {
	
	@Autowired
	private TareaRepository tareaRepository;

	@Override
	public Optional<List<Tarea>> getAllTareas() {

		List<Tarea> allTareas = this.tareaRepository.findAll();
		
		return (Objects.isNull(allTareas) || allTareas.isEmpty()) ? Optional.empty() : Optional.of(allTareas);
	}

	@Override
	public Optional<Tarea> getTareaById(Long id) {
		
		if(Objects.nonNull(id)) {
			return this.tareaRepository.findById(id);
		}
		return Optional.empty();
	}

	@Override
	public Optional<Tarea> createTarea(Tarea tarea) {

		if(Objects.nonNull(tarea)) {
			return Optional.of(this.tareaRepository.save(tarea));
		}
		return Optional.empty();
	}

	@Override
	public Optional<Tarea> updateTarea(Tarea tarea) {

		if(Objects.nonNull(tarea)) {
			Optional<Tarea> oTarea = this.tareaRepository.findById(tarea.getId_tarea());
			if(oTarea.isPresent()) {
				Tarea tareaToSave = updateTareaFields(oTarea.get().getId_tarea(), tarea);
				return Optional.of(this.tareaRepository.save(tareaToSave));
			}
			return Optional.empty();
		}
		return Optional.empty();
	}

	@Override
	public boolean deleteTarea(Long id) {
		
		if(Objects.nonNull(id)) {
			this.tareaRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	private Tarea updateTareaFields(Long id, Tarea tarea) {
		
		Tarea newTarea = new Tarea();
		newTarea.setId_tarea(id);
		if(!Objects.isNull(tarea.getDescripcion())) {
			newTarea.setDescripcion(tarea.getDescripcion());
		}
		if(!Objects.isNull(tarea.getEstado())) {
			newTarea.setEstado(tarea.getEstado());
		}
		if(!Objects.isNull(tarea.getProyecto())) {
			newTarea.setId_proyecto(tarea.getProyecto());
		}
		if(!Objects.isNull(tarea.getTitulo())) {
			newTarea.setTitulo(tarea.getTitulo());
		}
		
		return newTarea;
	}

}
