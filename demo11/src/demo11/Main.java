package demo11;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Main {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/restapp1");
		String retorno = target.path("/rest/todos")
								.request().get(String.class);
		System.out.println(retorno);
		
	}
	
}
