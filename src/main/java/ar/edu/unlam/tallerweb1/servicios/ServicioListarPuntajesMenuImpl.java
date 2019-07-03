package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoPuntajeMenuDao;
import ar.edu.unlam.tallerweb1.dao.ListadoTiposMenuDao;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;


@Service("servicioListarPuntajesMenu")
@Transactional
public class ServicioListarPuntajesMenuImpl implements ServicioListarPuntajesMenu {

	@Inject
	private ListadoPuntajeMenuDao servicioListadoPuntajesMenuDao;

		
		
	
	@Override
	public List<TipoDeMenu> listarPuntajesMenu() {
		return servicioListadoPuntajesMenuDao.listarPuntajesMenu();
	}

}
