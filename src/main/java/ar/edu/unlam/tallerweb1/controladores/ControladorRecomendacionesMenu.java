package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class ControladorRecomendacionesMenu {

    @Inject
    private ServicioRecomendaciones servicioRecomendaciones;



    // Este metodo escucha la URL localhost:8080/NOMBRE_APP/login si la misma es invocada por metodo http GET
    @RequestMapping("/recomendaciones")
    public ModelAndView asignar() {


        ModelMap modelo = new ModelMap();

        return new ModelAndView("login", modelo);
    }


}
