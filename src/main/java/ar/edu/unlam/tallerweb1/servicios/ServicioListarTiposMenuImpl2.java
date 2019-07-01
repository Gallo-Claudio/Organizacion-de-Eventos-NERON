package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ListadoTiposMenuDao;
import ar.edu.unlam.tallerweb1.dao.ListadoTiposMenuDao2;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;


@Service("servicioListarTiposMenu2")
@Transactional
public class ServicioListarTiposMenuImpl2 implements ServicioListarTiposMenu2 {

	@Inject
	private ListadoTiposMenuDao2 servicioListadoTiposMenuDao2;

	@Override
	public List<TipoDeMenu> listarTipoDeMenus2() {
		// Llamo al metodo "listarTiposDeMenus()" de la instancia "servicioListadoTiposMenuDao", que esta en el area del DAO
		// El valor obtenido es retornado
		return servicioListadoTiposMenuDao2.listarTiposDeMenus2();
	}

}
