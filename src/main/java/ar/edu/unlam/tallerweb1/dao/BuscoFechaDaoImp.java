package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Extra;
import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

@Repository("buscoFechaDao")
public class BuscoFechaDaoImp implements BuscoFechaDao {

	@Inject
    private SessionFactory sessionFactory;

//	@Override
//	public List<Licencia> buscoFecha(Long idPersonal, LocalDate fechaAusencia2) {
//		final Session session = sessionFactory.getCurrentSession();
//		
//		List <Licencia> buscoLicencia = session.createCriteria(Licencia.class)
//        		.add(Restrictions.eq("fecha", fechaAusencia2))
//        		.add(Restrictions.eq("idPersonal", idPersonal))
//        		.list();
//		return buscoLicencia;
//	}
	
	
	@Override
	public List <Licencia> buscoFechasDeLicenciaPorIdDePersonal (Long idPersonal) {
		
		final Session session = sessionFactory.getCurrentSession();
		List <Licencia> licenciaPorId =  session.createCriteria(Licencia.class)
				.add(Restrictions.eq("id", idPersonal))
				.list();
		 return licenciaPorId;
	}



}