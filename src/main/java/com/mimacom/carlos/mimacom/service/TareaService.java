package com.mimacom.carlos.mimacom.service;

import java.util.List;
import java.util.Optional;

import com.mimacom.carlos.mimacom.model.Tarea;

public interface TareaService {
	
	public Optional<List<Tarea>> getAllTareas();
	
	public Optional<Tarea> getTareaById(Long id);
	
	public Optional<Tarea> createTarea(Tarea tarea);
	
	public Optional<Tarea> updateTarea(Tarea tarea);
	
	public boolean deleteTarea(Long id);

}
