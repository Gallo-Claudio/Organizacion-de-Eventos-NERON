package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

public class ControlladorRecomendacionesMenu {
    @Inject
    private ServicioRecomendaciones ServicioRecomendaciones;

    @RequestMapping(path="/RecomendacionesMenu", method = RequestMethod.GET)
    public ModelAndView MoostrarRecomendacionesMenu() {//esta en la url
        ModelMap modelo = new ModelMap();

        List<Menu> menus=ServicioRecomendaciones.ObtenerRecomendaciones();
        modelo.put("menus",menus);


        return new ModelAndView("recomendacionesMenu", modelo);
    }
}
