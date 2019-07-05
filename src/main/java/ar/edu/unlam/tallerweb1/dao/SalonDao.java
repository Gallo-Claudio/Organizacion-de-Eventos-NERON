package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Imagenes;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.List;

public interface SalonDao {

    List<Salon> buscarSalonesZonaSur(Integer cantidad ,LocalDate fecha);
    List<Salon> buscarSalonesZonaOeste(Integer cantidad ,LocalDate fecha);
    List<Salon> buscarSalonesZonaNorte(Integer cantidad ,LocalDate fecha);
    List<Salon> buscarSalonesCapital(Integer cantidad ,LocalDate fecha);

    Salon traerSalonPorId(Long id);
    List<Reserva> traerListaDeFechas(Salon salon);
    void guardarReserva(Reserva reserva);
   Salon galeria(Integer id);

    Salon verificarSalon(Salon salon);
    Usuario traerCliente(Long id);

    Reserva cantidadDeInvitadosPorIdReserva(Long idReserva);
}
