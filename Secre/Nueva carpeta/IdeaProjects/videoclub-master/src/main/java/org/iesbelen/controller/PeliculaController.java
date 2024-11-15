package org.iesbelen.controller;


import org.iesbelen.domain.Pelicula;
import org.iesbelen.dto.PeliculaDTO;
import org.iesbelen.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller

@RequestMapping("/pelicula")
public class PeliculaController {


    private PeliculaService peliculaService;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping("") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<PeliculaDTO> listaPelicula = peliculaService.listAll();
        model.addAttribute("listaPelicula", listaPelicula);

        return "pelicula";

    }

    @GetMapping("/crear")
    public String crear (@ModelAttribute Pelicula pelicula, Model model){

        return "pelicula-crear";

    }

    ////////////////////////////////////////////////////////////////////

    @PostMapping("/crear")
    public String submitCrear(@ModelAttribute Pelicula pelicula, Model model) {

        peliculaService.crear(pelicula);

        return "pelicula" ;

    }
}
