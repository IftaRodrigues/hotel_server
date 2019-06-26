package com.ifta.hotel_server.config;

import com.ifta.hotel_server.dao.DAO;
import com.ifta.hotel_server.dao.HotelDAO;
import com.ifta.hotel_server.dao.JpaDAO;
import com.ifta.hotel_server.model.Cadastro;
import java.lang.reflect.ParameterizedType;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class Producers {
   @Produces
   @PersistenceContext
   private EntityManager em;
   
   @Produces
   public <T extends Cadastro> DAO<T> getDao(InjectionPoint ip){
        ParameterizedType t = (ParameterizedType) ip.getType();
        Class classe = (Class) t.getActualTypeArguments()[0];
        return new JpaDAO(em, classe);
    }
   
    @Produces
    public HotelDAO getHotelDao(InjectionPoint ip){
        return new HotelDAO(em);
    }
}
