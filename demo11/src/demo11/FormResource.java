package demo11;

import java.io.InputStream;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

@Path("/form")
@Produces("text/html")
public class FormResource {


    @Context
    HttpHeaders headers;

    @Path("colours")
    public String getColours() {
        return "helo";
    }

    /**
     * Produce a form from a static HTML file packaged with the compiled class
     * @return a stream from which the HTML form can be read.
     */
    @GET
    public Response getForm() {
        Date now = new Date();

        InputStream entity = this.getClass().getClassLoader().getResourceAsStream("form.html");
        System.out.println(entity);
        return Response.ok(entity)
                .cookie(new NewCookie("date", now.toString())).build();
    }

    /**
     * Process the form submission. Produces a table showing the form field
     * values submitted.
     * @return a dynamically generated HTML table.
     * @param formData the data from the form submission
     */
    @POST
    @Consumes("application/x-www-form-urlencoded")
    public Response processForm(MultivaluedMap<String, String> formData) {
        StringBuilder buf = new StringBuilder();
        buf.append("<html><head><title>Form results</title></head><body>");
        buf.append("<p>Hello, you entered the following information: </p><table border='1'>");
        for (String key : formData.keySet()) {
            if (key.equals("submit")) {
                continue;
            }
            buf.append("<tr><td>");
            buf.append(key);
            buf.append("</td><td>");
            buf.append(formData.getFirst(key));
            buf.append("</td></tr>");
        }
        for (Cookie c : headers.getCookies().values()) {
            buf.append("<tr><td>Cookie: ");
            buf.append(c.getName());
            buf.append("</td><td>");
            buf.append(c.getValue());
            buf.append("</td></tr>");
        }

        buf.append("</table></body></html>");
        return Response.status(200).entity(buf.toString()).build();
    }

}
