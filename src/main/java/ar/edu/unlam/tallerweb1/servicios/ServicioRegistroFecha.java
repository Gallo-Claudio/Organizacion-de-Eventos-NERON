package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;

import ar.edu.unlam.tallerweb1.modelo.Licencia;

public interface ServicioRegistroFecha {
	
	 void registroFecha(Long idPersonal, LocalDate fechaAusencia);
}
