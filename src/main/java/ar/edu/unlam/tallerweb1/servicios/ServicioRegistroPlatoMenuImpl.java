package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;


@Service("servicioRegistroPlatoMenu")
@Transactional
public class ServicioRegistroPlatoMenuImpl implements ServicioRegistroPlatoMenu {

	@Inject
	private RegistroPlatosMenuDao registroPlatosMenuDao;

	@Override
	public void ingresarPlatosAlMenu(Menu menu) {  	
		registroPlatosMenuDao.registraPlatosAlMenu(menu);  //Paso el objeto persona que recibo del Controller hacia el DAO
	}

}
