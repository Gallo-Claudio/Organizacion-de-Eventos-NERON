package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

@Repository("ingresarDatosReservaDao")
public class IngresarDatosReservaImpl implements IngresarDatosReservaDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void ingresarDatosReserva(String fecha, String zona, Integer numeroInvitados, String nombre, String apellido,String email, String fingerFood,String bebidas, String evento) {
		
		final Session session= sessionFactory.getCurrentSession();
	    Reserva reserva =new Reserva();
	    reserva.setFecha(fecha);
	    reserva.setZona(zona);
	    reserva.setNumeroInvitados(numeroInvitados);
	    reserva.getCliente().setNombre(nombre);
	    reserva.getCliente().setApellido(apellido);
	    reserva.getCliente().setEmail(email);
	    reserva.setFingerFood(fingerFood);
	    reserva.setBebidas(bebidas);
	    reserva.setEvento(evento);
	    
	    session.save(reserva);
	    
		
		
	}

}
