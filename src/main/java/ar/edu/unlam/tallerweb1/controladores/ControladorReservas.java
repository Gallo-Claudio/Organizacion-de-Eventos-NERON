package ar.edu.unlam.tallerweb1.controladores;


import java.util.ArrayList;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Domicilio;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.SalonEvento;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultarReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresarClienteDao;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresarDatosReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresarPuntaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioIngresarReserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorReservas {
	

	List<Reserva> reservas= new ArrayList();
	
	
	List<Reserva>recomendadas=new ArrayList();
	
	@Inject
	private ServicioLogin servicioLogin;
	
	
	
	
	
	

	@Inject
	private ServicioIngresarPuntaje servicioIngresarPuntaje;
	
	@Inject
	private ServicioIngresarReserva servicioIngresarReserva;
	
	@Inject
	private ServicioIngresarDatosReserva servicioIngresarDatosReserva;
	
	@Inject
	private ServicioIngresarClienteDao servicioIngresarCliente;
	
	@Inject
	private ServicioConsultarReserva servicioConsultarReserva;
	

	@RequestMapping(path="/reserva")
	public ModelAndView crearReserva() {
		ModelMap modelo= new ModelMap();
		
		Reserva reserva= new Reserva();
		
		
	   
	    
	   
		modelo.put("reservaAttribute",reserva);
		
		return new ModelAndView("reserva",modelo);
		
		
		
	}
	
	@RequestMapping(path="/recibirReserva",method=RequestMethod.POST)
	public ModelAndView verReserva(@ModelAttribute("reservaAttribute") Reserva reserva) {
		ModelMap modelo= new ModelMap();
		
	
		
		servicioIngresarReserva.ingresarReserva(reserva);
		
		
		this.reservas=servicioConsultarReserva.consultarReserva(reserva);
		
		
	
	    
	  
		modelo.put("reservasKey",this.reservas);
		
		return new ModelAndView("reserva",modelo);
		
		
		
	}
	
	
	@RequestMapping(path="/opiniones")
	public ModelAndView verOpiniones() {
		ModelMap modelo= new ModelMap();
		
		
	   
	    Puntaje puntaje = new Puntaje();
	   
		modelo.put("opinionKey",puntaje);
		
		return new ModelAndView("OpinionUsuarios",modelo);
		
		
		
	}
	
	@RequestMapping(path="/recibirOpinion")
	public ModelAndView recibirOpiniones(@ModelAttribute("opinionAttribute") Puntaje puntaje) {
		ModelMap modelo= new ModelMap();
		
		servicioIngresarPuntaje.ingresarPuntaje(puntaje);
		Reserva reserva = new Reserva();
		
		reserva.setPuntaje(puntaje);
		servicioIngresarReserva.ingresarReserva(reserva);
		
		Integer calificacion=0;
		String mensaje4="";
		String mensaje3="";
		String mensaje2="";
		String mensaje1="";
		
		if((puntaje.getEmpleados()== null)){	
			mensaje4="Seleccione una opcion";
		}
		 if(puntaje.getMenu()==null) {
			mensaje3="Seleccione una opcion";
			
		} if(puntaje.getSalon()==null) {
			mensaje2="Seleccione una opcion";
		} if(puntaje.getShow()==null) {
			mensaje1="Seleccione una opcion";
		}else {
		 calificacion= (puntaje.getEmpleados() + puntaje.getMenu()+puntaje.getSalon()+puntaje.getShow())/4;
	   if(calificacion > 70) {
		  this.recomendadas.add(reserva);
		   
	   }}
	    
	   modelo.put("mensaje1",mensaje1);
	   modelo.put("mensaje2",mensaje2);
	   modelo.put("mensaje3",mensaje3);
	   modelo.put("mensaje4",mensaje4);
		
		modelo.put("recomendadas",this.recomendadas);
		
		modelo.put("puntaje",puntaje);
		modelo.put("calificacion",calificacion);
		
		return new ModelAndView("OpinionUsuarios",modelo);
		
		
		
	}

}
