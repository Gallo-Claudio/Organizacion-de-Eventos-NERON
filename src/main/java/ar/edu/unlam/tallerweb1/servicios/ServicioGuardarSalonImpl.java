package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.SalonDao;
import ar.edu.unlam.tallerweb1.modelo.Salon;

@Service("servicioGuardarSalon")
@Transactional
public class ServicioGuardarSalonImpl implements ServicioGuardarSalon {
	

	@Inject
	private SalonDao ingresarSalonDao;
	
	

	



	@Override
	public void guardarSalon(Salon salon) {
		ingresarSalonDao.guardarSalon(salon);
		
	}

}
