package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.FingerFood;
import ar.edu.unlam.tallerweb1.modelo.MesaDulce;
import ar.edu.unlam.tallerweb1.modelo.PlatoPrincipal;
import ar.edu.unlam.tallerweb1.modelo.Postre;

// Interface que define los metodos del Servicio de listar opciones del menu
public interface ServListadoOpcionesComida {

	List<FingerFood> listarOpcionesFingerFood();
	List<Entrada> listarOpcionesEntrada();
	List<PlatoPrincipal> listarOpcionesPlatoPrincipal();
	List<Bebida> listarOpcionesBebida();
	List<Postre> listarOpcionesPostre();
	List<MesaDulce> listarOpcionesMesaDulce();	
	
}
