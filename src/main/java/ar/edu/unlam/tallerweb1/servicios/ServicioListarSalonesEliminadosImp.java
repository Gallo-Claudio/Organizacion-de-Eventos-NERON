package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoExtrasDao;
import ar.edu.unlam.tallerweb1.dao.ListadoSalonesEliminadosDao;
import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Salon;



@Service("servicioListarSalonesEliminados")
@Transactional
public class ServicioListarSalonesEliminadosImp implements ServicioListarSalonesEliminados {

	@Inject
	private ListadoSalonesEliminadosDao servicioListadoSalonesElimiandosDao;



	@Override
	public List<Salon> listarSalonesEliminados() {
		return servicioListadoSalonesElimiandosDao.listarSalonesEliminados();
	}



}
