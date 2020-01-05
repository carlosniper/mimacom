package com.mimacom.carlos.mimacom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The Class Tarea.
 */
@Entity
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_tarea;
	
	@NotBlank
	private String titulo;
	
	private String descripcion;
	
	private String proyecto;
	
	private EstadoTareaEnum estado;

	/**
	 * Instantiates a new tarea.
	 */
	public Tarea() {
		super();
	}

	/**
	 * Instantiates a new tarea.
	 *
	 * @param id_tarea the id tarea
	 * @param titulo the titulo
	 * @param descripcion the descripcion
	 * @param proyecto the proyecto
	 * @param estado the estado
	 */
	public Tarea(Long id_tarea, @NotBlank String titulo, String descripcion, @NotNull String proyecto, EstadoTareaEnum estado) {
		super();
		this.id_tarea = id_tarea;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
		this.estado = estado;
	}

	/**
	 * Gets the id tarea.
	 *
	 * @return the id tarea
	 */
	public Long getId_tarea() {
		return id_tarea;
	}

	/**
	 * Sets the id tarea.
	 *
	 * @param id_tarea the new id tarea
	 */
	public void setId_tarea(Long id_tarea) {
		this.id_tarea = id_tarea;
	}

	/**
	 * Gets the titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the titulo.
	 *
	 * @param titulo the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the proyecto.
	 *
	 * @return the proyecto
	 */
	public String getProyecto() {
		return proyecto;
	}

	/**
	 * Sets the proyecto.
	 *
	 * @param proyecto the new proyecto
	 */
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public EstadoTareaEnum getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(EstadoTareaEnum estado) {
		this.estado = estado;
	}
}
