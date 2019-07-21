package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Licencia;


public interface ListadoFechasDao{
	
	List<Licencia> listarFechas ();
}