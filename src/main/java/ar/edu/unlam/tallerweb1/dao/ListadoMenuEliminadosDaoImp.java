package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Repository("listadoMenuEliminadosDao")
public class ListadoMenuEliminadosDaoImp implements ListadoMenuEliminadosDao {
	
	@Inject
    private SessionFactory sessionFactory;
	List <Menu> listadoDeMenusEliminados;

	@Override
	public List<Menu> listaMenusEliminados() {
		final Session session = sessionFactory.getCurrentSession();
		listadoDeMenusEliminados = session.createCriteria(Extra.class).list();
		return (listadoDeMenusEliminados);
	}



}
