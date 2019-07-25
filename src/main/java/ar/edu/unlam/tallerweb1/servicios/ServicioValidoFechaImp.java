package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Salon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.BuscoFechaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroFechaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioBuscoFecha")
@Transactional
public class ServicioValidoFechaImp implements ServicioValidoFecha {

	@Inject
	private BuscoFechaDao registroBuscoFechaDao;
	
	@Inject
	private ServicioRegistroFecha servicioRegistroFecha;
	

	
	
	@Override
	public Boolean buscoFecha(Long idPersonal, LocalDate fechaAusencia2) {
		if(registroBuscoFechaDao.buscoFechasDeLicenciaPorIdDePersonal(idPersonal)!=null){
		return false;
	}else {
		return true;
	}
	}


//	@Override
//	public Boolean buscoFecha(Long idPersonal, String fecha) {
//		
//	}
}

