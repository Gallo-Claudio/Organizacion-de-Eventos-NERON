package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListarSeleccionExtrasDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;


@Service("servicioListaSeleccionExtras")
@Transactional
public class ServicioListaSeleccionExtrasImp implements ServicioListaSeleccionExtras {

	@Inject
	private ListarSeleccionExtrasDao listarSeleccionExtrasDao;


	@Override
	public List<Extras> listarSeleccionExtras() {
		return listarSeleccionExtrasDao.listarSeleccionExtras();
	}

}
