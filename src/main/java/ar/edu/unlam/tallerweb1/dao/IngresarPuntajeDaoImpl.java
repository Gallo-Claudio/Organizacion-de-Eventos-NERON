package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import org.hibernate.Session;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

import ar.edu.unlam.tallerweb1.modelo.Puntaje;


import ar.edu.unlam.tallerweb1.modelo.Usuario;


import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("ingresarPuntajeDao")
public class IngresarPuntajeDaoImpl implements IngresarPuntajeDao {

	
		
		@Inject
	    private SessionFactory sessionFactory;

		@Override
		public void ingresarPuntajeDao (Puntaje puntaje) {  
			final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
			session.save(puntaje); 
}
		
	}


