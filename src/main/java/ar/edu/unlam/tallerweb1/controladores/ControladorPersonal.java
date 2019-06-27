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


@Controller
public class ControladorPersonal {

	@Inject
	private ServicioPersonal servicioPersonal;
	
	
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Asigna personal a las reservas que aun no lo tienen         //////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/reservas-sin-personal-asignado", method = RequestMethod.GET)
	public ModelAndView listarReservasSinPersonal() {
//		Map<Long, Integer>conteo = new HashMap();

		List <Reserva> reserva = servicioPersonal.listadoDeReservas();
		List <Reserva> reservaSinPersonal = new ArrayList();
		
		Iterator <Reserva> r = reserva.iterator();
		Reserva reservafinal;
		while(r.hasNext()) {
			reservafinal=r.next();
			
			if(reservafinal.getPersonal()==null) {
				reservaSinPersonal.add(reservafinal);
			}	
		}
		

		
		//-----------------------------------------------------
		
		List <Personal> persona = servicioPersonal.sinPersonal();
		List <Personal> reservasinpersona = new ArrayList();
		
		Iterator <Personal> p = persona.iterator();
		Personal personareservafinal;
		while(p.hasNext()) {
			personareservafinal=p.next();
			
			if(personareservafinal.getReserva()!=null) {
				reservasinpersona.add(personareservafinal);
			}	
		}
		
		
		ModelMap model = new ModelMap();
		model.put("listaReservaSinPersonal", reservaSinPersonal);
		model.put("listaSinPersonal", reservasinpersona);
		
		return new ModelAndView("reservas-sin-personal", model);
		
		
		
//		Iterator<Personal> p = servicioPersonal.controlDeServiciosPrestados().iterator();
//		Personal personal;
//		while (p.hasNext()) {
//			personal=p.next();

//	        if(conteo.containsKey(personal.getId())){
//	        	conteo.put(personal.getId(),conteo.get(personal.getId())+1);
//	         }
//	         else{
//	            conteo.put(personal.getId(),1);
//	         }
//		}	
		// Obtengo el listado de assitencia ordenado por Id
//		Map <Long, Integer> listadoAsistencia = new HashMap();
//		listadoAsistencia = servicioPersonal.obtencionListadoDeAsistencias();

		// El Map luego es ordenado de forma ascendente considerando la asistencia del personal ("value" de la coleccion Map)
//		Map<Long,Integer> conteoOrdenadoAscendentementePorAsistencia = servicioPersonal.OrdenaAscendentemente(listadoAsistencia);


//        ModelMap model = new ModelMap();
//		model.put("asistencia", conteoOrdenadoAscendentementePorAsistencia);

//		return new ModelAndView("trabajo-personal", model);
	}
	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Asigna personal al evento contratado de forma automatica. Lo hace equilibrando las veces trabajadas  /////////////////
	// por cada empleado, asegurando de esta forma que no haya disparidad en la asistencia a los eventos ////////////////////
	// Se realiza el siguiente proceso (a grandes rasgos):   ////////////////////////////////////////////////////////////////
	// 1- Obtencion del listado general de asistencias       ////////////////////////////////////////////////////////////////
	// 2- Ordenamiento por Id realizando un conteo de las asistencias     ///////////////////////////////////////////////////
	// 3- Listar en forma ascendente por asistencia         /////////////////////////////////////////////////////////////////
	// 4- Tomar los "n" primeros registros de acuerdo a la cantidad de personal requerido   /////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/asignar-personal-al-evento", method = RequestMethod.GET)
	public ModelAndView ingresarPersonal() {

		// Obtengo el listado de asistencia ordenado por Id -- (paso 1 y 2)
		Map <Long, Integer> listadoAsistencia = new HashMap();
		listadoAsistencia = servicioPersonal.obtencionListadoDeAsistencias();

		// El Map luego es ordenado de forma ascendente considerando la asistencia del personal ("value" de la coleccion Map) -- (paso 3)
		Map <Long, Integer> conteoOrdenadoAscendentementePorAsistencia = servicioPersonal.OrdenaAscendentemente(listadoAsistencia);

		// Recibo la cantidad de personal necesario para cubrir el evento
		List<Integer> personalNecesario = servicioPersonal.calcularPersonal();

		// Genero el listado del personal a asignar de acuerdo a las necesidades del evento  -- (paso 4)
		List <Long> personalDelEvento = servicioPersonal.asignarPersonalNecesario(personalNecesario, conteoOrdenadoAscendentementePorAsistencia);

		// Obtengo el listado del personal asignado
		List<Personal> personalAsignado = servicioPersonal.listadoPersonalAsignado(personalDelEvento);


		// Envio el listado para ser persistido
		servicioPersonal.persisteElListadoDePersonalAsignado (personalAsignado);
		
		// Obtengo el listado de los cargos del personal
		List<CategoriaPersonal> cargosPersonal = servicioPersonal.consultaCargosDelPersonal();

		// Envio el listado a la vista
		ModelMap model = new ModelMap();
		model.put("listadopersonalasignado", personalAsignado);
		model.put("cargos", cargosPersonal);
		model.put("cantidad", personalNecesario);

		return new ModelAndView("personal-asignado", model);
	}


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

	        if(conteo.containsKey(personal.getId())){
	        	conteo.put(personal.getId(),conteo.get(personal.getId())+1);
	         }
	         else{
	            conteo.put(personal.getId(),1);
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
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado general ///////  NO ES DE UTILIDAD PARA LA APLICACION POR AHORA ///////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@RequestMapping(path = "/listar-personal", method = RequestMethod.GET)
	public ModelAndView listarPersonalAsignadoAlEvento() {

		ModelMap model = new ModelMap();
		model.put("listado", servicioPersonal.controlDeServiciosPrestados());

		return new ModelAndView("listar-personal", model);
	}


}
