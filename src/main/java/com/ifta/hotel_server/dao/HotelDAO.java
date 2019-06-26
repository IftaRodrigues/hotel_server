/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifta.hotel_server.dao;

import com.ifta.hotel_server.model.Hotel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ifta
 */
public class HotelDAO extends JpaDAO<Hotel>{
    
    public HotelDAO(EntityManager em) {
        super(em, Hotel.class);
    }
    
    public List<Hotel> findByCidade(long cidadeId){
        final String jpql = "select o from Hotel o " +
                            " where o.bairro.cidade.id = :cidadeId";
        TypedQuery<Hotel> query = getEm().createQuery(jpql, Hotel.class);
        query.setParameter("cidadeId", cidadeId);
        return query.getResultList();
    
    }
    
    
}
