package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoTipoDeMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarTiposMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPlatoMenu;


@Controller
public class ControladorMenu {

	@Inject
	private ServicioIngresoTipoDeMenu servicioIngresoTipoDeMenu;
	@Inject
	private ServicioListarTiposMenu servicioListarTiposMenu;
	@Inject
	private ServicioRegistroPlatoMenu servicioRegistroPlatoMenu;
	@Inject
	private ServicioListadoOpcionesMenu servicioListadoOpcionesMenu;
	
	
	// Ingreso de Tipo de Menu  //////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(path = "/ingresar-tipo-menu", method = RequestMethod.GET)
	public ModelAndView ingresarTipoDeMenu() {
		TipoDeMenu tipoDeMenuNuevo = new TipoDeMenu();
		ModelMap model = new ModelMap();
		model.put("nuevotipomenu", tipoDeMenuNuevo);
		return new ModelAndView("ingreso-tipo-menu", model);
	}
	
	@RequestMapping(path = "/registro-tipo-menu", method = RequestMethod.POST)
	public ModelAndView registroTipoMenu (@ModelAttribute ("agregartipomenu") TipoDeMenu tipoDeMenuNuevo) {
		servicioIngresoTipoDeMenu.ingresarNuevoTipoDeMenu(tipoDeMenuNuevo);   // Paso el objeto tipoDeMenuNuevo que recibo desde el formulario a traves del ModelAttribute, al area de Servicios desde donde se maneja la lógica
		return new ModelAndView("ingreso-tipo-menu"); // Retorna a la vista del formulario (ingreso tipos menu)
	}
	

	// Ingreso de los diferentes platos que integran el Menu  //////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/ingresar-menu", method = RequestMethod.GET)
	public ModelAndView ingresarMenu() {
		ModelMap model = new ModelMap();
		// Llamo al metodo "listarTiposDeMenus()" de la instancia "servicioListarTiposMenu", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		model.put("listatiposmenu", servicioListarTiposMenu.listarTipoDeMenus());
		return new ModelAndView("ingreso-menu", model);
	}
	
	@RequestMapping(path = "/registro-plato-menu", method = RequestMethod.POST)
	public ModelAndView registroPlatosMenu2 (@ModelAttribute ("descripcion") String descripcion, @ModelAttribute ("costo") Integer costo, @ModelAttribute ("tipoDeEvento") Long tipodemenu) {
		ModelMap model = new ModelMap();
		model.put("listatiposmenu", servicioListarTiposMenu.listarTipoDeMenus());
		servicioRegistroPlatoMenu.ingresarPlatosAlMenu(descripcion, costo, tipodemenu);   // Paso los parametros que recibo desde el formulario a traves del ModelAttribute, al area de Servicios desde donde se maneja la lógica
		return new ModelAndView("ingreso-menu", model); // Retorna a la vista del formulario (ingreso menu)
	}
	
	
	
	// Seleccion del Menu  ///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping(path = "/listado-menu", method = RequestMethod.GET)
	public ModelAndView listadoDeOpcionesDeMenu () {
		ModelMap modelo = new ModelMap();
		// Llamo al metodo "listarOPcionesMenu()" de la instancia "servicioListarPersonas", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		modelo.put("listaopciones", servicioListadoOpcionesMenu.listarOpcionesMenu());
		return new ModelAndView("listado-opciones-menu", modelo);
	}
	
}
