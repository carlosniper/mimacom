package com.mimacom.carlos.mimacom.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimacom.carlos.mimacom.model.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
	//Empty block
	
	Optional<Proyecto> findByNombre(String nombre);
}
