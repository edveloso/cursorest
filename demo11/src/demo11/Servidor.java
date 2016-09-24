package demo11;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	
	public static void main(String[] args) throws IOException {
		ResourceConfig config = new ResourceConfig().packages("demo11");
        URI uri = URI.create("http://localhost:8080/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config, false);
        Runtime.getRuntime().addShutdownHook(new Thread(){
        	@Override
        	public void run() {
        		server.stop();
        	}
        });
        server.start();
        System.in.read();
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8080");
//        String conteudo = target.path("/produtos").request().get(String.class);
//        System.out.println(conteudo);
//        server.stop();
	}
	
}
