package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.servicios.*;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ControladorPuntuarMenu {
    @Inject
    private ServicioRegistroMenu servicioRegistroMenu;
    @Inject
    private ServicioListarTiposMenu servicioListarTiposMenu;

    @Inject
    private ServicioListadoOpcionesMenu servicioListadoOpcionesMenu;

    @RequestMapping(path = "/menus-a-puntuar", method = RequestMethod.GET)
    public ModelAndView puntajesMenu() {
        ModelMap modelo = new ModelMap();


        modelo.put("listaopciones", servicioListadoOpcionesMenu.listarOpcionesMenu());
        modelo.put("secciones", servicioListarTiposMenu.listarTipoDeMenus());


        return new ModelAndView("puntaje-menu", modelo);
    }

    @RequestMapping(path = "/puntuar-menu", method = RequestMethod.POST)
    public ModelAndView ingresarPuntaje(@ModelAttribute("mvSalon") RegistroMenuViewModel mvMenu,
                                        @ModelAttribute("puntaje") Double puntaje) {
        ModelMap model = new ModelMap();
        if(puntaje>0 && puntaje<=10) {
            servicioRegistroMenu.calcularPuntaje(mvMenu.getId(), puntaje);

            model.put("mensaje", "gracias por darnos tu opinion del menu :)");
            return new ModelAndView("redirect:/menus-a-puntuar", model);
        }
        model.put("mensaje", "solo puntajes del 1 al 10 porfavor :)");

        return new ModelAndView("redirect:/menus-a-puntuar", model);
    }
}