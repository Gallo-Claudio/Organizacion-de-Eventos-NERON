package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("listadoOpcionesMenuDao ")
public class ListadoOpcionesMenuDaoImpl implements ListadoOpcionesMenuDao {

	@Inject
    private SessionFactory sessionFactory;
	List <Menu> listadoDeOpcionesDeMenu;
	
	@Override
	public List<Menu> listadoOpcionesDeMenu () {
		final Session session = sessionFactory.getCurrentSession(); // Obtengo una sesion
		// A traves de la sesion abierta, consulto en la tabla Personas que esta en la BD
		// y guardo el valor obtenido en la coleccion del tipo List llamada "listadoDePersonas
		// para luego retornar el resultado
		listadoDeOpcionesDeMenu = session.createCriteria(Menu.class).list();
		return (listadoDeOpcionesDeMenu);
	}

}
