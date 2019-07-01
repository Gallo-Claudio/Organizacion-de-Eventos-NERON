package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.servicios.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


@Controller
public class ControladorMenu {

	@Inject
	private ServicioRecomendaciones ServicioRecomendaciones;
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
	public ModelAndView listadoDeOpcionesDeMenu (HttpServletRequest request) {
		ModelMap modelo = new ModelMap();

		// Llamo al metodo "listarOPcionesMenu()" de la instancia "servicioListarPersonas", que esta en el area de Servicios.
		// El valor obtenido es agregado como "value" en el model(KEY/VALUE) a traves del .put
		// Para luego pasarlo a la vista a traves del return ModelAndView
		modelo.put("listaopciones", servicioListadoOpcionesMenu.listarOpcionesMenu());
		modelo.put("secciones", servicioListarTiposMenu.listarTipoDeMenus());

		//parte de las recomendaciones de menu
		//obtengo una lista con los menus recomendados , estos menus estan agrupados segun la reserva
		//por eso tengo una lista de menu dentro de otra lista
		ArrayList<ArrayList<Menu>> array=ServicioRecomendaciones.ObtenerRecomendaciones();
		int i=0;
		//voy asignando los menus al modelo
		for(List<Menu> lista:array){
			i+=1;

			modelo.put("menus"+i+"",lista);


		}

       //es la cantidad de menus obtenidos para liego tener un limite al mostrar la vista
		modelo.put("tope",array.size());





		return new ModelAndView("listado-opciones-menu", modelo);
	}

	@RequestMapping(path = "/registra-reserva-menu", method = RequestMethod.POST)

	public ModelAndView registraReservaMenu ( @ModelAttribute("vm") RegistroMenuViewModel vm, HttpServletRequest request) {
		String id=request.getSession().getAttribute("idReserva").toString();
		Long reserva= Long.parseLong(id);
		servicioRegistroMenu.ingresarMenuSeleccionado(reserva,vm.getIdmenu());
		return new ModelAndView("redirect:/home");

	}

}
