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

import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.servicios.ServicioPersonal;


@Controller
public class ControladorPersonal {

	@Inject
	private ServicioPersonal servicioPersonal;


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
		List <Long> personalDelEvento = new ArrayList <Long> ();
		Map <Long, Integer> conteo = new HashMap();

		// Realizo una iteracion del listado general de asistencias de los empleados. Ese listado es
		// devuelto por (servicioPersonal.controlDeServiciosPrestados ---> Devuelve una coleccion List <Personal>)
		Iterator<Personal> p = servicioPersonal.controlDeServiciosPrestados().iterator();
		Personal personal;
		while (p.hasNext()) {
			personal=p.next();
			
			// De dicha iteracion, extraigo el Id de cada empleado y lo guardo en un Map llamado conteo.
			// Alli, guardo en la key el numero de Id y en el value guardo las veces que trabajo.
			// Dicho conteo lo realizo al comparar si el Id de extraido ya existe (si ya fue agregado) al Map, 
			// de ya estar, sumo una unidad en el "value". De no estar el Id, es agregado al Map en la "key"
	        if(conteo.containsKey(personal.getId())){
	        	conteo.put(personal.getId(),conteo.get(personal.getId())+1);
	         }
	         else{
	            conteo.put(personal.getId(),1);
	         }
		}
	
		// El Map luego es ordenado de forma ascendente considerando la asistencia del personal ("value" de la coleccion Map)
		Map <Long,Integer> conteoOrdenadoAscendentementePorAsistencia = servicioPersonal.sortByAsc(conteo);
		
		// Cantidad de personal necesario para cubrir el evento
		Integer personalNecesario = servicioPersonal.calcularPersonal();
		
		// Itero las entradas (representadas por key/value) del Map
		Iterator entries = conteoOrdenadoAscendentementePorAsistencia.entrySet().iterator();
		
		// Recorro N veces (donde N es la cantidad de personal requerido) el Map
		for(int i=0;i<personalNecesario;i++) {
				 Map.Entry <Long,Integer> entry = (Map.Entry) entries.next(); 
				 
				 // Obtengo el Id atraves del key
				 Long key = (Long)entry.getKey();
				 
				 // Agrego el Id obtenido a la coleccion del tipo List
				 personalDelEvento.add(key);	     
			 }

		servicioPersonal.consultarPersonal(personalDelEvento);
		return new ModelAndView("ingreso-menu");
	}


	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Listado general ///////  NO ES DE UTILIDAD PARA LA APLICACION  ///////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
	@RequestMapping(path = "/listar-personal", method = RequestMethod.GET)
	public ModelAndView listarPersonalAsignadoAlEvento() {
		
		ModelMap model = new ModelMap();
		model.put("listado", servicioPersonal.controlDeServiciosPrestados());
		
		return new ModelAndView("listar-personal", model);
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// listado de las veces trabajadas por cada empleado   //////////////////////////////////////////////////////////////
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

		Map<Long,Integer> conteoOrdenadoAscendentementePorAsistencia = servicioPersonal.sortByAsc(conteo);

        ModelMap model = new ModelMap();
		model.put("asistencia", conteoOrdenadoAscendentementePorAsistencia);
		
		return new ModelAndView("trabajo-personal", model);
	}
	
}
