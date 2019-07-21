package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Repository("listadoFechasDao")
public class ListadoFechasDaoImp implements ListadoFechasDao {
	
	@Inject
    private SessionFactory sessionFactory;
	List <Licencia> listadoDeFechas;

	@Override
	public List<Licencia> listarFechas() {
		final Session session = sessionFactory.getCurrentSession();
		listadoDeFechas = session.createCriteria(Extra.class).list();
		return (listadoDeFechas);
	}



}
