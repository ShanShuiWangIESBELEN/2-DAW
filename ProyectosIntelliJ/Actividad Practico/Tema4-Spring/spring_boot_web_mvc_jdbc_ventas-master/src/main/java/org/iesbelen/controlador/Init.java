package org.iesbelen.controlador;

import org.springframework.web.bind.annotation.GetMapping;

public class Init {
    @GetMapping("/")
    public String init() {

        return "index";
    }
}
