package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.dao.ResumenSeleccionDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioResumenSeleccion")
@Transactional
public class ServicioResumenSeleccionImpl implements ServicioResumenSeleccion {

	@Inject
	private ResumenSeleccionDao resumenSeleccionDao;

	

	@Override
	public Reserva buscarDatos(Long idReserva) {
		return resumenSeleccionDao.obtieneDatosReserva(idReserva);
	}

}
