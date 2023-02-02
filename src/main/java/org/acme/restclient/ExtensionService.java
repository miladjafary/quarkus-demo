package org.acme.restclient;

import jdk.jfr.Registered;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Set;

@Path("/extensions")
@RegisterRestClient
@RegisterClientHeaders(RequestUUIDHeaderFactory.class)
public interface ExtensionService {

    @GET
    Set<Extension> getById(@QueryParam("id") String id);
}
