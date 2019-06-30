package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import static org.hibernate.criterion.Restrictions.eq;

import javax.inject.Inject;

@Repository("seleccionoExtraDao")
public class SeleccionoExtraDaoImp implements SeleccionoExtraDao {

	@Inject
    private SessionFactory sessionFactory;
	@Override
	public Reserva reserva(Long id){

		final Session session = sessionFactory.getCurrentSession();
		Reserva id1 = (Reserva) session.createCriteria(Reserva.class)
				.add(eq("id", id))
				.uniqueResult();
		return id1;
	}
	@Override
	public void guardarExtra(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(reserva);
		
	}
	@Override
	public Extras traerExtraPorId(Long idm) {
		final Session session = sessionFactory.getCurrentSession();
		Extras id = (Extras) session.createCriteria(Extras.class)
				.add(eq("id", idm))
				.uniqueResult();
		return id;
	}
}
//final Session session = sessionFactory.getCurrentSession();
//session.save(Extras);