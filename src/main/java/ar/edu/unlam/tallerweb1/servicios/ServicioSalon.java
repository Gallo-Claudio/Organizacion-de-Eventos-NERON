package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Imagenes;

import java.util.List;


public interface ServicioSalon {

   // List<Salon>

   List<Salon> buscarSalonesZonaSur(Integer cantidad ,String fecha);
    List<Salon> buscarSalonesZonaOeste(Integer cantidad ,String fecha);
    List<Salon> buscarSalonesZonaNorte(Integer cantidad ,String fecha);
    List<Salon> buscarSalonesCapital(Integer cantidad ,String fecha);
    Salon traerSalonPorId(Integer id);

    void guardarReserva(Reserva reserva);
     List<Imagenes> galeria(Integer id);

     Boolean verificarSalon(Salon salon);
}
