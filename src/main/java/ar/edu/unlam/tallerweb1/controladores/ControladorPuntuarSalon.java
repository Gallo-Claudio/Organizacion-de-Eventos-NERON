package ar.edu.unlam.tallerweb1.controladores;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroSalonViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Salon;
import ar.edu.unlam.tallerweb1.modelo.PuntajeSalon;
import javax.inject.Inject;

@Controller
public class ControladorPuntuarSalon {
    @Inject
    private ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones ServicioRecomendaciones;
    @Inject
    private ServicioSalon servicioSalon;
    @RequestMapping(path = "/buscar", method = RequestMethod.GET)
    public ModelAndView buscarSalonesPorNombre(@RequestParam("input") String input) {
        ModelMap model = new ModelMap();
        List<Salon> salones=servicioSalon.buscar(input);
        model.put("salones",salones);
        model.put("tope",salones.size());
        return new ModelAndView("puntaje-salon", model);
    }


    @RequestMapping(path = "/salones-a-puntuar", method = RequestMethod.GET)
    public ModelAndView mostrarSalones() {
        ModelMap model = new ModelMap();
        List<Salon> salones=ServicioRecomendaciones.ObtenerTodosLosSalones();
        model.put("salones",salones);

        return new ModelAndView("puntaje-salon", model);
    }

    @RequestMapping(path = "/puntuar-salon", method = RequestMethod.POST)
    public ModelAndView ingresarPuntaje(@ModelAttribute("mvSalon") RegistroSalonViewModel mvSalon,
                                        @ModelAttribute("puntaje") Double puntaje) {
        ModelMap model = new ModelMap();
      if(puntaje>0 && puntaje<=10){
          Double p=servicioSalon.calcularPuntaje(mvSalon.getId(),puntaje);

          model.put("mensaje" ,"gracias por darnos tu opinion :)");
      }


       model.put("mensaje" ,"solo puntuaciones del 1 al 10 porfavor  :)");
        return new ModelAndView("redirect:/salon-a-puntuar", model);
    }



}