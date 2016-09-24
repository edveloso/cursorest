package br.com.oportunidades;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExHandler implements ExceptionMapper<TodoNotFoundException> {

	@Override
	public Response toResponse(TodoNotFoundException e) {
		if(e instanceof TodoNotFoundException){
			return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
		}
		return Response.status(503).entity(e.getMessage()).type(MediaType.APPLICATION_JSON).build();
	}

}
