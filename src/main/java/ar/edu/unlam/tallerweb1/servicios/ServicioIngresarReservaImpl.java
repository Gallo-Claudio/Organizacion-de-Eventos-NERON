package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresarPuntajeDao;
import ar.edu.unlam.tallerweb1.dao.IngresarReservaDao;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Service("servicioIngresarReserva")
@Transactional
public class ServicioIngresarReservaImpl implements ServicioIngresarReserva {

	
	@Inject
	private IngresarReservaDao ingresarReservaDao;
	
	@Override
	public void ingresarReserva(Reserva reserva) {
		
		ingresarReservaDao.ingresarReserva(reserva);
		
	}
	
	

}
