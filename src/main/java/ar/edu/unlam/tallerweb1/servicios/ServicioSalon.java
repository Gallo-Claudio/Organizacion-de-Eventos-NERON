package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Imagenes;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public interface ServicioSalon {

   // List<Salon>

    Set<Salon> buscarSalonesZonaSur(Integer cantidad ,LocalDate fecha);
    Set<Salon> buscarSalonesZonaOeste(Integer cantidad ,LocalDate fecha);
    Set<Salon> buscarSalonesZonaNorte(Integer cantidad ,LocalDate fecha);
 Set<Salon> buscarSalonesCapital(Integer cantidad , LocalDate fecha);
    Salon traerSalonPorId(Long id);

    void guardarReserva(Reserva reserva);
     List<Imagenes> galeria(Integer id);
      Long hacerReserva(Long id, Long salon, LocalDate fecha, String horario, Integer cantidad);
     Boolean verificarSalon(Salon salon);
     
     Integer cantidadDeInvitados (Long idReserva);
}
