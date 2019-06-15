package ar.edu.unlam.tallerweb1.dao;




import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



import ar.edu.unlam.tallerweb1.modelo.Cliente;


@Repository("ingresarClienteDao")
public class IngresarClienteDaoImplementacion implements IngresarClienteDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void ingresarCliente (Cliente cliente) {  

		final Session session = sessionFactory.getCurrentSession();  // Obtengo una sesion
		 session.save(cliente);    // Persisto en la BD, el objeto recibido desde el area de Servicios

	}

}
