package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.dao.RecomendacionesDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@Service("servicioRecomendaciones")
@Transactional
public class ServicioRecomendacionesImpl implements ServicioRecomendaciones {

    @Inject
    private RecomendacionesDao servicioRecomendacionesDao;

    @Override
    public void obtenerListaDeRecomendaciones() {
        List<Menu> listaMenus=servicioRecomendacionesDao.validarMenu();
        TreeMap<String,Double> listaProm=new TreeMap();
        Double suma=0.0;
        int cantidad=0;
        Double prom=0.0;
        String nombre="";
        for (Menu menu:listaMenus) {
            nombre=menu.getNombre();
            for (Double item:menu.getPuntuacion()) {
                    suma=+item;
                    cantidad=menu.getPuntuacion().size();
              }
               prom=suma/cantidad;
            listaProm.put(nombre,prom);
         }

    }




}
