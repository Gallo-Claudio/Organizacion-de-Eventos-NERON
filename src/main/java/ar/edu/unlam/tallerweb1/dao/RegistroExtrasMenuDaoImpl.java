package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("registroExtrasMenuDao")
public class RegistroExtrasMenuDaoImpl implements RegistroExtrasMenuDao {

	@Inject
    private SessionFactory sessionFactory;


	@Override
	public void registraExtrasAlMenu(Extras extras) {
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(extras);    // Persisto en la BD, el objeto recibido desde el area de Servicios
		
	}

	@Override
	public Extras traerExtraPorId(Long id) {
		   final Session session = sessionFactory.getCurrentSession();
	        return (Extras) session.createCriteria(Extras.class)
	                .add(Restrictions.eq("id", id))
	                .uniqueResult();
	}

}
