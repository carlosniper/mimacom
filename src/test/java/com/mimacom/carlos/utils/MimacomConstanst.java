package com.mimacom.carlos.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mimacom.carlos.mimacom.model.EstadoTareaEnum;
import com.mimacom.carlos.mimacom.model.Proyecto;
import com.mimacom.carlos.mimacom.model.Tarea;

public interface MimacomConstanst {
	
	public static Long ID = 1L;
	
	public static String NOMBRE_PROYECTO = "PROYECTO 1";
	
	public static Proyecto PROYECTO = new Proyecto(ID, NOMBRE_PROYECTO);
	
	public static List<Proyecto> LISTA_PROYECTOS =  Stream.of(PROYECTO).collect(Collectors.toList());
	
	public static String TITULO = "Titulo tarea";
	
	public static String DESCRIPCION = "Descripcion tarea";
	
	public static Tarea TAREA = new Tarea(ID, TITULO, DESCRIPCION, PROYECTO, EstadoTareaEnum.NUEVO);
	
	public static List<Tarea> LISTA_TAREAS = Stream.of(TAREA).collect(Collectors.toList());
	
	public static String EXCEPTION_MESSAGE = "EXCEPTION_MESSAGE";
	
	public static String TITULO_MOD = "TITULO MOD";
	
	public static String DESCRIPCION_MOD = "DESCRIPCION MOD";
}
