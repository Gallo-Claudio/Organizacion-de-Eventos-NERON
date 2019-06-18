package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresoTipoDeMenuDao;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;


@Service("servicioIngresoTipoMenu")
@Transactional
public class ServicioIngresoTipoDeMenuImpl implements ServicioIngresoTipoDeMenu {

	@Inject
	private IngresoTipoDeMenuDao servicioIngresoTipoEventoDao;

	@Override
	public void ingresarNuevoTipoDeMenu(TipoDeMenu tipoDeMenu) {  	
		servicioIngresoTipoEventoDao.ingresarNuevoMenuDao(tipoDeMenu);  //Paso el objeto tipoDeMenu que recibo del Controller hacia el DAO
	}

}
