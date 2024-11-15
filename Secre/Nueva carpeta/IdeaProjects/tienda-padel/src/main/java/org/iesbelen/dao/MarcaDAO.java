package org.iesbelen.dao;

import org.iesbelen.model.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaDAO {
    public void create(Marca marca);
    public List<Marca> getAll();
    public Optional<Marca> find(int id);
    public void update(Marca marca);
    public void delete(int id);
}
