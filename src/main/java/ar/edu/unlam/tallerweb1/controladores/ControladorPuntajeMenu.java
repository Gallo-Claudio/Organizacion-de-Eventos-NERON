package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarPuntajesMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarTiposMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPlatoMenu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistroPuntaje;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


@Controller
public class ControladorPuntajeMenu {

	@Inject
	private ServicioListarPuntajesMenu servicioListarPuntajesMenu;
	
	@Inject
	private ServicioRegistroPuntaje servicioRegistroPuntaje;
	

	
	 @RequestMapping(path="/puntaje")
	 public ModelAndView ingresarPuntaje() {
		 ModelMap modelo = new ModelMap();
		 return new ModelAndView("puntaje", modelo);
	}
	
	 @RequestMapping(path="/ingresar-puntaje", method = RequestMethod.POST)
	 public ModelAndView tomarPuntajes (@ModelAttribute("puntajesMenu")List<PuntajeMenu> puntajesMenu,
			 							@ModelAttribute ("tipoDeEvento") Long tipodemenu) {
		 ModelMap model = new ModelMap();
		 model.put("listaPuntaje", servicioListarPuntajesMenu.listarPuntajesMenu());
		 servicioRegistroPuntaje.ingresarPuntaje(puntajesMenu,tipodemenu);
		 
		 return new ModelAndView ("puntaje",model);
		 
		 
		 
	 }
	 
	
	
	
	
	
}
