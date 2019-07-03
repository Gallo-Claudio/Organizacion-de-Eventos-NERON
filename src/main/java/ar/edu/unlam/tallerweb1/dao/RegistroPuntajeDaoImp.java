package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("registroPuntajeDao")
public class RegistroPuntajeDaoImp implements RegistroPuntajeDao {

	@Inject
    private SessionFactory sessionFactory;

	

	@Override
	public List<PuntajeMenu> registroPuntaje(List<PuntajeMenu> puntajesMenu) {
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		 session.save(puntajesMenu);
		return puntajesMenu;
		 
	}

}
