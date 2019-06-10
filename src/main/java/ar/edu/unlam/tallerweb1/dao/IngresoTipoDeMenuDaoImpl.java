package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("ingresoTipoDeMenuDao")
public class IngresoTipoDeMenuDaoImpl implements IngresoTipoDeMenuDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void ingresarNuevoMenuDao (TipoDeMenu tipoDeMenu) {  

		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(tipoDeMenu);    // Persisto en la BD, el objeto recibido desde el area de Servicios

	}

}