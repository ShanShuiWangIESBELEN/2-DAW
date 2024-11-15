package org.iesbelen.dao;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.iesbelen.model.Fabricante;

public class FabricanteDTO extends Fabricante {

    private Integer countProductos;

    public FabricanteDTO(){

    }

    public Integer getCountProductos(){
        return countProductos;
    }

    public void setCountProductos(Integer countProductos){
        this.countProductos = countProductos;
    }
}
