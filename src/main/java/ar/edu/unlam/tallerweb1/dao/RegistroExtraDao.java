package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;


public interface RegistroExtraDao {

	void registraExtraEnReserva (Reserva reservaExtra);
	Reserva traerReserva(Long id);
}
