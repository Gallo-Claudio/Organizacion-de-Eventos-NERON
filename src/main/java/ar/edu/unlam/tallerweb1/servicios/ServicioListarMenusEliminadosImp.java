package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoExtrasDao;
import ar.edu.unlam.tallerweb1.dao.ListadoMenuEliminadosDao;
import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Menu;



@Service("servicioListarMenusEliminados")
@Transactional
public class ServicioListarMenusEliminadosImp implements ServicioListarMenusEliminados {

	@Inject
	private ListadoMenuEliminadosDao servicioListadoMenuEliminadosDao;


	@Override
	public List<Menu> listarMenuEliminado() {
		return servicioListadoMenuEliminadosDao.listaMenusEliminados();
	}



}
