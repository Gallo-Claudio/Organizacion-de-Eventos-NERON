package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Personal;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioPersonal {

	void consultarPersonal(List<Long> listado);
	
	List<Personal> controlDeServiciosPrestados ();
}
