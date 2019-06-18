package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Personal;

// Interface que define los metodos del DAO de Usuarios.
public interface PersonalDao {
	
	Personal buscarPersonalAsignadoAlEvento (Long listado);
	
	//Preguntar si no es mas conveniente separar esto en otro DAO (al igual que el servicio)
	void ingresarEvento (Evento evento);
	
	List <Evento> traerEventos();
	
}
