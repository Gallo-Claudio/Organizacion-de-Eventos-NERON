package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.SeleccionoExtraDao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Reserva;



@Service("servicioSeleccionoExtra")
@Transactional
public class ServicioSeleccionoExtraImp implements ServicioSeleccionoExtra {

	@Inject //hace el new de la implementacion. cuando llamo a servicio ingreso usuario dao
	private SeleccionoExtraDao servicioSeleccionoExtraDao; //objeto


	@Override
	public void guardarExtra(Long id,Extras extras) {

		Reserva reserva = servicioSeleccionoExtraDao.traerReserva(id);
         reserva.setExtras(extras);
		servicioSeleccionoExtraDao.guardarExtra(reserva);

	}



														//servicioSeleccionoExtraDao.guardarExtra(Extras);


}