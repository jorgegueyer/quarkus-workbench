package es.jorgegueyer.quarkus.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/v1")
public interface TraceService {

    @GET
    @Path("/trace")
    String trace();
}
