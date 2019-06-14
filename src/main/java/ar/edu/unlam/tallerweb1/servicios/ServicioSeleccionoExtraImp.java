package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresoExtraDao;
import ar.edu.unlam.tallerweb1.dao.SeleccionoExtraDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;



@Service("servicioSeleccionoExtra")
@Transactional
public class ServicioSeleccionoExtraImp implements ServicioSeleccionoExtra {

	@Inject //hace el new de la implementacion. cuando llamo a servicio ingreso usuario dao
	private SeleccionoExtraDao servicioSeleccionoExtraDao; //objeto


	@Override
	public void seleccionarExtra(Extras extras) {
		servicioSeleccionoExtraDao.seleccionarExtra(extras);
		
	}

}
