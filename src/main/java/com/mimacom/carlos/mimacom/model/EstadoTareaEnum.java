package com.mimacom.carlos.mimacom.model;

/**
 * The Enum EstadoTareaEnum.
 */
public enum EstadoTareaEnum {
	
	NUEVO(0L,"NUEVO"),
	
	EN_PROGRESO(1L,"EN PROGRESO"),
	
	FINALIZADO(2L, "FINALIZADO");
	
	private Long id;
	
	private String estado;
	
	/**
	 * Instantiates a new estado tarea enum.
	 *
	 * @param id the id
	 * @param estado the estado
	 */
	EstadoTareaEnum(Long id, String estado){
		this.id = id;
		this.estado = estado;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return this.estado;
	}
}
