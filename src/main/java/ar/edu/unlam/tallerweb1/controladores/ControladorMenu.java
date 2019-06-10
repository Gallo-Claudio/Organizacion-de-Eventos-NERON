package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoTipoDeMenu;


@Controller
public class ControladorMenu {

	@Inject
	private ServicioIngresoTipoDeMenu servicioIngresoTipoDeMenu;

	
	
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
		servicioIngresoTipoDeMenu.ingresarNuevoTipoDeMenu(tipoDeMenuNuevo);   // Paso el objeto "persona" que recibo desde el formulario a traves del ModelAttribute, al area de Servicios desde donde se maneja la lógica
		return new ModelAndView("ingreso-tipo-menu"); // Retorna a la vista del formulario (ingreso de tipos de menu)
	}
	

	
}
