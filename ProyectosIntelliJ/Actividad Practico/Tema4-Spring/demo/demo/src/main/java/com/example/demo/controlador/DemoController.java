package com.example.demo.controlador;

import com.example.demo.modelo.Libro;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class DemoController {

    @GetMapping("/")
    public String demoTH(Model model) {
        String parrafo = "Este es un parrafo";
        model.addAttribute("parrafo", parrafo);
        return "demoth";
    }

    @GetMapping("/demonth2")
    public String demoTH2(Model model) {

        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro("El Quijote", "Miguel Cervantes", "Anaya"));
        libros.add(new Libro("Crimen y Castigo", "Fedor Dostoievski", "Santillana"));
        libros.add(new Libro("Oliver Twist", "Charles Dickens", "Tusquests"));

        model.addAttribute(libros); //Equivalente a model.addAttribute("libroList", libros)

        return "demoth2";
    }

    @GetMapping("/demoth3")
    public String demoth3(Model model, HttpSession session) {

        String variable = "Hola, mundo!";

        model.addAttribute("unaVariable", variable);

        String variableSesion = "Esto es una variable de sesión...";

        session.setAttribute("unaVariableDeSesion", variableSesion);

        Libro libro = new Libro("El Quijote", "Miguel Cervantes", "Anaya");
        session.setAttribute("ElQuijote", libro);

        return "demoth3";
    }


    @GetMapping("/demoth4")
    public String demoth4(Model model) {
        Libro libro = new Libro("El Quijote", "Miguel Cervantes", "Anaya");
        model.addAttribute("libro", libro);
        return "demoth4";
    }

    @GetMapping("/demoth5")
    public String demoTH5(Model model) {
        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");
        model.addAttribute("libro", libro);
        return "demoth5";
    }

    @GetMapping("/demoth6")
    public String demoth6(Model model) {

        Libro libro = new Libro(1, "El Quijote", "Miguel Cervantes", "Anaya");

        model.addAttribute("libro", libro);

        return "demoth6";
    }

    @GetMapping("/demoth7")
    public String demoth7(Model model) {

        return "demoth7";
    }
}
