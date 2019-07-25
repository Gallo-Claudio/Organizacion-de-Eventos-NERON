package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.BuscoFechaDao;
import ar.edu.unlam.tallerweb1.dao.PersonalDao;
import ar.edu.unlam.tallerweb1.dao.RegistroFechaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Licencia;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Personal;
import ar.edu.unlam.tallerweb1.modelo.Reserva;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;



@Service("servicioValidacionSeleccionFecha")
@Transactional
public class ServicioValidacionSeleccionFechaImp implements ServicioValidacionSeleccionFecha {
	@Inject
	private ServicioValidoFecha servicioValidoFecha;
	
	@Inject
	private ServicioRegistroFecha servicioRegistroFecha;
	
	@Inject
	private RegistroFechaDao registroFechaDao;
	
	@Inject
	private BuscoFechaDao buscoFechaDao;
	
	@Inject
	private PersonalDao personalDao;
	
	
	
	@Override
	public String validacionSeleccionFecha(Long idPersonal,String fecha2) {
		String mensajeFinal = "";
		
	       if(fecha2==""){
	        	mensajeFinal = mensajeFinal + "Debe ingresar una fecha" + "<br/>";
	        }
//	       LocalDate fechaEvento = LocalDate.parse(fecha2);
	        else {
	            LocalDate fechaActual = LocalDate.now();
	            LocalDate fechaEvento = LocalDate.parse(fecha2);

	            if(fechaActual.compareTo(fechaEvento)>=0 ){
	            	mensajeFinal = mensajeFinal + "Fecha invalida - La fecha seleccionada no puede ser anterior al día de hoy";
	            } 
	            else {
	            	if(buscoFechaDao.buscoFechasDeLicenciaPorIdDePersonal(idPersonal)!=null){
	            			List <Licencia> recorroLista = buscoFechaDao.buscoFechasDeLicenciaPorIdDePersonal(idPersonal);
	            			

	            			Iterator <Licencia> r = recorroLista.iterator();
	            			Licencia licencia;
	            			while (r.hasNext()) {
	            				licencia=r.next();
	            				if(licencia.getFechasLicencias()==fechaEvento) {
	            					mensajeFinal = mensajeFinal + "La fecha ya ha sido pedida" ; 
	            					return mensajeFinal;
	            				}
	            			}
	            			Licencia licenciapedida = new Licencia ();
	            			Personal personal = personalDao.buscarPersonalPorId(idPersonal);
//	            			licenciapedida.setPersonal_licencia(personal);
        					licenciapedida.setFechasLicencias(fechaEvento);
    	            		registroFechaDao.registroFecha(licenciapedida);
    	            		
	            	}
	            				
	            	else {
	            		Licencia licencia = new Licencia ();
	            		Personal personal = personalDao.buscarPersonalPorId(idPersonal);
//	            		licencia.setPersonal_licencia(personal);
	            		licencia.setFechasLicencias(fechaEvento);
	            		registroFechaDao.registroFecha(licencia);
	            	}
	            	

	            }
	        }
	            	
	
		
	return mensajeFinal;
	}
	        }
	        
			

	