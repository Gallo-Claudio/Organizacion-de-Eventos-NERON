package ar.edu.unlam.tallerweb1.modelo;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ar.edu.unlam.tallerweb1.viewmodel.RegistroIngresoMenuViewModel;



public class MenuValidar implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroIngresoMenuViewModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		RegistroIngresoMenuViewModel menu=(RegistroIngresoMenuViewModel)target; // Se hace una refundicion de Object
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descripcion",
        "required.descripcion", "El campo Descripcion es Obligatorio.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precio",
        "required.precio", "El campo Precio es Obligatorio.");
	}
}