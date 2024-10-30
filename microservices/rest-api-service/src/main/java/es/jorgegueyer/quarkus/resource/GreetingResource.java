package es.jorgegueyer.quarkus.resource;

import es.jorgegueyer.quarkus.service.TraceService;
import io.quarkus.rest.client.reactive.QuarkusRestClientBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.net.URI;

@Path("/hello")
public class GreetingResource {

    private static final Logger logger = Logger.getLogger(GreetingResource.class.getName());

    private final TraceService traceService;


    public GreetingResource() {
        this.traceService = QuarkusRestClientBuilder.newBuilder()
                .baseUri(URI.create("http://localhost:8080"))
                .build(TraceService.class);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        logger.info("Hello from Quarkus REST");
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/trace")
    public String trace() {
        logger.info("Trace from Quarkus REST");
        return traceService.trace();
    }
}
