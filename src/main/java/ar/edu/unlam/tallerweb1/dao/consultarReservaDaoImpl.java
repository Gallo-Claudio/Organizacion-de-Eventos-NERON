package ar.edu.unlam.tallerweb1.dao;




import java.util.List;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Reserva;


@Repository("consultarReservaDao")
public class consultarReservaDaoImpl implements consultarReservaDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Reserva> consultarReserva(Reserva reserva) {
		final Session session = sessionFactory.getCurrentSession();
		return (List <Reserva>) session.createCriteria(Reserva.class).createAlias("salon", "salonAlias")
				.add(Restrictions.eq("salonAlias.nombre", reserva.getSalon().getNombre())).list();
			
		
	}
	
	

}
