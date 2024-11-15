package org.iesbelen.dao;

import org.iesbelen.model.Pala;

import java.util.List;
import java.util.Optional;

public interface PalaDAO {
    public void create(Pala pala);
    public List<Pala> getAll();
    public Optional<Pala> find(int id);
    public void update(Pala pala);
    public void delete(int id);
    public List<Pala> filtrar(String filtro);

}
