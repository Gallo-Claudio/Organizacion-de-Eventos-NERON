package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.SalonDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.Imagenes;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.*;

import java.util.ArrayList;

@Service("servicioSalon")
@Transactional
public class ServicioSalonImpl implements ServicioSalon {


    @Inject
    private SalonDao servicioSalonDao;

    @Override
    public Boolean verificarSalon(Salon salon){
        if (servicioSalonDao.verificarSalon(salon) != null) {
            return true;
        }else{
            return false;
        }

    }
    @Override
    public  Long hacerReserva(Long id,Long salon,LocalDate fecha,String horario,Integer cantidad){
        Salon salonAingresar=servicioSalonDao.traerSalonPorId(salon);
        Reserva reserva=new Reserva();
        Usuario user=servicioSalonDao.traerCliente(id);
       reserva.setUsuario(user);
        reserva.setSalon(salonAingresar);
        reserva.setFecha(fecha);
        reserva.setCantidadDeInvitados(cantidad);
        reserva.setHorario(horario);
        servicioSalonDao.guardarReserva(reserva);

      //  salonAingresar.agregarReservas(reserva);
        return reserva.getIdReserva();
    }
    @Override
    public List<Imagenes> galeria(Integer id){
       Salon salon=servicioSalonDao.galeria(id);

        List<Imagenes> nuevalista=new ArrayList<>();

        for (Imagenes imagen:salon.getImagenes() ) {
            nuevalista.add(imagen);
         }



        return  nuevalista;
    }
    @Override
    public void guardarReserva(Reserva reserva){
        servicioSalonDao.guardarReserva(reserva);
    }
   @Override
   public Salon traerSalonPorId(Long id){

       return  servicioSalonDao.traerSalonPorId(id);
   }
    @Override
    public  Set<Salon> buscarSalonesZonaSur (Integer cantidad ,LocalDate fecha) {
       List<Salon> lista=servicioSalonDao.buscarSalonesZonaSur(cantidad, fecha);
        Set<Salon> salonesNoRepetidos= new HashSet<>();
        for(Salon salon :lista){
            salonesNoRepetidos.add(salon);
        }

        return salonesNoRepetidos;
    }


    @Override
    public  Set<Salon> buscarSalonesZonaNorte (Integer cantidad ,LocalDate fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesZonaNorte(cantidad, fecha);


        Set<Salon> salonesNoRepetidos= new HashSet<>();
        for(Salon salon :lista){
            salonesNoRepetidos.add(salon);
        }

        return salonesNoRepetidos;
    }


    @Override
    public  Set<Salon> buscarSalonesZonaOeste (Integer cantidad ,LocalDate fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesZonaOeste(cantidad, fecha);

        Set<Salon> salonesNoRepetidos= new HashSet<>();
        for(Salon salon :lista){
            salonesNoRepetidos.add(salon);
        }

        return salonesNoRepetidos;
    }


    @Override
    public  Set<Salon> buscarSalonesCapital (Integer cantidad ,LocalDate fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesCapital(cantidad, fecha);

        Set<Salon> salonesNoRepetidos= new HashSet<>();
        for(Salon salon :lista){
            salonesNoRepetidos.add(salon);
        }

        return salonesNoRepetidos;
    }

    
    
    // Devuelve la cantidad de invitados de la reserva correspondiente al id de reserva pasado
    @Override
    public Integer cantidadDeInvitados(Long idReserva){
    	Reserva reserva = servicioSalonDao.cantidadDeInvitadosPorIdReserva(idReserva);
    	
        return  reserva.getCantidadDeInvitados();
    }

}


