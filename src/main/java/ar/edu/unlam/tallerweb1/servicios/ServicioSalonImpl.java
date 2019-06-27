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
import java.util.ArrayList;
import java.util.List;

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
    public  List<Salon> buscarSalonesZonaSur (Integer cantidad ,String fecha) {
       List<Salon> lista=servicioSalonDao.buscarSalonesZonaSur(cantidad, fecha);

      return lista;
    }


    @Override
    public  List<Salon> buscarSalonesZonaNorte (Integer cantidad ,String fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesZonaNorte(cantidad, fecha);

        return lista;
    }


    @Override
    public  List<Salon> buscarSalonesZonaOeste (Integer cantidad ,String fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesZonaOeste(cantidad, fecha);

        return lista;
    }


    @Override
    public  List<Salon> buscarSalonesCapital (Integer cantidad ,String fecha) {
        List<Salon> lista=servicioSalonDao.buscarSalonesCapital(cantidad, fecha);

        return lista;
    }



}


