package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoOpcionesMenuDao;
import ar.edu.unlam.tallerweb1.dao.ListadoOpcionesMenuDao2;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Menu2;

@Service("servicioListadoOpcionesMenu2")
@Transactional
public class ServicioListadoOpcionesMenuImpl2 implements ServicioListadoOpcionesMenu2 {

	@Inject
	private ListadoOpcionesMenuDao2 listadoOpcionesMenuDao2;


	@Override
	public List<Menu2> listarOpcionesMenu2() {
		// Llamo al metodo "listadoOpcionesDeMenu()" de la instancia "listadoOpcionesMenuDao", que esta en el area del DAO
		// El valor obtenido es retornado
		return listadoOpcionesMenuDao2.listadoOpcionesDeMenu2();
	}
}
