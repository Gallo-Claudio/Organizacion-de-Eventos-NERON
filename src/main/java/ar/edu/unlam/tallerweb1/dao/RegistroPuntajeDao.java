package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


public interface RegistroPuntajeDao {

	List<PuntajeMenu> registroPuntaje (List<PuntajeMenu> puntajesMenu);
	
}
