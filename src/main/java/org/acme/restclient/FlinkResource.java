package org.acme.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/flink")
public class FlinkResource {

    @Inject
    @RestClient
    ExtensionService extensionService;

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Extension> findExtensionById(@PathParam("id") String id) {
        return extensionService.getById(id);
    }
}
