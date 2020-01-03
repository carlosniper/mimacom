package com.mimacom.carlos.mimacom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mimacom.carlos.mimacom.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
	// Empty block!!
}
