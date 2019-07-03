package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listadoPuntajeMenuDao")
public class ListadoPuntajeMenuDaoImpl implements ListadoPuntajeMenuDao {

	@Inject
    private SessionFactory sessionFactory;
	List <TipoDeMenu> listadoPuntajeMenu;
	
	
	
	
	@Override
	public List<TipoDeMenu> listarPuntajesMenu() {
		final Session session = sessionFactory.getCurrentSession(); // Obtengo una sesion
		listadoPuntajeMenu = session.createCriteria(TipoDeMenu.class).list();
		return (listadoPuntajeMenu);
	}


}
