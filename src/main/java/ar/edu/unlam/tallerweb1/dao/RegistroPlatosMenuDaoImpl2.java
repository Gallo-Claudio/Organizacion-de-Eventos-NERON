package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Menu2;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("registroPlatosMenuDao2")
public class RegistroPlatosMenuDaoImpl2 implements RegistroPlatosMenuDao2 {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void registraPlatosAlMenu (Menu menu) {  
		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		session.save(menu);    // Persisto en la BD, el objeto recibido desde el area de Servicios

	}

	@Override
	public Menu2 traerMenuPorId2(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (Menu2) session.createCriteria(Menu2.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
	
	
	
	@Override
	public TipoDeMenu traerTipoDeMenuPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        return (TipoDeMenu) session.createCriteria(TipoDeMenu.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }

}
