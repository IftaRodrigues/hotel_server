/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.hotel_server.rest;


import com.ifta.hotel_server.dao.HotelDAO;
import com.ifta.hotel_server.model.Hotel;
import com.ifta.hotel_server.model.Quarto;
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
@Path("/hotel")
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
    @Path("cidade/{cidadeId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> findByCidade(@PathParam("cidadeId") long cidadeId) {
        List<Hotel> hoteis = dao.findByCidade(cidadeId);
        return removeAndares(hoteis);
    }
   
    @GET
    @Path("bairro/{bairroId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> findByBairro(@PathParam("bairroId") long bairroId) {
        List<Hotel> hoteis = dao.findByBairro(bairroId);
        return removeAndares(hoteis);
    }

    private List<Hotel> removeAndares(List<Hotel> hoteis) {
        for (Hotel hotel : hoteis) {
            hotel.setAndares(null);
        }
        return hoteis;
    }
    
    //perguntar qual esta mais proximo de estar certo
    @GET
    @Path("/{cidadeId}/{preco}/{camas}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Hotel> findByVarios(@PathParam("cidadeId") long cidadeId,
            @PathParam("preco") float preco,
             @PathParam("camas") int camas) {
        List<Hotel> hoteis = dao.buscaHoteisCidadePrecoCamas(cidadeId, preco, camas);
        
        return removeAndares(hoteis);
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
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Hotel quarto){
        dao.save(quarto);
    }
    }


