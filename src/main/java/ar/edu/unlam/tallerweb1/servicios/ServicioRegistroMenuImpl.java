package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioRegistroMenu")
@Transactional
public class ServicioRegistroMenuImpl implements ServicioRegistroMenu {

	@Inject
	private RegistroPlatosMenuDao registroPlatosMenuDao;
	@Inject
	private RegistroMenuDao registroMenuDao;


	@Override
	public void ingresarMenuSeleccionado(Long idreserva,Long idmenu[] ) {
		Reserva reservaMenu =registroMenuDao.traerReserva(idreserva);
		List<Menu> menuElegido = new ArrayList();

		   int arrayLength = idmenu.length;

		    for (int i=0; i<arrayLength; i++) {
		    	Long id = idmenu[i];
		    	menuElegido.add(registroPlatosMenuDao.traerMenuPorId(id));
		    }

		reservaMenu.setMenu(menuElegido);

		registroMenuDao.registraMenuEnReserva(reservaMenu);
	}

}
