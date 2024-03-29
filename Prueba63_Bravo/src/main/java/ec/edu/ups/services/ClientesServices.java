package ec.edu.ups.services;

import java.util.List;

import ec.edu.ups.business.GestionClientes;
import ec.edu.ups.modelo.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("clientes")
public class ClientesServices {
	@Inject
	private GestionClientes gClientes;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Cliente> clientes = gClientes.getClientes();
		if(clientes.size()>0)
			return Response.ok(clientes).build();
		ErrorMessage error = new ErrorMessage(6, "No se registran clientes");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Path("{dni}/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces("application/json")
	public Response leer2(@PathParam("dni") String cedula, @PathParam("nombre") String nombre) {
		try{
			System.out.println("cedula " +  cedula + " nom=" + nombre);
			Cliente cli = gClientes.getClientePorCedula(cedula);
			return Response.ok(cli).build();
		}catch (Exception e) {
			// TODO: handle exception
			ErrorMessage error = new ErrorMessage(4, "Cliente no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
}
