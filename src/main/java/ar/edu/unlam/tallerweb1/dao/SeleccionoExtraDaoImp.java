package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Reservas;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import javax.inject.Inject;

@Repository("seleccionoExtraDao")
public class SeleccionoExtraDaoImp implements SeleccionoExtraDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarExtra(Reservas reservas) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(reservas);
		
	}
}
//final Session session = sessionFactory.getCurrentSession();
//session.save(Extras);