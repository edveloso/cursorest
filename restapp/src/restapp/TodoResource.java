package restapp;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/todos")
public class TodoResource {
	
	private static TodoDAO dao;
	
	public TodoResource() {
		dao = new TodoDAO();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> getTodos(){
		return dao.listar();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Todo todo){
		dao.salvar(todo);
		return Response.status(Response.Status.CREATED).entity(todo).build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response edit(Todo todo, @PathParam("id") int id){
		dao.alterar(id, todo);
		return Response.status(204).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consulta(@PathParam("id") int id){
		Todo todo = dao.get(id);
		if(null == todo){
			return Response.status(404)
					.entity("{\"message\": \"Todo não encontrado\"}")
					.type(MediaType.APPLICATION_JSON)
					.build();
		}
		return Response.status(200)
				.entity(todo)
				.build();
	}
	
	
	
}


