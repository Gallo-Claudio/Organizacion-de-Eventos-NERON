package ar.edu.unlam.tallerweb1.controladores;
import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;


import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

	private ServicioLogin servicioLogin;



	// Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		// Se agrega al modelo un objeto del tipo Usuario con key 'usuario' para que el mismo sea asociado
		// al model attribute del form que esta definido en la vista 'login'
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		// Se va a la vista login (el nombre completo de la lista se resuelve utilizando el view resolver definido en el archivo spring-servlet.xml)
		// y se envian los datos a la misma  dentro del modelo
		return new ModelAndView("login", modelo);
	}

	// Este metodo escucha la URL validar-login siempre y cuando se invoque con metodo http POST
	// El método recibe un objeto Usuario el que tiene los datos ingresados en el form correspondiente y se corresponde con el modelAttribute definido en el
	// tag form:form
	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {

	private ServicioIngresoExtras servicioIngresoExtras;

	@Inject
	private ServicioListarExtras servicioListarExtras;

	@Inject
	private ServicioSeleccionoExtra servicioSeleccionoExtra;

	@Inject
	private ServicioListaSeleccionExtras servicioListaSeleccionExtras;

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
<<<<<<< HEAD

=======

	@RequestMapping(path = "/seleccion-extras", method = RequestMethod.GET)
	public ModelAndView ingresoDeExtras2() {
		Extras Extras = new Extras();
		ModelMap model = new ModelMap();
		model.put("Extras", Extras);
		return new ModelAndView("seleccion-extras", model);
	}


	@RequestMapping(path = "/sele-extras", method = RequestMethod.POST)
	public ModelAndView registroExtras2 (@ModelAttribute ("Extra") Extras Extra ){
		servicioSeleccionoExtra.guardarExtra(Extra);
		return new ModelAndView("redirect:/seleccion-extras");
	}



>>>>>>> julieta
	@RequestMapping(path = "/SeleccionDeExtras", method = RequestMethod.GET)
	public ModelAndView listadoExtras2 () {
		ModelMap modelo = new ModelMap();
		modelo.put("listadoFinal2", servicioListaSeleccionExtras.listarSeleccionExtras());
		return new ModelAndView("listado-seleccion-extras", modelo);
	}

}
