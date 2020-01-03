package com.mimacom.carlos.mimacom.model;

public enum EstadoTareaEnum {
	
	NUEVO(0L,"NUEVO"),
	EN_PROGRESO(1L,"EN PROGRESO"),
	FINALIZADO(2L, "FINALIZADO");
	
	private Long id;
	private String estado;
	
	EstadoTareaEnum(Long id, String estado){
		this.id = id;
		this.estado = estado;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public String getEstado() {
		return this.estado;
	}
}
