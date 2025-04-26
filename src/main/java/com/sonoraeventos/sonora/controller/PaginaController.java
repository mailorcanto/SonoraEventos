package com.sonoraeventos.sonora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PaginaController {

    @GetMapping("/orcamentos")
    public String orcamentos() {
        return "orcamentos.html";
    }

    @GetMapping("/servicos")
    public String servicos() {
        return "servicos.html";
    }

    @GetMapping("/")
    public String home() {
        return "index.html";
    }
}

