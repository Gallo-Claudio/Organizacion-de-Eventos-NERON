
package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("registroExtraDao")
public class RegistroExtraDaoImpl implements RegistroExtraDao {

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
	public void registraExtraEnReserva(Reserva reservaExtra) {
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(reservaExtra);    // Persisto en la BD, el objeto recibido desde el area de Servicios
		
	}
}
