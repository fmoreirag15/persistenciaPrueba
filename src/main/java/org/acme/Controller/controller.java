package org.acme.Controller;

import org.acme.model.Persona;
import org.acme.service.Service;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/v2")
public class controller {
    @Inject
    Validator validator;
    @Inject
    Service service;
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardar(Persona persona) {
        Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
        if (violations.isEmpty()) {
           return Response.ok().entity(service.guardar(persona)).build();
        }else
        {
            return Response.status(500).entity(violations.stream()
                    .map(cv -> cv == null ? "null" : "{" +
                            cv.getPropertyPath() + ": " +
                            cv.getMessage() + "}")
                    .collect(Collectors.joining(","))).build();}

    }
    @Path("/list/{edad}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response listar(@PathParam("edad")  Integer edad) {

        return Response.ok().entity(service.lista(edad)).build();
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modificar(Persona persona) {
        Set<ConstraintViolation<Persona>> violations = validator.validate(persona);
        if (violations.isEmpty()) {
            return  Response.ok().entity(service.modificar(persona)).build();
        }else
        {
            return Response.status(500).entity(violations.stream()
                    .map(cv -> cv == null ? "null" : "{" +
                            cv.getPropertyPath() + ": " +
                            cv.getMessage() + "}")
                    .collect(Collectors.joining(","))).build();}

    }
    @Path("/list/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscrId(@PathParam("id")  Integer id) {

        return Response.ok().entity(service.buscarporID(id)).build();
    }
}