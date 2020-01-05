# mimacom

## Introducción

Proyecto de API Rest para gestor de tareas simple. La API permite la consulta de tareas, busqueda de tarea por ID, creación, actualización y eliminación de tareas.

## Intalación y ejecución

Para su instalación es necesario clonarlo y tener instalado **maven** (para el desarrollo se ha usado la versión 3.6.2).

Una vez cumplidos los requisitos anteriores, ejecutamos el comando `mvn clean install` para descargar las dependencias y compilar.

Para ejecutar el proyecto, ejecutamos el comando `mvn spring-boot:run`.

## Modelo de datos

El modelo de la entidad tarea tiene el siguiente esquema

```
{
  "id_tarea": number,
  "titulo": string,
  "descripcion": string,
  "proyecto": string,
  "estado": string
}
```
El campo `id_tarea` es autogenerado por la bbdd y suado como clave primaria.

El campo `estado` es un enumerado que acepta los siguientes posibles valores:
  * `NUEVO`
  * `EN_PROGRESO`
  * `FINALIZADO`

## API

### getAllTareas()

Recupera todas las tareas existentes en base de datos.

* **Endpoint**: localhost:8080/tarea
* **Verbo**: `GET`
* **Respuestas HTTP**:
  * `200 OK`: Si existen tareas.
  * `204 NO CONTENT`: Si no existen tareas en bbdd.
  * `500 INTERNAL SERVER ERROR`: Error producido en el servidor.

### getTareaById()

Recupera una tarea por su ID

* **Endpoint**: localhost:8080/tarea/{id}
* **Verbo**: `GET`
* **Respuesta HTTP**:
  * `200 OK`: Si existe la tarea indicada.
  * `404 NOT FOUND`: Si la tarea indicada no existe.
  * `500 INTERNAL SERVER ERROR': Error producido en el servidor.

### createTarea()

Crea una nueva tarea. El campo `id_tarea` no es necesario incluirlo (se autogenera automaticamente).

* **Endpoint**: localhost:8080/tarea
* **Verbo**: `POST`
* **Respuesta HTTP**:
  * `201 CREATED`: Si la tarea se crea correctamente. El cuerpo de la respuesta es la tarea creada.
  * `400 BAD REQUEST`: Si el cuerpo de la petición no es correcto.
  * `500 INTERNAL SERVER ERROR': Error producido en el servidor.

### updateTarea()

Actualiza una tarea existente por su ID. Es necesario indicar el campo `id_tarea` para actualizar la tarea.

* **Endpoint**: localhost:8080/tarea
* **Verbo**: `PUT`
* **Respuesta HTTP**:
  * `200 OK`: Si la tarea se actualiza correctamente. El cuerpo de la respueta es la tarea actualizada.
  * `404 NOT FOUND`: Si la tarea a actualizar no existe.
  * `400 BAD REQUEST`: Si el cuerpo de la petición no es correcto.
  * `500 INTERNAL SERVER ERROR': Error producido en el servidor.

### deleteTarea()

Elimina una tarea existente por su ID. 

* **Endpoint**: localhost:8080/tarea/{id}
* **Verbo**: `DELETE`
* **Respuesta HTTP**:
  * `200 OK`: Si la tarea elimina correctamente.
  * `400 BAD REQUEST`: Si el cuerpo de la petición no es correcto.
  * `500 INTERNAL SERVER ERROR`: Error producido en el servidor.


