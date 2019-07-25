package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;

import ar.edu.unlam.tallerweb1.modelo.Licencia;

public interface ServicioValidoFecha {
	
	 Boolean buscoFecha(Long idPersonal, LocalDate fecha);
}
