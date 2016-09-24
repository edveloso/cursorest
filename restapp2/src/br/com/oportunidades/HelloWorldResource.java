package br.com.oportunidades;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("hello")
public class HelloWorldResource {

	private static Map<Integer, Todo> repositorio = new HashMap<Integer, Todo>();
	static {
		repositorio.put(1, new Todo("veloso", 20));
		repositorio.put(2, new Todo("jose", 30));
		repositorio.put(3, new Todo("maria", 40));
	}
	
	
	//demo02
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(){
		return "Hello";
	}
	
	
	//demo03
	@GET
	@Path("todo")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo todo(){
		return new Todo("veloso");
	}
	
	
	//demo04
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Todo> todos(){
		List<Todo> lista = new ArrayList<Todo>();
		for(Integer e :  repositorio.keySet()){
			lista.add(repositorio.get(e));
		}
		return lista;
	}
	
	
	//demo5 CRUD
	@GET
	@Path("todos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Todo getBy(@PathParam("id") int id){
		Todo retorno = repositorio.get(id);
		return retorno;
	}
	

	
	@DELETE
	@Path("atodos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id){
		repositorio.remove(id);
		return Response.status(410).build();
	}

	
	@GET
	@Path("atodos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponseBy(@PathParam("id") int id){
		Todo retorno = repositorio.get(id);
		if(retorno == null){
			return Response.status(Response.Status.NOT_FOUND).entity("404 Nao encontrado").type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(200).entity(retorno).build();
	}

	
	@POST
	@Path("atodos/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response post(Todo todo) throws URISyntaxException{
		int key = repositorio.size() +1;
		repositorio.put(key, todo);
		URI uri = new URI("http://localhost:8080/restapp1/rest/hello/todos/"+key);
		return Response.status(201).entity(uri).build();
	}


	@PUT
	@Path("atodos/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, Todo todo) throws URISyntaxException{
		int key = repositorio.size() +1;
		Todo retorno = repositorio.get(id);
		repositorio.put(id, todo);
		return Response.status(204).build();
	}
	
	@GET
	@Path("atodos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response query(@QueryParam("nome") String nome) throws URISyntaxException{
		Todo retorno = null;
		for(Integer key : repositorio.keySet()){
			Todo todo = repositorio.get(key);
			if(todo.getNome().equals(nome)){
				retorno = todo;
			}
		}
		return Response.status(204).entity(retorno).build();
	}

	
}
