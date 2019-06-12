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
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaSeleccionExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccionoExtra;



@Controller
public class ControladorLogin {
	
	@Inject
	private ServicioIngresoExtras servicioIngresoExtras;	
	
	@Inject
	private ServicioListarExtras servicioListarExtras;
	
	@Inject
	private ServicioSeleccionoExtra servicioSeleccionoExtra;
	
	/*Lado del administrador*/
	@RequestMapping(path = "/ingreso-extras", method = RequestMethod.GET)
	public ModelAndView ingresoDeExtras() {
		Extras extras = new Extras();
		ModelMap model = new ModelMap();
		model.put("extras", extras);
		return new ModelAndView("ingreso-extras", model);
	}
	
	@RequestMapping(path = "/registro-extras", method = RequestMethod.POST)
	public ModelAndView registroExtras (@ModelAttribute ("Extras") Extras Extras,
										HttpServletRequest request) {
		servicioIngresoExtras.ingresarExtras(Extras);
		return new ModelAndView("redirect:/ingreso-extras"); 
	}
	
	@RequestMapping(path = "/listado-final-extras", method = RequestMethod.GET)
	public ModelAndView listadoExtras () {
		ModelMap modelo = new ModelMap();
		modelo.put("listadoFinal", servicioListarExtras.listarExtras());
		return new ModelAndView("listado-final-extras", modelo);
	}
	
	/*Lado Cliente*/
		
	@RequestMapping(path = "/SeleccionDeExtras", method = RequestMethod.GET)
	public ModelAndView listadoExtras2 (@ModelAttribute ("Extras")Extras Extras) {
		ModelMap modelo = new ModelMap();
		modelo.put("listadoFinal", servicioListarExtras.listarExtras());
		return new ModelAndView("listado-seleccion-extras", modelo);
	}
	
}