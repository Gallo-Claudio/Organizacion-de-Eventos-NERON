package ar.edu.unlam.tallerweb1.servicios;
import ar.edu.unlam.tallerweb1.modelo.Imagenes;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Zona;

import java.util.List;
import java.util.Set;


public interface ServicioSalon {

   // List<Salon>
   Double calcularPuntaje(Long id,Double nuevoPuntaje);
    Set<Salon> buscarSalones(Integer cantidad ,String fecha);
    public  List<Zona> traerZonas();
    Salon traerSalonPorId(Long id);

    void guardarReserva(Reserva reserva);
     List<Imagenes> galeria(Integer id);
      Long hacerReserva(Long id,Long salon,String fecha,String horario,Integer cantidad);
     Boolean verificarSalon(Salon salon);

     List<Salon> buscar(String nombre);
}
