package ar.edu.unlam.tallerweb1.servicios;


import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresoDeMenuDao;
import ar.edu.unlam.tallerweb1.modelo.Bebida;
import ar.edu.unlam.tallerweb1.modelo.Entrada;
import ar.edu.unlam.tallerweb1.modelo.FingerFood;
import ar.edu.unlam.tallerweb1.modelo.MesaDulce;
import ar.edu.unlam.tallerweb1.modelo.PlatoPrincipal;
import ar.edu.unlam.tallerweb1.modelo.Postre;
import ar.edu.unlam.tallerweb1.modelo.Reserva;



@Service("servicioIngresoDeMenu")
@Transactional
public class ServicioIngresoDeMenuImpl implements ServicioIngresoDeMenu {

	@Inject
	private IngresoDeMenuDao ingresoDeMenuDao;

	@Override
	public void guardarSeleccionMenu(Long id,Long seleccionFingerFood, Long seleccionEntrada, Long seleccionPlatoPrincipal, Long seleccionBebida, Long seleccionPostre, Long seleccionMesaDulce) {

		FingerFood fingerFood = new FingerFood();
		fingerFood.setId(seleccionFingerFood);
		Entrada entrada = new Entrada();
		entrada.setId(seleccionEntrada);
		PlatoPrincipal platoPrincipal = new PlatoPrincipal();
		platoPrincipal.setId(seleccionPlatoPrincipal);
		Bebida bebida = new Bebida();
		bebida.setId(seleccionBebida);
		Postre postre = new Postre();
		postre.setId(seleccionPostre);
		MesaDulce mesaDulce = new MesaDulce();
		mesaDulce.setId(seleccionMesaDulce);
		
		Reserva menuReserva = ingresoDeMenuDao.traerReserva(id);
		menuReserva.setFingerFood(fingerFood);
		menuReserva.setEntrada(entrada);
		menuReserva.setPlatoPrincipal(platoPrincipal);
		menuReserva.setBebida(bebida);
		menuReserva.setPostre(postre);
		menuReserva.setMesaDulce(mesaDulce);
		ingresoDeMenuDao.guardarReserva(menuReserva);
		//ingresoDeMenuDao.guardarMenuSeleccionado(menuReserva);
		
	}


}
