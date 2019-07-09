package ar.edu.unlam.tallerweb1.validadores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarMenuPorId;
import ar.edu.unlam.tallerweb1.servicios.ServicioListadoOpcionesMenu;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


public class MenuSeleccionValidar implements Validator {
	
	@Inject
	private ServicioBuscarMenuPorId servicioBuscarMenuPorId;
	

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroMenuViewModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistroMenuViewModel menu=(RegistroMenuViewModel)target; // Se hace una refundicion de Object
		Integer fingerFood=0, entrada=0, principal=0, bebida=0, postre=0, mesaDulce=0;
				
				
        ValidationUtils.rejectIfEmpty(errors, "idmenu", "required.idmenu", "Debe realizar una seleccion del menu");
        
        
        
     	// Genero una coleccion de Ids de TipoDeMenu de lo seleccionado por el cliente
        for (int i=0; i<menu.getIdmenu().length; i++) {
        	Long idMenu = menu.getIdmenu()[i];
        	if(idMenu!=null) {
 
        		
        		
        		//		Menu menuBuscado = servicioBuscarMenuPorId.buscaMenuPorId(9L);
        		Integer idTipoMenu = (int) (long) servicioBuscarMenuPorId.buscaMenuPorId(9L).getTipoDeMenu().getId();
        		// Se lleva un registro de la cantidad de apariciones por cada TipoDeMenu
        		switch (idTipoMenu) {
        		case 1:
        			fingerFood++;
					break;
        		case 2:
					entrada++;
					break;
        		case 3:
					principal++;
					break;
        		case 4:
					bebida++;
					break;
        		case 5:
					postre++;
					break;
        		case 6:
					mesaDulce++;
					break;
        		}
        	}
        }
        

       if (fingerFood<3 || fingerFood>5){
            //    errors.rejectValue("correo", "correo.incorrect", "Debe elegir como mínimo 3 FingerFood y como máximo 5");
                errors.reject("Debe elegir como mínimo 3 FingerFood y como máximo 5");
       }
        
        
        
	}
}