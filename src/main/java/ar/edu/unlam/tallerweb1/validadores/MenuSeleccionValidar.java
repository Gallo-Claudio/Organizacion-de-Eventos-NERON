package ar.edu.unlam.tallerweb1.validadores;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


public class MenuSeleccionValidar implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroMenuViewModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

//		RegistroIngresoMenuViewModel menu=(RegistroIngresoMenuViewModel)target; // Se hace una refundicion de Object

        ValidationUtils.rejectIfEmpty(errors, "idmenu", "required.idmenu", "Debe realizar una seleccion del menu");
        
        
 //       if (!(menu.getCorreo() != null && menu.getCorreo().isEmpty()))
  //      {
 //           this.pattern = Pattern.compile(EMAIL_PATTERN);
  //          this.matcher = pattern.matcher(menu.getCorreo());
  //           if (!matcher.matches()) {
 //               errors.rejectValue("correo", "correo.incorrect",
 //                 "El E-Mail "+menu.getCorreo()+" no es válido");
 //              }
//        }
        
        
        
	}
}