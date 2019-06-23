package ar.edu.unlam.tallerweb1.dao;
import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Reserva;

public interface SeleccionoExtraDao {
	
	void guardarExtra (Reserva reservas);
	Reserva traerReserva(Long id);
	


}