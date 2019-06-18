package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoDeMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.FingerFood;
import ar.edu.unlam.tallerweb1.modelo.MesaDulce;
import ar.edu.unlam.tallerweb1.modelo.PlatoPrincipal;
import ar.edu.unlam.tallerweb1.modelo.Postre;



@Service("servListadoOpcionesComida")
@Transactional
public class ServListadoOpcionesComidaImpl implements ServListadoOpcionesComida {

	@Inject
	private ListadoDeMenuDao listadoOpcionesMenuDaoFinal;



	@Override
	public List<FingerFood> listarOpcionesFingerFood() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDeFingerFood();
	}

	@Override
	public List<Entrada> listarOpcionesEntrada() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDeEntrada();
	}

	@Override
	public List<PlatoPrincipal> listarOpcionesPlatoPrincipal() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDePlatoPrincipal();
	}

	@Override
	public List<Bebida> listarOpcionesBebida() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDeBebidas();
	}

	@Override
	public List<Postre> listarOpcionesPostre() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDePostres();
	}

	@Override
	public List<MesaDulce> listarOpcionesMesaDulce() {
		return listadoOpcionesMenuDaoFinal.listadoOpcionesDeMesaDulce();
	}

}
