package com.ifta.hotel_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Cadastro, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    
    /*perguntar para o prof sobre essa questão dos relacionamentos no hibernate*/
    @OneToMany
    private List<Andar> andares = new ArrayList<Andar>();

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Andar> getAndares() {
        return andares;
    }

    public void setAndares(List<Andar> andares) {
        this.andares = andares;
    }
    
    
    
}
