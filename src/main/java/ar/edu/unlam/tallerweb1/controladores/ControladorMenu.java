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

import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarTiposMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPlatoMenu;


@Controller
public class ControladorMenu {


	@Inject
	private ServicioListarTiposMenu servicioListarTiposMenu;
	@Inject
	private ServicioRegistroPlatoMenu servicioRegistroPlatoMenu;
	@Inject
	private ServicioListadoOpcionesMenu servicioListadoOpcionesMenu;
	@Inject
	private ServicioRegistroMenu servicioRegistroMenu;



	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Ingreso de los diferentes platos que integran el Menu o Carta  //////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Se pasa un objeto vacio a la vista para ingresar los datos correspondientesy se recibe y pasa a la vista un listado de los diferentes tipos de menu
	@RequestMapping(path = "/ingresar-menu", method = RequestMethod.GET)
	public ModelAndView ingresarMenu() {
		ModelMap model = new ModelMap();
		// Llamo al metodo "listarTiposDeMenus()" de la instancia "servicioListarTiposMenu", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		model.put("listatiposmenu", servicioListarTiposMenu.listarTipoDeMenus());
		return new ModelAndView("ingreso-menu", model);
	}

	// Ingreso de los distintos platos/bebidas/postres que compondr�n las opciones a elegir opr parte del cliente
	@RequestMapping(path = "/registro-plato-menu", method = RequestMethod.POST)
	public ModelAndView registroPlatosMenu2 (@ModelAttribute ("descripcion") String descripcion, @ModelAttribute ("costo") Integer costo, @ModelAttribute ("tipoDeEvento") Long tipodemenu) {
		ModelMap model = new ModelMap();
		model.put("listatiposmenu", servicioListarTiposMenu.listarTipoDeMenus());
		servicioRegistroPlatoMenu.ingresarPlatosAlMenu(descripcion, costo, tipodemenu);   // Paso los parametros que recibo desde el formulario a traves del ModelAttribute, al area de Servicios desde donde se maneja la l�gica
		return new ModelAndView("ingreso-menu", model); // Retorna a la vista del formulario (ingreso menu)
	}


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Seleccion del Menu  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Muestra el listado de los diferentes platos/bebidas/postres que componen el men�, para que el cliente seleccione entre ellos
	@RequestMapping(path = "/listado-menu", method = RequestMethod.GET)
	public ModelAndView listadoDeOpcionesDeMenu (@RequestParam("q") Long id) {
		ModelMap modelo = new ModelMap();
		modelo.put("id",id);
		// Llamo al metodo "listarOPcionesMenu()" de la instancia "servicioListarPersonas", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		modelo.put("listaopciones", servicioListadoOpcionesMenu.listarOpcionesMenu());
		modelo.put("secciones", servicioListarTiposMenu.listarTipoDeMenus());
		return new ModelAndView("listado-opciones-menu", modelo);
	}

	@RequestMapping(path = "/registra-reserva-menu", method = RequestMethod.GET)
	public ModelAndView registraReservaMenu (@RequestParam ("id") Long id, @RequestParam(value = "idmenu") Long pasaidmenu[], HttpServletRequest request) {

		servicioRegistroMenu.ingresarMenuSeleccionado(id,pasaidmenu);
		return new ModelAndView("redirect:/SeleccionDeExtras?idReserva="+id+"");

	}

}
