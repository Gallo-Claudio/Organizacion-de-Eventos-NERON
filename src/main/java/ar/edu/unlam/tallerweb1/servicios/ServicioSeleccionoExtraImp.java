package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.SeleccionoExtraDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;



@Service("servicioSeleccionoExtra")
@Transactional
public class ServicioSeleccionoExtraImp implements ServicioSeleccionoExtra {

	@Inject //hace el new de la implementacion. cuando llamo a servicio ingreso usuario dao
	private SeleccionoExtraDao servicioSeleccionoExtraDao; //objeto


	@Override
	public void guardarExtra(Long id,Long[] listaExtras) {
		Reserva reserva = servicioSeleccionoExtraDao.traerReserva(id);
		List<Extras> extras=new ArrayList<>();
       
		  int arrayLength = listaExtras.length;

		    for (int i=0; i<arrayLength; i++) {
		    	Long idm=listaExtras[i];
		    	extras.add(servicioSeleccionoExtraDao.traerExtraPorId(idm));
		    }
         	    
		    reserva.setExtras(extras);
         
		servicioSeleccionoExtraDao.guardarExtra(reserva);

	}



														//servicioSeleccionoExtraDao.guardarExtra(Extras);


}