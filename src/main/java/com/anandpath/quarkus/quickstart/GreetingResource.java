package com.anandpath.quarkus.quickstart;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

	@Inject
	GreetingService greetingService;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/greeting/{name}")
	public String greeting(@PathParam("name") String name) {
		return greetingService.greeting(name);
	}
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String hello() {
        return "hello";
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/asyncHello")
    public CompletionStage<String> asyncHello() {
        return CompletableFuture.supplyAsync(() -> {
            return "hello re bawa\n";
        });
    }
}