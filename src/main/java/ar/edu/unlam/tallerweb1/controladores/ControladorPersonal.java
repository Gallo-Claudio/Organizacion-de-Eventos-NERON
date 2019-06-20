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


	@RequestMapping(path = "/ingresar-personal", method = RequestMethod.GET) //Cambiar el nombre "ingresar-personal" por uno mas adecuado, tipo asignacion de personal al evento a cubrir
	public ModelAndView ingresarPersonal() {
		List <Long> personalDelEvento = new ArrayList <Long> ();
//		personalDelEvento.add(2L);
//		personalDelEvento.add(4L);
//		personalDelEvento.add(6L);
//		personalDelEvento.add(8L);
//		personalDelEvento.add(10L);
//		personalDelEvento.add(12L);
//		personalDelEvento.add(14L);
		
		
		
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
		
		 
		 Integer personalNecesario = servicioPersonal.calcularPersonal();
		 
		 Iterator entries = conteoOrdenadoAscendentementePorAsistencia.entrySet().iterator();
		 
		 for(int i=0;i<personalNecesario;i++) {
//			 while (entries.hasNext()) {
				 
				 Map.Entry <Long,Integer> entry = (Map.Entry) entries.next(); 
				 Long key = (Long)entry.getKey();
				 personalDelEvento.add(key);	     
			 }
//		 }
		servicioPersonal.consultarPersonal(personalDelEvento);
		return new ModelAndView("ingreso-menu");
	}


	
	
	
	@RequestMapping(path = "/listar-personal", method = RequestMethod.GET)
	public ModelAndView listarPersonalAsignadoAlEvento() {
		
		ModelMap model = new ModelMap();
		model.put("listado", servicioPersonal.controlDeServiciosPrestados());
		
		return new ModelAndView("listar-personal", model);
	}
	
	
	
	
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
	
	
	
//	 private static Map sortByAsc(Map unsortMap) {
//		 List list = new LinkedList(unsortMap.entrySet());
		 //Para ordenar ascendentemente
//		 Collections.sort(list, new Comparator() {
//		 public int compare(Object o1, Object o2) {
//		 return ((Comparable) ((Map.Entry) (o1)).getValue())
//		 .compareTo(((Map.Entry) (o2)).getValue());
//		 }
//		 });
		 //put sorted list into map again
//		 Map<string, integer=""> sortedMap = new LinkedHashMap<string, integer="">();
//		 for (Iterator it = list.iterator(); it.hasNext();) {
//		 Map.Entry<string, integer=""> entry = (Map.Entry<string, integer="">)it.next();
//		 sortedMap.put(entry.getKey(), entry.getValue());
//		 }
//		 return sortedMap;
//		 } 
}
