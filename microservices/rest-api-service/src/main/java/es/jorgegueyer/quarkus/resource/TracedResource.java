package es.jorgegueyer.quarkus.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@Path("/v1")
public class TracedResource {

    private static final Logger LOG = Logger.getLogger(TracedResource.class);

    @GET
    @Path("/trace")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOG.info("API trace");
        return "trace";
    }
}
