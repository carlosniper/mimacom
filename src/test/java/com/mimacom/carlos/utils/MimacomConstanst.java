package com.mimacom.carlos.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Tarea;

/**
 * The Interface MimacomConstanst.
 */
public interface MimacomConstanst {
	
	/** The id. */
	public static Long ID = 1L;
	
	/** The nombre proyecto. */
	public static String NOMBRE_PROYECTO = "PROYECTO 1";
			
	/** The titulo. */
	public static String TITULO = "Titulo tarea";
	
	/** The descripcion. */
	public static String DESCRIPCION = "Descripcion tarea";
	
	/** The tarea. */
	public static Tarea TAREA = new Tarea(ID, TITULO, DESCRIPCION, NOMBRE_PROYECTO, EstadoTareaEnum.NUEVO);
	
	/** The lista tareas. */
	public static List<Tarea> LISTA_TAREAS = Stream.of(TAREA).collect(Collectors.toList());
	
	/** The exception message. */
	public static String EXCEPTION_MESSAGE = "EXCEPTION_MESSAGE";
	
	/** The titulo mod. */
	public static String TITULO_MOD = "TITULO MOD";
	
	/** The descripcion mod. */
	public static String DESCRIPCION_MOD = "DESCRIPCION MOD";
}
