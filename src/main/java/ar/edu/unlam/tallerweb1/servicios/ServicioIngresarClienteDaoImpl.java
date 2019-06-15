package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.IngresarClienteDao;

import ar.edu.unlam.tallerweb1.modelo.Cliente;



@Service("servicioIngresarClienteDao")
@Transactional
public class ServicioIngresarClienteDaoImpl implements ServicioIngresarClienteDao {

	
	@Inject
	private IngresarClienteDao ingresarClienteDao;
	
	@Override
	public void ingresarCliente(Cliente cliente) {
		ingresarClienteDao.ingresarCliente(cliente);
		
	}

}
