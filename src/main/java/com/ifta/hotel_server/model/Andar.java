package com.ifta.hotel_server.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Andar implements Cadastro, Serializable{
    
     /*perguntar para o prof sobre essa questão dos relacionamentos no hibernate*/
    @OneToOne
    private Hotel hotel;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    /*perguntar para o prof sobre essa questão dos relacionamentos no hibernate*/
    @OneToMany(mappedBy = "andar_quarto")
    private List<Quarto> quartos = new ArrayList<Quarto>();

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id=id;
    }

    public List<Quarto> getQuartos() {
        return quartos;
    }

    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }
    
}
