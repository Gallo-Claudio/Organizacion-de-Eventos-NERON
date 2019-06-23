package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

import static org.hibernate.criterion.Restrictions.*;

@Repository("RecomendacionesDao")
public class ReomendacionesDaoImpl implements RecomendacionesDao{

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List<Menu> obtenerMenusDeLaBase(){
        final Session session = sessionFactory.getCurrentSession();
        List Menus= session.createCriteria(Menu.class)
               .list();
        return Menus;
    }
}
