package ar.edu.unlam.tallerweb1.controladores;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoDeMenu;
import ar.edu.unlam.tallerweb1.servicios.ServListadoOpcionesComida;

@Controller
public class ControladorMenuFinal {

	@Inject
	private ServListadoOpcionesComida servicioListadoOpcionesMenuFinal;
	@Inject
	private ServicioIngresoDeMenu servicioIngresoDeMenu;
	
	
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	// Seleccion del Menu  ///////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(path = "/menu-listado", method = RequestMethod.GET)
	public ModelAndView listadoDeOpcionesDeMenu (@RequestParam("q") Long id) {
		ModelMap modelo = new ModelMap();
		modelo.put("fingerfood", servicioListadoOpcionesMenuFinal.listarOpcionesFingerFood());
		modelo.put("entrada", servicioListadoOpcionesMenuFinal.listarOpcionesEntrada());
		modelo.put("platoprincipal", servicioListadoOpcionesMenuFinal.listarOpcionesPlatoPrincipal());
		modelo.put("bebida", servicioListadoOpcionesMenuFinal.listarOpcionesBebida());
		modelo.put("postre", servicioListadoOpcionesMenuFinal.listarOpcionesPostre());
		modelo.put("mesadulce", servicioListadoOpcionesMenuFinal.listarOpcionesMesaDulce());

		modelo.put("id",id);
		return new ModelAndView("listado-opciones-menu-final", modelo);
	}
	
	// Guarda la seleccion del menu
	@RequestMapping(path = "/registrar-menu", method = RequestMethod.POST)
	public ModelAndView registrarMenu (@RequestParam ("id") Long id,
									   @ModelAttribute ("eleccionfingerfood") Long fingerfood,
			                           @ModelAttribute ("eleccionentrada") Long entrada,
									   @ModelAttribute ("eleccionplatoprincipal") Long platoprincipal,
									   @ModelAttribute ("eleccionbebida") Long bebida,
									   @ModelAttribute ("eleccionpostre") Long postre,
									   @ModelAttribute ("eleccionmesadulce") Long mesadulce) {

		servicioIngresoDeMenu.guardarSeleccionMenu(id,fingerfood, entrada, platoprincipal, bebida, postre, mesadulce);
		//return new ModelAndView("ingreso-tipo-menu");
		return new ModelAndView("redirect:/SeleccionDeExtras?idReserva="+id+"");
	}
	
}
