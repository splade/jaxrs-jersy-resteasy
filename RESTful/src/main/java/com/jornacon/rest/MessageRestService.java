package com.jornacon.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Project name: JAXRS
 * Created by: jornacon
 * On date: 18/05/14
 */
@Path("/message")
public class MessageRestService {
    @GET
    @Path("/{param}")
    public Response printMessage(@PathParam("param") String msg){
        String result = "Restful example: " + msg;
        return Response.status(200).entity(result).build();
    }
}
