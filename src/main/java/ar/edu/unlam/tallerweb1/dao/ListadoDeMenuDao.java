package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.FingerFood;
import ar.edu.unlam.tallerweb1.modelo.MesaDulce;
import ar.edu.unlam.tallerweb1.modelo.PlatoPrincipal;
import ar.edu.unlam.tallerweb1.modelo.Postre;

public interface ListadoDeMenuDao{
	
	List<FingerFood> listadoOpcionesDeFingerFood ();
	List<Entrada> listadoOpcionesDeEntrada ();
	List<PlatoPrincipal> listadoOpcionesDePlatoPrincipal ();
	List<Bebida> listadoOpcionesDeBebidas ();
	List<Postre> listadoOpcionesDePostres ();
	List<MesaDulce> listadoOpcionesDeMesaDulce ();
	
}
