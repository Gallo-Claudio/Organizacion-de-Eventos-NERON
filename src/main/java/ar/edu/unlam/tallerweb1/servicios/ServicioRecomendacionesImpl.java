package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.RecomendacionesDao;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collections;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service("servicioRecomendaciones")
@Transactional
public class ServicioRecomendacionesImpl implements ServicioRecomendaciones{

    @Inject
    private RecomendacionesDao RecomendacionesDao;
    @Override

    public   ArrayList<ArrayList<Menu>> ObtenerRecomendaciones(){
       Double puntajeTotal=0.0;
      Integer cantidad=0;
      Double promedio=0.0;
      List<Double> promedios= new ArrayList<>();
        List<Reserva> reservas=RecomendacionesDao.obtenerReservasDeLaBase();
      //  List<Reserva> reservasRecomendados=new ArrayList<>();
        ArrayList<ArrayList<Menu>> arrayDeMenus= new ArrayList<>();

           for (Reserva reserva:reservas){

             puntajeTotal=0.0;
              cantidad=0;
              promedio=0.0;
           for(PuntajeMenu puntaje:reserva.getPuntajesMenu()){

               puntajeTotal=+puntaje.getPuntaje();
                cantidad=reserva.getPuntajesMenu().size();


               }
               promedio=puntajeTotal/cantidad;


           if(promedio>7) {
             //  reservasRecomendados.add(reserva);
               ArrayList<Menu> menusRecomendados=new ArrayList<>();
               menusRecomendados.addAll(reserva.getMenu());
               arrayDeMenus.add(menusRecomendados);


           }



    }


       return arrayDeMenus;

    }

}
