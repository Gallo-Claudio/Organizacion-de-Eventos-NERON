
package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioEliminoSalon;
import ar.edu.unlam.tallerweb1.servicios.ServicioListarSalonesEliminados;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendaciones;
import ar.edu.unlam.tallerweb1.servicios.ServicioSalon;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroSalonViewModel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class ControladorSalon {

    @Inject
    private ServicioSalon servicioSalon;
    
    @Inject
    private ServicioEliminoSalon servicioEliminoSalon;
    @Inject
    private ServicioListarSalonesEliminados listarSalonesEliminados;
    
	//ADMIN
	@RequestMapping(path = "/elimino-salon", method = RequestMethod.GET)
	public ModelAndView ingresoDeExtras(HttpServletRequest request) {
		//if(request.getSession().getAttribute("ROL")=="1"){
			Salon salon = new Salon();
			ModelMap model = new ModelMap();
			model.put("salon", salon);
			return new ModelAndView("elimino-salon", model);
		//}
		//return new ModelAndView("redirect:/home");
	}
	
	
	@RequestMapping(path = "/registro-salon", method = RequestMethod.POST)
	public ModelAndView registroExtras (@ModelAttribute ("Salon") Salon salon,
										HttpServletRequest request) {
		servicioEliminoSalon.eliminarSalon(salon);
		return new ModelAndView("redirect:/elimino-salon"); 
	}
	
	
	
	@RequestMapping(path = "/listado-final-salon", method = RequestMethod.GET)
	public ModelAndView listadoExtras (HttpServletRequest request) {
	//	if(request.getSession().getAttribute("ROL")=="1") {
			ModelMap modelo = new ModelMap();
			modelo.put("listadoFinal", listarSalonesEliminados.listarSalonesEliminados());
			return new ModelAndView("listado-final-salon", modelo);
	//	}
	//	return new ModelAndView("redirect:/home");
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

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
        //encontrar zalones por zona
        Set<Salon> salonesCapital=servicioSalon.buscarSalonesCapital(cantidad, fecha);
        Set<Salon> salonesZonaSur=servicioSalon.buscarSalonesZonaSur(cantidad, fecha);
        Set<Salon> salonesZonaOeste=servicioSalon.buscarSalonesZonaOeste(cantidad, fecha);
        Set<Salon> salonesZonaNorte=servicioSalon.buscarSalonesZonaNorte(cantidad, fecha);


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
    public ModelAndView validar(@ModelAttribute("salon") RegistroSalonViewModel salon,
                                   @ModelAttribute("horario") String horario,
                                @ModelAttribute("fecha") String fecha,
                                @ModelAttribute("cantidad") Integer cantidad,
                                HttpServletRequest request) {//esta en la url
        ModelMap modelo = new ModelMap();

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