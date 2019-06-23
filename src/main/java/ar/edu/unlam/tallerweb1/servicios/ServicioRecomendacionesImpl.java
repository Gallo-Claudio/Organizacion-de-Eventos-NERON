package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.RecomendacionesDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service("servicioRecomendaciones")
@Transactional
public class ServicioRecomendacionesImpl implements ServicioRecomendaciones{

    @Inject
    private RecomendacionesDao RecomendacionesDao;
    @Override

    public List<Menu> ObtenerRecomendaciones(){
       Double puntajeTotal=0.0;
      Integer cantidad=0;
      Double promedio=0.0;
        List<Menu> listaMenu=RecomendacionesDao.obtenerMenusDeLaBase();
        List<Menu> menusRecomendados=new ArrayList<>();
           for (Menu menu:listaMenu){
             puntajeTotal=0.0;
              cantidad=0;
              promedio=0.0;
           for(PuntajeMenu puntaje:menu.getPuntajes()){
               puntajeTotal=+puntaje.getPuntaje();
                cantidad=menu.getPuntajes().size();
                promedio=puntajeTotal/cantidad;

               }   if(promedio>7) {
                   menusRecomendados.add(menu);
               }
    }


       return menusRecomendados;

    }

}
