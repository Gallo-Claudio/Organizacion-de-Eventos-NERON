package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroExtraDao;
import ar.edu.unlam.tallerweb1.dao.RegistroExtrasMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroMenuDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Service("servicioRegistroMenuExtras")
@Transactional
public class ServicioRegistroMenuExtrasImpl implements ServicioRegistroMenuExtras {

	@Inject
	private RegistroExtrasMenuDao registroExtrasMenuDao;
	@Inject
	private RegistroExtraDao registroExtraDao;


	public void ingresarExtraSeleccionado(Long id,Long idextra[]) {
		Reserva reservaExtra =registroExtraDao.traerReserva(id);
		List<Extras> extraElegido = new ArrayList();

		   int arrayLength = idextra.length;

		    for (int i=0; i<arrayLength; i++) {
		    	Long id1 = idextra[i];
		    	extraElegido.add(registroExtrasMenuDao.traerExtraPorId(id1));
		    }

		    reservaExtra.setExtras(extraElegido);
		    

		registroExtraDao.registraExtraEnReserva(reservaExtra);
		
	}

}
