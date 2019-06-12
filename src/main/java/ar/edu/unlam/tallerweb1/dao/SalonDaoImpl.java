package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

import static org.hibernate.criterion.Restrictions.*;

@Repository("SalonDao")
public class SalonDaoImpl implements SalonDao {

    @Inject
    private SessionFactory sessionFactory;

    @Override
    public Salon verificarSalon(Salon salon){
        final Session session = sessionFactory.getCurrentSession();
        return (Salon) session.createCriteria(Salon.class)
                .add(Restrictions.eq("id", salon.getId()))
                .uniqueResult();
    }



    @Override
    public Salon galeria(Integer id){
        final Session session = sessionFactory.getCurrentSession();
        return (Salon) session.createCriteria(Salon.class)
                .add(eq("id", id))
                .uniqueResult();
    }
    @Override
    public void guardarReserva(Reserva reserva){
        final Session session = sessionFactory.getCurrentSession();
         session.save(reserva);
    }
    @Override
    public Salon traerSalonPorId(Integer id){
        final Session session = sessionFactory.getCurrentSession();


        return (Salon) session.createCriteria(Salon.class)
                .add(eq("id", id))
                .uniqueResult();
    }

 //buscar salones por zona
    @Override
    public List<Salon> buscarSalonesCapital(Integer cantidad , String fecha){
        final Session session = sessionFactory.getCurrentSession();

        List salones= session.createCriteria(Salon.class)
                .add(ge("capacidadMaxima", cantidad))
                .createAlias("reserva","reservaBuscada")

                .add(ne(  "reservaBuscada.fecha", fecha))
                .createAlias("ubicacion","ubicacionBuscada")
                .add(like(  "ubicacionBuscada.zona","Capital"))
                .list();

       return salones;
}


    @Override
    public List<Salon> buscarSalonesZonaSur(Integer cantidad , String fecha){
        final Session session = sessionFactory.getCurrentSession();
        List salones= session.createCriteria(Salon.class)
                .add(ge("capacidadMaxima", cantidad))
                .createAlias("reserva","reservaBuscada")
                  .add(ne(  "reservaBuscada.fecha", fecha))
                .createAlias("ubicacion","ubicacionBuscada")
                .add(like(  "ubicacionBuscada.zona","Sur"))
                .list();

        return salones;
    }


    @Override
    public List<Salon> buscarSalonesZonaNorte(Integer cantidad , String fecha){
        final Session session = sessionFactory.getCurrentSession();
        List salones= session.createCriteria(Salon.class)
                .add(ge("capacidadMaxima", cantidad))
                .createAlias("reserva","reservaBuscada")

                .add(or( isEmpty("reserva" ),
                 ne("reservaBuscada.fecha", fecha)))

                .createAlias("ubicacion","ubicacionBuscada")
                .add(like(  "ubicacionBuscada.zona","Norte"))
                .list();
        return salones;
    }


    @Override
    public List<Salon> buscarSalonesZonaOeste(Integer cantidad , String fecha){
        final Session session = sessionFactory.getCurrentSession();
        List salones= session.createCriteria(Salon.class)
                .add(ge("capacidadMaxima", cantidad))
                .createAlias("reserva","reservaBuscada")
                .add(ne(  "reservaBuscada.fecha", fecha))
                .createAlias("ubicacion","ubicacionBuscada")
                .list();



        return salones;
    }




}
