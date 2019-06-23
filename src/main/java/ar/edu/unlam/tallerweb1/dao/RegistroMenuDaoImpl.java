package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.ReservaMultiple;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("registroMenuDao")
public class RegistroMenuDaoImpl implements RegistroMenuDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void registraMenuEnReserva (ReservaMultiple reservaMultiple) {  
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(reservaMultiple);    // Persisto en la BD, el objeto recibido desde el area de Servicios

	}

}
