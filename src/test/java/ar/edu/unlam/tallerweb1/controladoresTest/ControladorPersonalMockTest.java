package ar.edu.unlam.tallerweb1.controladoresTest;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorPersonal;
import ar.edu.unlam.tallerweb1.dao.PersonalDao;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioEventosPendientes;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonalImpl;

import static org.assertj.core.api.Assertions.assertThat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unused")
public class ControladorPersonalMockTest extends SpringTest {

	@Test
	public void testQueVerificaControlDeServiciosPrestados() {

		////////////////////////////////////////////////////////////////////////////////////////////////////////
		//  PREPARACION   //////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		ServicioPersonalImpl miServicioPersonal = new ServicioPersonalImpl();
		List<Reserva> miReserva = new ArrayList();
		PersonalDao miPersonalDao = mock(PersonalDao.class);
		when(miPersonalDao.traerReservas()).thenReturn(miReserva);
		miServicioPersonal.setPersonalDao(miPersonalDao);

		////////////////////////////////////////////////////////////////////////////////////////////////////////
		//  EJECUCION   ////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////		
		List<Personal> miPersonalMock = miServicioPersonal.controlDeServiciosPrestados();

		////////////////////////////////////////////////////////////////////////////////////////////////////////
		//  CONSTATACION   /////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////		
		assertThat(miPersonalMock).isNotNull();
	}
}