package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("registroFechaDao")
public class RegistroFechaDaoImp implements RegistroFechaDao {

	@Inject
    private SessionFactory sessionFactory;


	@Override
	public void registroFecha(Licencia Licencia) {
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(Licencia);    // Persisto en la BD, el objeto recibido desde el area de Servicios
		
	}

}
