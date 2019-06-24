package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Evento;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
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
	List <Reserva> listaDeReservas;
	@Override
	public Personal buscarPersonalPorId(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		return (Personal) session.createCriteria(Personal.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	public void ingresarReserva(Reserva reserva) {
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(reserva);
	}

	@Override
	public List <Reserva> traerReservas() {
		final Session session = sessionFactory.getCurrentSession();
	
		//	listaDeReservas = session.createCriteria(Evento.class).list();
		return (listaDeReservas) = session.createCriteria(Reserva.class).list();
	}

}
