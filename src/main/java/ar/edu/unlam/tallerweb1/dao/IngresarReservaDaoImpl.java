package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Repository("ingresarReservaDao")
public class IngresarReservaDaoImpl implements IngresarReservaDao {

	
		
		@Inject
	    private SessionFactory sessionFactory;

		@Override
		public void ingresarReserva (Reserva reserva) {  

			final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
			 session.save(reserva);    // Persisto en la BD, el objeto recibido desde el area de Servicios

		}

		
		
	}
