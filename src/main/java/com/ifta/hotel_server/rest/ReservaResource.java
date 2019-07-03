package com.ifta.hotel_server.rest;

import com.ifta.hotel_server.dao.DAO;
import com.ifta.hotel_server.model.Reserva;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reserva")
public class ReservaResource {

    @Inject
    private DAO<Reserva> dao;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Reserva reserva) {
        dao.save(reserva);
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") long id) {
        Reserva reserva = dao.findById(id);
        return dao.remove(reserva);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Reserva reserva) {
        dao.save(reserva);
    }
}
