package com.mimacom.carlos.mimacom.service;

import java.util.List;
import java.util.Optional;

import com.mimacom.carlos.mimacom.model.Proyecto;

public interface ProyectoService {
	
	public Optional<List<Proyecto>> getAllProyectos();
	
	public Optional<Proyecto> getProyectoById(Long id);
	
	public Optional<Proyecto> createProyecto(Proyecto proyecto);
}
