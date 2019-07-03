package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@Repository("listadoSalonesEliminadosDao")
public class ListadoSalonesEliminadosDaoImp implements ListadoSalonesEliminadosDao {
	
	@Inject
    private SessionFactory sessionFactory;
	List <Salon> listadoDeSalonesEliminados;

	@Override
	public List<Salon> listarSalonesEliminados() {
		final Session session = sessionFactory.getCurrentSession();
		listadoDeSalonesEliminados = session.createCriteria(Salon.class).list();
		return (listadoDeSalonesEliminados);
	}



}
