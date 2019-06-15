package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface IngresarDatosReservaDao {
	
	void ingresarDatosReserva(String fecha, String zona, Integer numeroInvitados, String nombre, String apellido,String email, String fingerFood,String bebidas, String evento);

}
