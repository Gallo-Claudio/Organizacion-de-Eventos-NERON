package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Menu2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listadoOpcionesMenuDao2 ")
public class ListadoOpcionesMenuDaoImpl2 implements ListadoOpcionesMenuDao2 {
	
	@Inject
    private SessionFactory sessionFactory;
	List <Menu2> listadoDeOpcionesDeMenu2;
	
	
	@Override
	public List<Menu2> listadoOpcionesDeMenu2 () {
		final Session session = sessionFactory.getCurrentSession(); // Obtengo una sesion
		// A traves de la sesion abierta, consulto en la tabla Menu que esta en la BD
		// y guardo el valor obtenido en la coleccion del tipo List llamada "listadoDeOpcionesDeMenu"
		// para luego retornar el resultado
		listadoDeOpcionesDeMenu2 = session.createCriteria(Menu2.class).list();
		return (listadoDeOpcionesDeMenu2);
	}

}
