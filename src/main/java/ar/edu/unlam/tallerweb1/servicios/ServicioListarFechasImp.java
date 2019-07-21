package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoExtrasDao;
import ar.edu.unlam.tallerweb1.dao.ListadoFechasDao;
import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Licencia;



@Service("servicioListarFechas")
@Transactional
public class ServicioListarFechasImp implements ServicioListarFechas {

	@Inject
	private ListadoFechasDao servicioListarFechasDao;

	@Override
	public List<Licencia> listarFechas() {
		return servicioListarFechasDao.listarFechas();
	}



}
