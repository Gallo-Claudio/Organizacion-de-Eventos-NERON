package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("ingresoDeMenuDao")
public class IngresoDeMenuDaoImpl implements IngresoDeMenuDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarMenuSeleccionado(Reserva menuSeleccionado) {
		final Session session = sessionFactory.getCurrentSession(); 
		session.save(menuSeleccionado);
	}

}