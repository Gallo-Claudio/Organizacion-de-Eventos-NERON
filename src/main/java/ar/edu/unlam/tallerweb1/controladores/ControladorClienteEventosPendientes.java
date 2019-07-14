package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioEventosPendientes;
import ar.edu.unlam.tallerweb1.servicios.ServicioResumen;


@Controller
public class ControladorClienteEventosPendientes {

	
	@Inject
	private ServicioEventosPendientes servicioEventosPendientes;
	@Inject
	private ServicioResumen servicioResumen;

	  
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado de eventos pendientes del CLIENTE  ///////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/eventos-pendientes-cliente")
	public ModelAndView eventosPendientesCliente (HttpServletRequest request) {
		
		if(request.getSession().getAttribute("ROL").equals("2")) {
			ModelMap model = new ModelMap();
			LocalDate fechaActual = LocalDate.now();
			
			
			
			// Obtengo datos del usuario logueado
			String nombreUsuario = (request.getSession().getAttribute("nombre").toString());
			Long idUser= Long.parseLong(request.getSession().getAttribute("logueado").toString());
			
			Set <Reserva> listadoEventosCliente = new TreeSet();
			listadoEventosCliente = servicioEventosPendientes.listadoDeEventosPendientesDelCliente(fechaActual, idUser);
		
			model.put("usuario", nombreUsuario);
			model.put("listadoPendientesCliente", listadoEventosCliente);

			return new ModelAndView("eventos-pendientes-cliente", model);
		}
		
		return new ModelAndView("redirect:/homeAdmin");
	}
	
	
	@RequestMapping(path = "/listado-eventos-pendientes-cliente", method = RequestMethod.POST)
	public ModelAndView listadoEventosPendientesCliente (@ModelAttribute("idreserva") Long idreserva) {
	Reserva reservafinal = servicioResumen.buscarDatos(idreserva);	
	List<Double> precios = servicioResumen.calculaCostoTotal(reservafinal);
	
	ModelMap model = new ModelMap();
	model.put("reservafinal", reservafinal);
	model.put("menuseleccionado", reservafinal.getMenu());
	model.put("extraseleccionado", reservafinal.getExtra());
	model.put("precios", precios);
	
	return new ModelAndView("resumen-seleccion", model);
	
	
	}
	
	}