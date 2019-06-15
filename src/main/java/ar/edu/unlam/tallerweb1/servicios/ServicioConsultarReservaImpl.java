package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import ar.edu.unlam.tallerweb1.modelo.Reserva;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("servicioConsultarReserva")
@Transactional
public class ServicioConsultarReservaImpl implements ServicioConsultarReserva {

	
	@Inject
	private ar.edu.unlam.tallerweb1.dao.consultarReservaDao consultarReservaDao;
	
	@Override
	public List<Reserva> consultarReserva(Reserva reserva) {
		
		return consultarReservaDao.consultarReserva(reserva);
		
		
	}

}
