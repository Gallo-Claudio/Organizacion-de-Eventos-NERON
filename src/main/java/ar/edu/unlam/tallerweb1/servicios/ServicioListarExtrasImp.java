package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoExtrasDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;



@Service("servicioListarExtras")
@Transactional
public class ServicioListarExtrasImp implements ServicioListarExtras {

	@Inject
	private ListadoExtrasDao servicioListadoExtrasDao;

	@Override
	public List<Extras> listarExtras() {
		return servicioListadoExtrasDao.listaExtras();
	}


}
