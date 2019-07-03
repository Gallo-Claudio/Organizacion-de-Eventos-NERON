package ar.edu.unlam.tallerweb1.servicios;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.time.*;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PersonalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.CategoriaPersonal;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioPersonal")
@Transactional
public class ServicioPersonalImpl implements ServicioPersonal {

	@Inject
	private PersonalDao personalDao;


	// Devuelve el listado de asistencia del personal ordenado por Id
	@Override
	public Map <Long, Integer> obtencionListadoDeAsistencias() {
		Map <Long, Integer> conteo = new HashMap();

		// Realizo una iteracion del listado general de asistencias de los empleados. Ese listado es
		// devuelto por (servicioPersonal.controlDeServiciosPrestados ---> Devuelve una coleccion List <Personal>)
		Iterator<Personal> p = controlDeServiciosPrestados().iterator();
		Personal personal;
		while (p.hasNext()) {
			personal=p.next();

			// De dicha iteracion, extraigo el Id de cada empleado y lo guardo en un Map llamado conteo.
			// Alli, guardo en la key el numero de Id y en el value guardo las veces que trabajo.
			// Dicho conteo lo realizo al comparar si el Id de extraido ya existe (si ya fue agregado) al Map,
			// de ya estar, sumo una unidad en el "value". De no estar el Id, es agregado al Map en la "key"
	        if(conteo.containsKey(personal.getIdPersonal())){
	        	conteo.put(personal.getIdPersonal(),conteo.get(personal.getIdPersonal())+1);
	         }
	         else{
	            conteo.put(personal.getIdPersonal(),1);
	         }
		}

		// Se completa el listrado agregando los Id que aun no tienen ningun registro de asistencia en la BD.
		// Esto puede ocurrir cuando se ingresa a algun Personal nuevo, y no tuvo ningun evento asignado aun
		List<Personal> TodoElPersonal = personalDao.listadoDelPersonal();

		Iterator <Personal> tep = TodoElPersonal.iterator();
		Personal todos;
		while (tep.hasNext()) {
			todos=tep.next();
			 	if(conteo.containsKey(todos.getIdPersonal())){
		         }
		         else{
		            conteo.put(todos.getIdPersonal(),0);
		         }
		}
		return conteo;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Obtengo un listado general de la asistencia (eventos cubiertos por cada personal)
	@Override
	public List<Personal> controlDeServiciosPrestados () {
		List<Reserva> lista = new ArrayList();
		lista=(personalDao.traerReservas());

		List<Personal> resultado = new ArrayList<>();

		for (Reserva l: lista) {
			resultado.addAll(l.getPersonal());
		}

		return resultado;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Ordena el listado (Map) en forma ascendente
	@Override
	public Map OrdenaAscendentemente(Map unsortMap) {
		 List list = new LinkedList(unsortMap.entrySet());

		 //Para ordenar ascendentemente
		 Collections.sort(list, new Comparator() {
		 public int compare(Object o1, Object o2) {
		 return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
		 }
		 });

		 //Agrega la lista ordenana dentro del Map
		 Map<Long, Integer> sortedMap = new LinkedHashMap<Long, Integer>();

		 for (Iterator it = list.iterator(); it.hasNext();) {
			 Map.Entry<Long, Integer> entry = (Map.Entry<Long, Integer>)it.next();
			 sortedMap.put(entry.getKey(), entry.getValue());
		 }

		 return sortedMap;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Calcula el personal de acuerdo a la cantidad total de invitados al evento
	@Override
	public List<Integer> calcularPersonal(Integer cantidadDeInvitados) {
		List<Integer> cantidadDePersonal = new ArrayList();

		Integer encargado = (cantidadDeInvitados * 1)/100;
		cantidadDePersonal.add(encargado);
		Integer chef = (cantidadDeInvitados * 1)/100;
		cantidadDePersonal.add(chef);
		Integer cocinero = (cantidadDeInvitados * 3)/100;
		cantidadDePersonal.add(cocinero);
		Integer ayudanteCocina = (cantidadDeInvitados * 6)/100;
		cantidadDePersonal.add(ayudanteCocina);
		Integer mozo = (cantidadDeInvitados * 10)/100;
		cantidadDePersonal.add(mozo);
		Integer lavaplatos = (cantidadDeInvitados * 3)/100;
		cantidadDePersonal.add(lavaplatos);

		return cantidadDePersonal;
	}
	
	
//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Genera un listado con los sueldos del personal
		@Override
		public List <Double> consultarSueldoPersonal() {
			List<CategoriaPersonal> listadoPersonal = personalDao.listadoDeCargosDelPersonal();
			List<Double> sueldos = new ArrayList();
			
			Iterator <CategoriaPersonal> lp = listadoPersonal.iterator();
			CategoriaPersonal todos;
			while (lp.hasNext()) {
				todos=lp.next();
				sueldos.add(todos.getSueldo());
			}

			return sueldos;
		}
	
	
//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Genera un listado con la cantidad necesaria de personal para cubrir el evento
	@Override
	public List <Long> asignarPersonalNecesario(List <Integer> personalNecesario, Map <Long,Integer> conteoOrdenadoAscendentementePorAsistencia) {
		List <Long> personalDelEvento = new ArrayList <Long> ();

		// Itero las entradas (representadas por key/value) del Map
		Iterator entries = conteoOrdenadoAscendentementePorAsistencia.entrySet().iterator();

		// Se usa el for, para ir pasando por las 6 categorias de empleados
//		for(int i=0; i<6; i++) {
			int encargado=1, chef=1, cocinero=1, ayudanteCocina=1, mozo=1, lavaplatos=1;  // Con esta variable, nos aseguramos de tomar solo la cantidad necesaria de personal para la categoria
//			Long categoria=1L;  // Con esta variable vamos cambiando la seleccion de la categoria en el bucle WHILE


			while(entries.hasNext()) {

				Map.Entry <Long,Integer> entry = (Map.Entry) entries.next();

				// Obtengo el Id atraves del key
				Long key = (Long)entry.getKey();

				Long valor = personalDao.buscarPersonalPorId(key).getCategoriaPersonal().getId();
				Integer categoria = (int) (long) valor;

				switch (categoria) {
				 case 1:
						if(encargado<=personalNecesario.get(0)) {
							encargado = encargado+1;
							personalDelEvento.add(key);
						}
						break;
				 case 2:
						if(chef<=personalNecesario.get(1)) {
							chef = chef+1;
							personalDelEvento.add(key);
						}
						break;
				 case 3:
						if(cocinero<=personalNecesario.get(2)) {
							cocinero = cocinero+1;
							personalDelEvento.add(key);
						}
						break;
				 case 4:
						if(ayudanteCocina<=personalNecesario.get(3)) {
							ayudanteCocina = ayudanteCocina+1;
							personalDelEvento.add(key);
						}
						break;
				 case 5:
						if(mozo<=personalNecesario.get(4)) {
							mozo = mozo+1;
							personalDelEvento.add(key);
						}
						break;
				 case 6:
						if(lavaplatos<=personalNecesario.get(5)) {
							lavaplatos = lavaplatos+1;
							personalDelEvento.add(key);
						}
						break;
				 }

			}
 
		return personalDelEvento;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Obtengo un listado del personal asignado al evento
	@Override
	public List<Personal> listadoPersonalAsignado(List<Long> listado) {
		List<Personal> listadoPersonalDelEvento = new ArrayList <Personal> ();

		// Recorro la coleccion (listado del tipo List) recibida y voy agregando al List (listadoPersonalDelEvento)
		// los objetos del tipo Personal, que fueron buscados por su Id.
		// Se genera una coleccion List <Personal> con el personal asignado a cubrir el evento
		for(Long personal : listado) {
			listadoPersonalDelEvento.add(personalDao.buscarPersonalPorId(personal));
		}

		return listadoPersonalDelEvento;
	}

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Envia al DAO el listado para ser persistido en la BD
	@Override
	public void persisteElListadoDePersonalAsignado (List<Personal> listado) {
		List<Personal> listadoPersonalDelEvento = new ArrayList <Personal> ();
		Reserva reserva = new Reserva();

		// Agrego la coleccion List<Personal> obtenida, a un objeto Reserva
		reserva.setPersonal(listado);
		// Paso el objeto Reserva al DAO, para ser guardado en la BD
		personalDao.ingresarReserva(reserva);
	}

	

//--------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------------

	// Obtencion del listado de cargos del personal
	@Override
	public List<CategoriaPersonal> consultaCargosDelPersonal () {
		List<CategoriaPersonal> listadoPersonalDelEvento = new ArrayList <CategoriaPersonal> ();
		listadoPersonalDelEvento = personalDao.listadoDeCargosDelPersonal();

		return listadoPersonalDelEvento;
	}
	
	
	
	
	//----------------nuevo----------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

		// Obtengo un listado general de la asistencia (eventos cubiertos por cada personal)
		@Override
		public List<Reserva> listadoDeReservas() {
			List<Reserva> lista = new ArrayList();
			lista=(personalDao.traerReservas());
		
			return lista;
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@Override
		public List<Personal> sinPersonal() {
	
			List<Personal> TodoElPersonal = personalDao.listadoDelPersonal();

	
			return TodoElPersonal;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

}	
	






    	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Preguntar si no es mas conveniente separar esta logica en otro servicio que se podria llamar Guardar Reserva
	//	LocalDate fecha_ingreso = LocalDate.of(2019, 6, 16);  //<----- Verificar si los datos a�o, mes dia se pueden pasar como integer
	//	evento.setFechaDelEvento(fecha_ingreso);    <--------- ERROR CON LA FECHA

//-----------------------------------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------
// anterior al 25/6

// Genera un listado con la cantidad necesaria de personal para cubrir el evento
//@Override
//public List <Long> asignarPersonalNecesario(Integer personalNecesario, Map <Long,Integer> conteoOrdenadoAscendentementePorAsistencia) {
//	List <Long> personalDelEvento = new ArrayList <Long> ();

	// Itero las entradas (representadas por key/value) del Map
//	Iterator entries = conteoOrdenadoAscendentementePorAsistencia.entrySet().iterator();

	// Recorro N veces (donde N es la cantidad de personal requerido) el Map
//	for(int i=0;i<personalNecesario;i++) {
//			 Map.Entry <Long,Integer> entry = (Map.Entry) entries.next();

			 // Obtengo el Id atraves del key
//			 Long key = (Long)entry.getKey();

			 // Agrego el Id obtenido a la coleccion del tipo List
//			 personalDelEvento.add(key);
//		 }

//	return personalDelEvento;
//}

// -----------------------------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------------------------
// 25/6

/// Genera un listado con la cantidad necesaria de personal para cubrir el evento
//@Override
//public List <Long> asignarPersonalNecesario(List <Integer> personalNecesario, Map <Long,Integer> conteoOrdenadoAscendentementePorAsistencia) {
//	List <Long> personalDelEvento = new ArrayList <Long> ();

	// Itero las entradas (representadas por key/value) del Map
//	Iterator entries = conteoOrdenadoAscendentementePorAsistencia.entrySet().iterator();

	// Se usa el for, para ir pasando por las 6 categorias de empleados
//	for(int i=0; i<6; i++) {
//		int vuelta=1;  // Con esta variable, nos aseguramos de tomar solo la cantidad necesaria de personal para la categoria que se esta rrecorriendo en el bucle WHILE
//		Long categoria=1L;  // Con esta variable vamos cambiando la seleccion de la categoria en el bucle WHILE


//		while(entries.hasNext()) {

//			Map.Entry <Long,Integer> entry = (Map.Entry) entries.next();

			// Obtengo el Id atraves del key
//			Long key = (Long)entry.getKey();

	        // Con "personalDao.buscarPersonalPorId(key).getCategoriaPersonal().getId()" obtengo el id correspondiente
			// a la categoria del personal de acuerdo al Id pasado a traves de "key"
//			if(personalDao.buscarPersonalPorId(key).getCategoriaPersonal().getId()==categoria && vuelta<=personalNecesario.get(i)) {
//					vuelta = vuelta+1;
//					personalDelEvento.add(key);
//			}
//		}
//		categoria = categoria+1;
//	}
//	return personalDelEvento;
//}
