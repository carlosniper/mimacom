package com.mimacom.carlos.mimacom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_tarea;
	
	@NotBlank
	private String titulo;
	
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;
	
	private EstadoTareaEnum estado;

	public Tarea() {
		super();
	}

	public Tarea(Long id_tarea, @NotBlank String titulo, String descripcion, @NotNull Proyecto proyecto, EstadoTareaEnum estado) {
		super();
		this.id_tarea = id_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
		this.estado = estado;
	}

	public Long getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(Long id_tarea) {
		this.id_tarea = id_tarea;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setId_proyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public EstadoTareaEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoTareaEnum estado) {
		this.estado = estado;
	}
}
