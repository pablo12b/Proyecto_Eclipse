package ec.edu.ups.business;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ClienteDAO;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Detalle;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	@Inject
	private ClienteDAO daoCliente;
	@PostConstruct
	public void init() {
		System.out.println("Iniciando");
		List<Detalle> detalles = new ArrayList<Detalle>();
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDireccion("Monay");
		cliente.setDni("0107956088");
		cliente.setNombre("Pablo Bravo");
		Detalle detalle = new Detalle();
		detalle.setDeudas(200.45);
		detalle.setId(1);
		detalle.setMes("Agosto");
		detalles.add(detalle);
		detalle = new Detalle();
		detalle.setDeudas(500.45);
		detalle.setId(2);
		detalle.setMes("Enero");
		detalles.add(detalle);
		detalle = new Detalle();
		detalle.setDeudas(400.45);
		detalle.setId(3);
		detalle.setMes("Diciembre");
		detalles.add(detalle);
		cliente.setDetalles(detalles);
		daoCliente.insert(cliente);
	}	
}
