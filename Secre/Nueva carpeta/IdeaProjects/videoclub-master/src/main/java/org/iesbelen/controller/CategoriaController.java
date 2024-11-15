package org.iesbelen.controller;


import org.iesbelen.domain.Categoria;
import org.iesbelen.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller

@RequestMapping("/categoria")
public class CategoriaController {

    private CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id) {

        Optional<Categoria> categoria = categoriaService.find(id);
        if (categoria.isPresent()) {
            model.addAttribute("categoria", categoria.get());
            return "templates/categoria/detalle-categoria";
        } else {
            return "categoria/categoria";
        }

    }
}
