package ar.edu.unlam.tallerweb1.controladores;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.tool.schema.extract.internal.SequenceInformationExtractorH2DatabaseImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresoExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaSeleccionExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarTiposMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonal;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroExtras;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPlatoMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioResumen;
import ar.edu.unlam.tallerweb1.servicios.ServicioSeleccionoExtra;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroExtrasViewModel;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


@Controller
public class ControladorExtras {
	
	@Inject
	private ServicioIngresoExtras servicioIngresoExtras;		
	@Inject
	private ServicioListarExtras servicioListarExtras;	
	@Inject
	private ServicioSeleccionoExtra servicioSeleccionoExtra;	
	@Inject 
	private ServicioListaSeleccionExtras servicioListaSeleccionExtras;	
	@Inject
	private ServicioListadoOpcionesExtras servicioListadoOpcionesExtras;
	@Inject
	private ServicioRegistroExtras servicioRegistroExtras;
	@Inject
	private ServicioResumen servicioResumen;
	@Inject
	private ServicioPersonal servicioPersonal;
	

	
    ///////////////////////////////////////////////////////////////////////////////////////
	// PAGINA PRINCIPAL - INDEX ///////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
//	@RequestMapping(path = "/index", method = RequestMethod.GET)
//	public ModelAndView index() {
//		return new ModelAndView("index");
//	}
	
	/*Lado del administrador*/
	//ADMIN
	@RequestMapping(path = "/ingreso-extras", method = RequestMethod.GET)
	public ModelAndView ingresoDeExtras(HttpServletRequest request) {
		if(request.getSession().getAttribute("ROL")=="1"){

			Extra extras = new Extra();
			ModelMap model = new ModelMap();
			model.put("extras", extras);
			return new ModelAndView("ingreso-extras", model);
		}
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping(path = "/registro-extras", method = RequestMethod.POST)
	public ModelAndView registroExtras (@ModelAttribute ("Extras") Extra extra,
										HttpServletRequest request) {
		servicioIngresoExtras.ingresarExtras(extra);
		return new ModelAndView("redirect:/ingreso-extras"); 
	}
	
	@RequestMapping(path = "/listado-final-extras", method = RequestMethod.GET)
	public ModelAndView listadoExtras (HttpServletRequest request) {
		if(request.getSession().getAttribute("ROL")=="1") {
			ModelMap modelo = new ModelMap();
			modelo.put("listadoFinal", servicioListarExtras.listarExtras());
			return new ModelAndView("listado-final-extras", modelo);
		}
		return new ModelAndView("redirect:/home");
	}
	
	/*Lado Cliente*/
	
	@RequestMapping(path = "/listado-extra", method = RequestMethod.GET)
	public ModelAndView listadoDeOpcionesDeExtras (HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		if(request.getSession().getAttribute("logueado")==null){
			return new ModelAndView("redirect:/home");

		}
		modelo.put("listaopciones", servicioListadoOpcionesExtras.listarOpcionesDeExtras());

		return new ModelAndView("listado-opciones-extra", modelo);
	}

	@RequestMapping(path = "/registra-reserva-extras", method = RequestMethod.POST)
	public ModelAndView registraReservaExtras ( @ModelAttribute("vm") RegistroMenuViewModel vm, HttpServletRequest request) {
		String id=request.getSession().getAttribute("idReserva").toString();
		Long reserva= Long.parseLong(id);
		servicioRegistroExtras.ingresarExtrasSeleccionados(reserva,vm.getIdmenu());
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////
		servicioPersonal.asignaPersonalAlEvento(reserva);
		
		
		//////////////////////////////////////////////////////////////////////////////////////
		Reserva reservafinal = servicioResumen.buscarDatos(reserva);	
		List<Double> precios = servicioResumen.calculaCostoTotal(reservafinal);
		
		ModelMap model = new ModelMap();
		model.put("reservafinal", reservafinal);
		model.put("menuseleccionado", reservafinal.getMenu());
		model.put("extraseleccionado", reservafinal.getExtra());
		model.put("precios", precios);
		
		return new ModelAndView("resumen-seleccion", model);
	}
	
}