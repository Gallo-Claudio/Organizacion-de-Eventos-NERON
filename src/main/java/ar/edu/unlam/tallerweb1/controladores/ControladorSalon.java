
package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorSalon {

    @Inject
    private ServicioSalon servicioSalon;

   // @Inject
   // private ServicioCliente servicioCliente;

    @RequestMapping(path="/salon"
    )
    public ModelAndView ir() {
        ModelMap modelo = new ModelMap();

        return new ModelAndView("/salon", modelo);
    }

    @RequestMapping(path="/tomarDatos", method = RequestMethod.GET)
    public ModelAndView tomarDatos(@RequestParam(name="cantidad",required=false) Integer cantidad,
                                   @RequestParam(name="fecha",required=false) String fecha) {
        ModelMap modelo = new ModelMap();
        //encontrar zalones por zona
       List<Salon> salonesCapital=servicioSalon.buscarSalonesCapital(cantidad, fecha);
        List<Salon> salonesZonaSur=servicioSalon.buscarSalonesZonaSur(cantidad, fecha);
        List<Salon> salonesZonaOeste=servicioSalon.buscarSalonesZonaOeste(cantidad, fecha);
        List<Salon> salonesZonaNorte=servicioSalon.buscarSalonesZonaNorte(cantidad, fecha);

        modelo.put("capital",salonesCapital);
        modelo.put("sur",salonesZonaSur);
        modelo.put("norte",salonesZonaNorte);
        modelo.put("oeste",salonesZonaOeste);


        modelo.put("cantidad",cantidad);
        modelo.put("fecha",fecha);
        modelo.put("isset","capital");


        return new ModelAndView("/salon", modelo);
    }


    @RequestMapping(path="/validar", method = RequestMethod.POST)
    public ModelAndView validar(@ModelAttribute("id") Integer id,
                                   @ModelAttribute("horario") String horario,
                                @ModelAttribute("fecha") String fecha) {//esta en la url
        ModelMap modelo = new ModelMap();


       int error=0;
       String mensaje=" ";
      if(id.equals(0)){
          error++;
          mensaje+="seleccione un salon" ;}

      modelo.put("id",id);
        if(error==0){


           Reserva reserva=new Reserva();
          // reserva.setCliente();
            reserva.setHorario(horario);
           reserva.setSalon(servicioSalon.traerSalonPorId(id));
           reserva.setFecha(fecha);
           servicioSalon.guardarReserva(reserva);
           Long idReserva=new Long(reserva.getId());
           return new ModelAndView("redirect:/menu-listado?q="+idReserva+"");
        }else{

            modelo.put("mensaje",mensaje);
        }

        return new ModelAndView("salon");
    }


    @RequestMapping(path="/VerImagenes", method = RequestMethod.GET)
    public ModelAndView galeria(@RequestParam(name="id",required=false) Integer id) {//esta en la url
        ModelMap modelo = new ModelMap();

           List<Imagenes> imagenes=servicioSalon.galeria(id);
           modelo.put("imagenes",imagenes);

        return new ModelAndView("/galeria", modelo);
    }



    @Inject
    private ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones ServicioRecomendaciones;

    @RequestMapping(path="/RecomendacionesMenu", method = RequestMethod.GET)
    public ModelAndView MoostrarRecomendacionesMenu() {//esta en la url
        ModelMap modelo = new ModelMap();

        List<Menu> menus=ServicioRecomendaciones.ObtenerRecomendaciones();
        modelo.put("menus",menus);


        return new ModelAndView("recomendacionesMenu", modelo);
    }
}
