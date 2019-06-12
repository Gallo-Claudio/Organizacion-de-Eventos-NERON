package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.inject.Inject;

import static org.hibernate.criterion.Restrictions.*;

@Repository("RecomendacionesDao")
public class RecomendacionesDaoImpl implements RecomendacionesDao {
    @Inject
    private SessionFactory sessionFactory;

    @Override
    public List validarMenu(){
        final Session session = sessionFactory.getCurrentSession();
        List menu = session.createCriteria(Menu.class)
                .list();
        return  menu;
    }
}
