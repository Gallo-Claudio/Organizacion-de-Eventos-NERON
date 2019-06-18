package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.time.*;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PersonalDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioPersonal")
@Transactional
public class ServicioPersonalImpl implements ServicioPersonal {

	@Inject
	private PersonalDao personalDao;

	@Override
	public void consultarPersonal(List<Long> listado) {
		List<Personal> listadoPersonalDelEvento = new ArrayList <Personal> ();
		
		for(Long personal : listado) {
			listadoPersonalDelEvento.add(personalDao.buscarPersonalAsignadoAlEvento(personal));
		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Preguntar si no es mas conveniente separar esta logica en otro servicio que se podria llamar Guardar Evento
		LocalDate fecha_ingreso = LocalDate.of(2019, 6, 16);  //<----- Verificar si los datos año, mes dia se pueden pasar como integer
		
		Evento evento = new Evento();
	//	evento.setFechaDelEvento(fecha_ingreso);    <--------- ERROR CON LA FECHA 
		evento.setPersonal(listadoPersonalDelEvento);
		
		personalDao.ingresarEvento(evento);
	}

	public Integer calcularPersonal() {
		//Ahora cocino la cantidad de personal, pero habria que realizar el calculo
		Integer personal = 5;
		return personal;
	}
	
	public List<Personal> controlDeServiciosPrestados () {
		List<Evento> lista = new ArrayList();
		lista=(personalDao.traerEventos());
		
		List<Personal> resultado = new ArrayList<>();
		
		for (Evento l: lista) {	
			resultado.addAll(l.getPersonal());
		}
			
		return resultado;
	}
	
}
