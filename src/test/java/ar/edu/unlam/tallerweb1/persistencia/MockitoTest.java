package ar.edu.unlam.tallerweb1.persistencia;
import static org.assertj.core.api.Assertions.assertThat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorPersonal;
import ar.edu.unlam.tallerweb1.controladores.ControladorPuntuarMenu;
import ar.edu.unlam.tallerweb1.modelo.CategoriaPersonal;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioEventosPendientes;

public class MockitoTest {
	
@SuppressWarnings(value = { "" })           /*@ SuppressWarnings ("sin marcar") 
											le dice al compilador que el programador cree que el código es seguro 
											y que no causará excepciones inesperadas.*/
@Test
@Transactional 
@Rollback(true)

public void pruebaLoginRolAdmin(){
	
	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	HttpSession sessionMock = mock(HttpSession.class);
	
	ControladorPersonal controladorPersonal = new ControladorPersonal();
	String usuarioRol = "admin";
	
	when (requestMock.getSession()).thenReturn(sessionMock);
	
	when (requestMock.getSession().getAttribute("ROL")).thenReturn(usuarioRol);
	
	ModelAndView modelandview = controladorPersonal.listarTrabajoPersonal(requestMock);
	assertThat(modelandview.getViewName()).isEqualTo("redirect:/home");
	
}

//@SuppressWarnings(value = { "" })/*@ SuppressWarnings ("sin marcar") 
//								   le dice al compilador que el programador cree que el código es seguro 
//								   y que no causará excepciones inesperadas.*/
//@Test
//@Transactional 
//@Rollback(true)
//public void ObtenerEventosPendientes() {
//	
//	HttpServletRequest request = mock(HttpServletRequest.class);
//	ServicioEventosPendientes servicioEventosPendientesmock = mock(ServicioEventosPendientes.class);
//	HttpSession sessionMock = mock(HttpSession.class);
//	
//	
//	
////	Personal p = mock(Personal.class);
////	CategoriaPersonal cp = mock(CategoriaPersonal.class);
//	
//	Set <Reserva> listadoDeEventosPendientes=mock(Set.class);
//	ControladorPersonal controladorPersonal = mock(ControladorPersonal.class);
//	
//	
//}
//

}
