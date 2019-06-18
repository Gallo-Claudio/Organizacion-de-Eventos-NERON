package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonal;


@Controller
public class ControladorPersonal {

	@Inject
	private ServicioPersonal servicioPersonal;


	@RequestMapping(path = "/ingresar-personal", method = RequestMethod.GET)
	public ModelAndView ingresarPersonal() {
		List <Long> personalDelEvento = new ArrayList <Long> ();
		personalDelEvento.add(2L);
		personalDelEvento.add(4L);
		personalDelEvento.add(6L);
		personalDelEvento.add(8L);
		personalDelEvento.add(10L);
		personalDelEvento.add(12L);
		personalDelEvento.add(14L);
		
		servicioPersonal.consultarPersonal(personalDelEvento);
		return new ModelAndView("ingreso-menu");
	}

	@RequestMapping(path = "/listar-personal", method = RequestMethod.GET)
	public ModelAndView listarPersonalAsignadoAlEvento() {
		
		ModelMap model = new ModelMap();
		model.put("listado", servicioPersonal.controlDeServiciosPrestados());
		
		return new ModelAndView("listar-personal", model);
	}
	
	@RequestMapping(path = "/trabajo-personal", method = RequestMethod.GET)
	public ModelAndView listarTrabajoPersonal() {
		
		
        Set<Personal> personal = new HashSet<Personal>(servicioPersonal.controlDeServiciosPrestados());
  //      for (Personal p : personal) {
  //         Collections.frequency(servicioPersonal.controlDeServiciosPrestados(), p);
  //      }

        ModelMap model = new ModelMap();
		model.put("asistencia", personal);
		return new ModelAndView("trabajo-personal", model);
	}
}
