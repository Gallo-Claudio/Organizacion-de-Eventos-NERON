package ar.edu.unlam.tallerweb1.controladoresTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.controladores.ControladorMenu;
import ar.edu.unlam.tallerweb1.dao.ListadoOpcionesMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarTiposMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;



public class ControladorMenuMockTest extends SpringTest {

	@Test
	public void testQuePruebaListadoDeOpcionesDeMenu() {
		ControladorMenu miControladorMenu = new ControladorMenu();
//		Usuario usuario = new Usuario();
//		usuario.setId(2L);
		Usuario usuario = mock(Usuario.class);
		
		HttpServletRequest request = mock(HttpServletRequest.class);

		HttpSession misession= request.getSession(true);
		misession.setAttribute("usuario",usuario);
		

		ServicioListadoOpcionesMenu servicioListadoOpcionesMenu = mock(ServicioListadoOpcionesMenu.class);
		miControladorMenu.setServicioListadoOpcionesMenu(servicioListadoOpcionesMenu);
		List<Menu> menu = mock(List.class);
		when(servicioListadoOpcionesMenu.listarOpcionesMenu()).thenReturn(menu);
		
		ServicioListarTiposMenu servicioListarTiposMenu = mock(ServicioListarTiposMenu.class);
		miControladorMenu.setServicioListarTiposMenu(servicioListarTiposMenu);
		List<TipoDeMenu> tipoMenu = mock(List.class);
		when(servicioListarTiposMenu.listarTipoDeMenus()).thenReturn(tipoMenu);
		
		
		ModelAndView modelAndView = miControladorMenu.listadoDeOpcionesDeMenu(request);

		assertThat(modelAndView.getViewName() ).isEqualTo("listado-opciones-menu");
	}
}