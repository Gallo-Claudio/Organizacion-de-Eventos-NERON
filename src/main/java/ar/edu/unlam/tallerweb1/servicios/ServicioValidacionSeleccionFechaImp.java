package ar.edu.unlam.tallerweb1.servicios;

import java.time.LocalDate;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;



@Service("servicioValidacionSeleccionFecha")
@Transactional
public class ServicioValidacionSeleccionFechaImp implements ServicioValidacionSeleccionFecha {
	@Override
	public String validacionSeleccionFecha(String fecha) {
		String mensajeFinal = "";
	       if(fecha==""){
	        	mensajeFinal = mensajeFinal + "Debe ingresar una fecha" + "<br/>";
	        }
	        else {
	            LocalDate fechaActual = LocalDate.now();
	            LocalDate fechaEvento = LocalDate.parse(fecha);

	            if(fechaActual.compareTo(fechaEvento)>=0 ){
	            	mensajeFinal = mensajeFinal + "Fecha invalida - La fecha seleccionada no puede ser anterior al día de hoy";
	            }
	        }
			return mensajeFinal;
		}
	}