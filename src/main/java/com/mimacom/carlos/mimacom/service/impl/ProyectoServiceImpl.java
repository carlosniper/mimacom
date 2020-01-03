package com.mimacom.carlos.mimacom.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.repositories.ProyectoRepository;
import com.mimacom.carlos.mimacom.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {
	
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public Optional<List<Proyecto>> getAllProyectos() {

		List<Proyecto> allProyectos = proyectoRepository.findAll();
		
		return (Objects.isNull(allProyectos) || allProyectos.isEmpty()) ? Optional.empty() : Optional.of(allProyectos);
	}

	@Override
	public Optional<Proyecto> getProyectoById(Long id) {

		if(!Objects.isNull(id)) {
			return proyectoRepository.findById(id);
		}
			
		return Optional.empty();
	}

	@Override
	public Optional<Proyecto> createProyecto(Proyecto proyecto) {
		
		if(Objects.nonNull(proyecto)) {
			Proyecto proyectoDB = proyectoRepository.save(proyecto);
			
			return Optional.of(proyectoDB);
		}
		return Optional.empty();
	}

}
