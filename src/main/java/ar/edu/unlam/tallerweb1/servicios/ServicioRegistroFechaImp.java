package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Salon;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroFechaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioRegistroFecha")
@Transactional
public class ServicioRegistroFechaImp implements ServicioRegistroFecha {

	@Inject
	private RegistroFechaDao registroFechaDao;
	

	@Override
	public void registroFecha(Long idPersonal, LocalDate fechaAusencia) {
		Licencia licencia = new Licencia();
		licencia.setIdLicencia(idPersonal);
		licencia.setFechasLicencias(fechaAusencia);
		
		registroFechaDao.registroFecha(licencia);
		
	}

}
