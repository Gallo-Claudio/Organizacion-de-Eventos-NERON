package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;


@Service("servicioRegistroPlatoMenu")
@Transactional
public class ServicioRegistroPlatoMenuImpl implements ServicioRegistroPlatoMenu {

	@Inject
	private RegistroPlatosMenuDao registroPlatosMenuDao;

	@Override
	public void ingresarPlatosAlMenu(String descripcion, Integer costo, Long tipodemenu) {
		Menu menu = new Menu ();
		menu.setDescripcion(descripcion);
		menu.setCosto(costo);
		menu.setTipoDeEvento(registroPlatosMenuDao.traerTipoDeMenuPorId(tipodemenu));
		registroPlatosMenuDao.registraPlatosAlMenu(menu);
	}

}