package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

// Interface que define los metodos del Servicio de Regisatros de platos del Menu.
public interface ServicioRegistroPlatoMenu {

	void ingresarPlatosAlMenu(String descripcion, Integer costo, Long tipodemenu);

}
