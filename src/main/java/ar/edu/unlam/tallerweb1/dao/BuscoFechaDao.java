package ar.edu.unlam.tallerweb1.dao;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


public interface BuscoFechaDao {

//	List <Licencia> buscoFecha (Long idPersonal, LocalDate fechaAusencia2);
	public List <Licencia> buscoFechasDeLicenciaPorIdDePersonal (Long idPersonal);
	
}
