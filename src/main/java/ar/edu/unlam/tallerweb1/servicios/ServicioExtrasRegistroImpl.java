package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroExtrasMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;


@Service("servicioExtrasRegistro")
@Transactional
public class ServicioExtrasRegistroImpl implements ServicioExtrasRegistro {

	@Inject
	private RegistroExtrasMenuDao registroExtrasMenuDao;


	

	@Override
	public void ingresarExtrasAlMenu(String nombre, Integer precio) {
		Extras Extras = new Extras ();
		Extras.setNombre(nombre);
		Extras.setPrecio(precio);
		registroExtrasMenuDao.registraExtrasAlMenu(Extras);
	}
		
	}

