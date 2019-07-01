package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.Menu2;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

public interface RegistroPlatosMenuDao2 {
	
	void registraPlatosAlMenu (Menu menu);
	Menu2 traerMenuPorId2(Long id);
	
	TipoDeMenu traerTipoDeMenuPorId(Long id);
}
