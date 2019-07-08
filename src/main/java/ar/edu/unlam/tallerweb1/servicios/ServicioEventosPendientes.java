
package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Reserva;


// Interface que define los metodos del Servicio de eventos pendientes.
public interface ServicioEventosPendientes {

	Set <Reserva> listadoDeEventosPendientes(LocalDate fechaActual);

}
