package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao2;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioRegistroMenu2")
@Transactional
public class ServicioRegistroMenuImpl2 implements ServicioRegistroMenu2 {

	@Inject
	private RegistroPlatosMenuDao2 registroPlatosMenuDao2;
	@Inject
	private RegistroMenuDao registroMenuDao;



	@Override
	public void ingresarMenuSeleccionado2(Long id,Long[] idmenu) {
		Reserva reserva=registroMenuDao.traerReserva(id);
		List<Extra> menuElegido = new ArrayList<>();

		  int arrayLength = idmenu.length;

		    for (int i=0; i<arrayLength; i++) {
		    	Long idm = idmenu[i];
		    	menuElegido.add(registroPlatosMenuDao2.traerMenuPorId2(idm));
		    }

		reserva.setMenu2(menuElegido);

		registroMenuDao.registraMenuEnReserva(reserva);
	}

}
