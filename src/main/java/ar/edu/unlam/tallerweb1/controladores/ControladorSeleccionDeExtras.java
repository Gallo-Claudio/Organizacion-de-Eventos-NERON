package ar.edu.unlam.tallerweb1.controladores;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaSeleccionExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccionoExtra;



@Controller
public class ControladorSeleccionDeExtras {
	
	@Inject
	private ServicioListaSeleccionExtras servicioListaSeleccionExtras;
	@Inject
	private ServicioSeleccionoExtra servicioSeleccionoExtra;
	
	@RequestMapping(path = "/SeleccionDeExtras", method = RequestMethod.GET )
	public ModelAndView seleccionExtras () {
		ModelMap model = new ModelMap ();
		Extras extras = new Extras();
		model.put("extras", extras);
		return new ModelAndView ("seleccion-extras",model);
	}
	
	@RequestMapping(path = "/Seleccion-Extras", method = RequestMethod.POST)
	public ModelAndView seleccionExtras2 (@ModelAttribute ("extras")Extras extras, HttpServletRequest request) {
		servicioSeleccionoExtra.seleccionarExtra(extras);
		return new ModelAndView ("redirect:/SeleccionDeExtras");
		
	}
	
	@RequestMapping(path = "/listado-extra", method = RequestMethod.GET)
	public ModelAndView listadoDeOpcionesDeExtras () {
		ModelMap modelo = new ModelMap();
		modelo.put("listaSeleccionDeExtras", servicioListaSeleccionExtras.listarSeleccionExtras());
		return new ModelAndView("listado-seleccion-extras", modelo);
	}
	
}