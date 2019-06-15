package ar.edu.unlam.tallerweb1.servicios;
 
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresarDatosReservaDao;
import ar.edu.unlam.tallerweb1.dao.IngresarPuntajeDao;

@Service("servicioIngresarDatosReserva")
@Transactional
public class ServicioIngresarDatosReservaImplementacion implements ServicioIngresarDatosReserva {

	
	@Inject
	private IngresarDatosReservaDao ingresardatosReserva;
	
	@Override
	public void ingresarDatosReserva(String fecha, String zona, Integer numeroInvitados, String nombre, String apellido,
			String email, String fingerFood, String bebidas, String evento) {
		
		ingresardatosReserva.ingresarDatosReserva(fecha, zona, numeroInvitados, nombre, apellido, email, fingerFood, bebidas, evento);
		
		
	}

	
}
