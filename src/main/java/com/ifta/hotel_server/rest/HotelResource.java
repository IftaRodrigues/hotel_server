/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.hotel_server.rest;


import com.ifta.hotel_server.dao.DAO;
import com.ifta.hotel_server.dao.HotelDAO;
import com.ifta.hotel_server.model.Andar;
import com.ifta.hotel_server.model.Hotel;
import java.util.List;
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
/**
 *
 * @author ifta
 */
@Path("/quarto")
public class HotelResource {
    @Inject
    private HotelDAO dao;
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@PathParam("id") long id) {
        return dao.findById(id);
    }
     
    @GET
    @Path("{cidadeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> findByCidade(@PathParam("cidadeId") long cidadeId) {
        return dao.findByCidade(cidadeId);
    }
   
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Hotel quarto) {
        dao.save(quarto);
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean remove(@PathParam("id") long id) {
        Hotel quarto=dao.findById(id);
        return dao.remove(quarto);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void update(Hotel quarto){
        dao.save(quarto);
    }
    }


