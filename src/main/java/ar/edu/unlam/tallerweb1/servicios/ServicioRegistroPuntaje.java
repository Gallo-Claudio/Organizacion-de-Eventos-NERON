
package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.PuntajeMenu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

// Interface que define los metodos del Servicio de Regisatros de platos del Menu.
public interface ServicioRegistroPuntaje {

	void ingresarPuntaje(List<PuntajeMenu> puntajesMenu,Long tipodemenu);

}
