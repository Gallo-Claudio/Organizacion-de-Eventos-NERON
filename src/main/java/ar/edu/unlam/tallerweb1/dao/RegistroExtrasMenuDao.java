package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Extras;
import ar.edu.unlam.tallerweb1.modelo.Menu;
import ar.edu.unlam.tallerweb1.modelo.TipoDeMenu;

public interface RegistroExtrasMenuDao {
	
	void registraExtrasAlMenu (Extras extras);
	Extras traerExtraPorId(Long id);

}
