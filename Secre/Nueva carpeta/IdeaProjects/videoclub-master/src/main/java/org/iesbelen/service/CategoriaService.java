package org.iesbelen.service;

import org.iesbelen.domain.Categoria;
import org.iesbelen.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoriaService {

    private CategoriaRepository categoriaRepository;

 /*
    public CategoriaService(CategoriaRepository cat) {
        this.categoriaRepository = cat;
    }
*/
    public Optional<Categoria> find(Integer id) {
        return categoriaRepository.find(id);
    }
}
