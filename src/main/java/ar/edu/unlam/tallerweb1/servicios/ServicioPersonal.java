package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Map;

import ar.edu.unlam.tallerweb1.modelo.Personal;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioPersonal {

	Map <Long, Integer> obtencionListadoDeAsistencias();


	List <Personal> controlDeServiciosPrestados ();

	Map OrdenaAscendentemente(Map unsortMap);

	List <Integer> calcularPersonal();

	List <Long> asignarPersonalNecesario(List <Integer> personalNecesario, Map <Long,Integer> conteoOrdenadoAscendentementePorAsistencia);

	List <Personal> listadoPersonalAsignado(List <Long> listado);

	void persisteElListadoDePersonalAsignado (List <Personal> listado);

}
