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
	public Reserva traerReserva(Long id){

		final Session session = sessionFactory.getCurrentSession();
		return (Reserva) session.createCriteria(Reserva.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
	}
	@Override
	public void guardarExtra(Reserva reservas) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(reservas);
		
	}
	@Override
	public Extras traerExtraPorId(Long idm) {
		final Session session = sessionFactory.getCurrentSession();


        return (Extras) session.createCriteria(Extras.class)
                .add(eq("id", idm))
                .uniqueResult();
	}
}
//final Session session = sessionFactory.getCurrentSession();
//session.save(Extras);