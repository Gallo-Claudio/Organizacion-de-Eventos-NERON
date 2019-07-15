package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroPlatosMenuDao;
import ar.edu.unlam.tallerweb1.viewmodel.RegistroMenuViewModel;


@Service("servicioValidacionSeleccionExtra")
@Transactional
public class ServicioValidacionSeleccionExtraImpl implements ServicioValidacionSeleccionExtra {


	@Override
	public String validacionSeleccionExtra(RegistroMenuViewModel vm) {
		String mensajeFinal = "";
		
		if(vm.getIdmenu().length>3) {
			mensajeFinal = mensajeFinal + "Como máximo solo puede seleccionar 2 Extras";
			}

		return mensajeFinal;
	}
}