package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listarSeleccionExtrasDao")
public class ListarSeleccionExtrasDaoImp implements ListarSeleccionExtrasDao {

	@Inject
    private SessionFactory sessionFactory;
	List <Extras> listarSeleccionExtras;
	
	

	@Override
	public List<Extras> listarSeleccionExtras() {
		final Session session = sessionFactory.getCurrentSession();
		return listarSeleccionExtras = session.createCriteria(Extras.class).list();
	
	}

}
