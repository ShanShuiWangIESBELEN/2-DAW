package org.iesbelen.repository;

import java.util.List;
import java.util.Optional;

import org.iesbelen.domain.Categoria;

public interface CategoriaRepository {

    public Optional<Categoria>  find(int id);

}