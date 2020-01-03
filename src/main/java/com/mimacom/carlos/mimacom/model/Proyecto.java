package com.mimacom.carlos.mimacom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Proyecto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_proyecto;
	
	@NotBlank
	private String nombre;
	
	public Proyecto() {
		super();
	}
	
	public Proyecto(Long id_proyecto, String nombre) {
		super();
		this.id_proyecto = id_proyecto;
		this.nombre = nombre;
	}
	
	public Long getId_proyecto() {
		return id_proyecto;
	}
	
	public void setId_proyecto(Long id_proyecto) {
		this.id_proyecto = id_proyecto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
