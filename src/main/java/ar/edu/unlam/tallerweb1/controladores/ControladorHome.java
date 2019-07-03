package ar.edu.unlam.tallerweb1.controladores;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroSalonViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class ControladorHome {
    @Inject
    private ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones ServicioRecomendaciones;


   /* @RequestMapping(path = "/home", method = RequestMethod.GET)
    public ModelAndView ingresarPuntaje() {
        ModelMap model = new ModelMap();

        ArrayList<Salon> salones=ServicioRecomendaciones.ObtenerRecomendacionesSalon();
        model.put("salones",salones);
        model.put("tope",salones.size());
        return new ModelAndView("home", model);
    }

    */
}
