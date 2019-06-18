package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.FingerFood;
import ar.edu.unlam.tallerweb1.modelo.MesaDulce;
import ar.edu.unlam.tallerweb1.modelo.PlatoPrincipal;
import ar.edu.unlam.tallerweb1.modelo.Postre;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listadoDeMenuDao ")
public class ListadoDeMenuDaoImpl implements ListadoDeMenuDao {

	@Inject
    private SessionFactory sessionFactory;
	List <FingerFood> listadoDeOpcionesDeFingerFood;
	List <Entrada> listadoDeOpcionesDeEntrada;
	List <PlatoPrincipal> listadoDeOpcionesDePlatoPrincipal;
	List <Bebida> listadoDeOpcionesDeBebida;
	List <Postre> listadoDeOpcionesDePostre;
	List <MesaDulce> listadoDeOpcionesDeMesaDulce;
	
	
	
	@Override
	public List<FingerFood> listadoOpcionesDeFingerFood() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDeFingerFood = session.createCriteria(FingerFood.class).list();
		return (listadoDeOpcionesDeFingerFood);
	}

	@Override
	public List<Entrada> listadoOpcionesDeEntrada() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDeEntrada = session.createCriteria(Entrada.class).list();
		return (listadoDeOpcionesDeEntrada);
	}

	@Override
	public List<PlatoPrincipal> listadoOpcionesDePlatoPrincipal() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDePlatoPrincipal = session.createCriteria(PlatoPrincipal.class).list();
		return (listadoDeOpcionesDePlatoPrincipal);
	}

	@Override
	public List<Bebida> listadoOpcionesDeBebidas() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDeBebida = session.createCriteria(Bebida.class).list();
		return (listadoDeOpcionesDeBebida);
	}

	@Override
	public List<Postre> listadoOpcionesDePostres() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDePostre = session.createCriteria(Postre.class).list();
		return (listadoDeOpcionesDePostre);
	}

	@Override
	public List<MesaDulce> listadoOpcionesDeMesaDulce() {
		final Session session = sessionFactory.getCurrentSession(); 
		listadoDeOpcionesDeMesaDulce = session.createCriteria(MesaDulce.class).list();
		return (listadoDeOpcionesDeMesaDulce);
	}
	
}
