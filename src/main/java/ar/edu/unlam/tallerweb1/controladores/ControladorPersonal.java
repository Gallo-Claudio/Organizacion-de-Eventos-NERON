package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.CategoriaPersonal;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonal;
import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroSalonViewModel;


@Controller
public class ControladorPersonal {

	@Inject
	private ServicioPersonal servicioPersonal;
	
	@Inject
	private ServicioSalon servicioSalon;
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado general de las veces trabajadas por cada empleado   //////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	@RequestMapping(path = "/trabajo-personal", method = RequestMethod.GET)
	public ModelAndView listarTrabajoPersonal() {
		Map<Long, Integer>conteo = new HashMap();

		Iterator<Personal> p = servicioPersonal.controlDeServiciosPrestados().iterator();
		Personal personal;
		while (p.hasNext()) {
			personal=p.next();

	        if(conteo.containsKey(personal.getIdPersonal())){
	        	conteo.put(personal.getIdPersonal(),conteo.get(personal.getIdPersonal())+1);
	         }
	         else{
	            conteo.put(personal.getIdPersonal(),1);
	         }
		}


		// Obtengo el listado de assitencia ordenado por Id
		Map <Long, Integer> listadoAsistencia = new HashMap();
		listadoAsistencia = servicioPersonal.obtencionListadoDeAsistencias();

		// El Map luego es ordenado de forma ascendente considerando la asistencia del personal ("value" de la coleccion Map)
		Map<Long,Integer> conteoOrdenadoAscendentementePorAsistencia = servicioPersonal.OrdenaAscendentemente(listadoAsistencia);


        ModelMap model = new ModelMap();
		model.put("asistencia", conteoOrdenadoAscendentementePorAsistencia);

		return new ModelAndView("trabajo-personal", model);
	}

	
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado del personal asignado a un evento  //////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/listado-personal-asignado")
	public ModelAndView listarPersonalAsignadoAUnEvento () {
		ModelMap model = new ModelMap();
		model.put("listadop", servicioPersonal.listadoPersonalAsignado(106L));

		return new ModelAndView("personal-asignado", model);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado general del personal  ///////  NO ES DE UTILIDAD PARA LA APLICACION POR AHORA ////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/listar-personal", method = RequestMethod.GET)
	public ModelAndView listarPersonalAsignadoAlEvento() {

		ModelMap model = new ModelMap();
		model.put("listado", servicioPersonal.controlDeServiciosPrestados());

		return new ModelAndView("listar-personal", model);
	}


}
