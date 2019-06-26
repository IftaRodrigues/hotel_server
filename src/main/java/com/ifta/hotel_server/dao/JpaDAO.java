package com.ifta.hotel_server.dao;

import com.ifta.hotel_server.model.Cadastro;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class JpaDAO<T extends Cadastro> implements DAO<T> {
    private final EntityManager em;
    private final Class<T> classe;

    public JpaDAO(EntityManager em, Class<T> classe){
        this.em = em;
        this.classe = classe;
    }

    @Override
    public T findById(long id) {
        return em.find(classe, id);
    }

    @Override
    public boolean remove(T entity) {
        em.remove(entity);
        return true;
    }

    @Override
    public void save(T entity) {
        em.persist(entity);
    }

    @Override
    public T findByField(String fieldName, Object value) {
        final String jpql = "select o from " + classe.getSimpleName() + " o " +
                            " where o." + fieldName + " = :" + fieldName;
        TypedQuery<T> query = em.createQuery(jpql, classe);
        query.setParameter(fieldName, value);
        return query.getSingleResult();
    }

    @Override
    public T findByFields(String[] fieldNames, Object[] values) {
        if(fieldNames.length != values.length)
            throw new IllegalArgumentException("A quantidade de valores e campos devem ser iguais!");
        if(fieldNames.length == 0)
            throw new IllegalArgumentException("É preciso informar um valor e um campo!");
              
        String jpql = "select o from " + classe.getSimpleName() + " o where ";
        for (int i = 0; i < fieldNames.length; i++) {
           jpql +=  " o." + fieldNames[i] + " = :" + fieldNames[i];
            
        }
                            
        TypedQuery<T> query = em.createQuery(jpql, classe);
        
        for (int i = 0; i < fieldNames.length; i++) {
            query.setParameter(fieldNames[i], values[i]);
        }
        
        return query.getSingleResult();
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }
}
