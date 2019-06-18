package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


@Repository("personalDao")
public class PersonalDaoImpl implements PersonalDao {


	@Inject
    private SessionFactory sessionFactory;
	List <Evento> listaDeEventos;

	@Override
	public Personal buscarPersonalAsignadoAlEvento(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Personal) session.createCriteria(Personal.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void ingresarEvento(Evento evento) {
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(evento);
	}

	@Override
	public List <Evento> traerEventos() {
		final Session session = sessionFactory.getCurrentSession();
//		listaDeEventos = session.createCriteria(Evento.class).list();
		return (listaDeEventos) = session.createCriteria(Evento.class).list();
	}

}
