
package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroSalonViewModel;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Controller
public class ControladorSalon {
	
    @Inject
    private ServicioSalon servicioSalon;

   // @Inject
   // private ServicioCliente servicioCliente;


    //Admin
    //HAY QUE HACERLO
    /*
    @RequestMapping(path = "/ingreso-salon", method = RequestMethod.GET)
    public ModelAndView ingresoDeSalon() {
        Salon salon = new Salon();
        ModelMap model = new ModelMap();
        model.put("salon", salon);
        return new ModelAndView("ingreso-salon", model);
    }
    //HAY QUE HACERLO
    @RequestMapping(path = "/registro-Salon", method = RequestMethod.POST)
    public ModelAndView registroExtras (@ModelAttribute ("Extras") Extra extra,
                                        HttpServletRequest request) {
    //    if(request.getSession().getAttribute("ROL")=="1"){
      //  servicioIngresoExtras.ingresarExtras(extra);
        return new ModelAndView("redirect:/ingreso-salon");
   // }
      //      return new ModelAndView("redirect:/home");



    }
    //HAY QUE HACERLO
    @RequestMapping(path = "/listado-final-salon", method = RequestMethod.GET)
    public ModelAndView listadoExtras () {
        ModelMap modelo = new ModelMap();
       // modelo.put("listadoFinal", servicioListarExtras.listarExtras());
        return new ModelAndView("listado-final-salon", modelo);
    }
*/
    @RequestMapping(path="/salon" )
    public ModelAndView ir(HttpServletRequest request) {
        if(request.getSession().getAttribute("logueado")==null){
          return new ModelAndView("redirect:/home");

        }

           return new ModelAndView("salon");



    }

    @RequestMapping(path="/tomarDatos", method = RequestMethod.GET)
    public ModelAndView tomarDatos(@RequestParam(name="cantidad",required=false) Integer cantidad,
                                   @RequestParam(name="fecha",required=false) String fecha) {

        ModelMap modelo = new ModelMap();
       LocalDate fechaActual = LocalDate.now();
        LocalDate fechaEvento = LocalDate.parse(fecha);
        if(fechaActual.compareTo(fechaEvento)>=0 ){
             modelo.put("mensaje","fecha invalida");
            return new ModelAndView("redirect:/salon", modelo);
        }


        Set<Salon> salones=servicioSalon.buscarSalones(cantidad, fechaEvento);
        List<Zona> zonas=servicioSalon.traerZonas();

        modelo.put("salones",salones);
        modelo.put("zonas",zonas);


        modelo.put("cantidad",cantidad);
        modelo.put("fecha",fecha);
        modelo.put("isset","capital");


        return new ModelAndView("/salon", modelo);
    }


    @RequestMapping(path="/validar", method = RequestMethod.POST)
    public ModelAndView validar(@ModelAttribute("salon") RegistroSalonViewModel salon,
                                   @ModelAttribute("horario") String horario,
                                @ModelAttribute("fecha") String fechaString,
                                @ModelAttribute("cantidad") Integer cantidad,
                                HttpServletRequest request) {//esta en la url
        ModelMap modelo = new ModelMap();
        LocalDate fecha = LocalDate.parse(fechaString);
        
       int error=0;
       String mensaje=" ";
       Long id=salon.getId();
      if(id.equals(0L)){
          error++;
          mensaje+="seleccione un salon" ;}

      modelo.put("id",salon.getId());
        if(error==0){

         Long idUser= Long.parseLong(request.getSession().getAttribute("logueado").toString());
          Long idReserva= servicioSalon.hacerReserva(idUser ,salon.getId(),fecha,horario,cantidad);

           request.getSession().setAttribute("idReserva", idReserva);

          
           return new ModelAndView("redirect:/listado-menu");
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




}