package com.sonoraeventos.sonora.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class PaginaController {

    @GetMapping("/orcamentos")
    public void orcamentos(HttpServletResponse response) throws IOException {
        response.sendRedirect("/html/orcamentos.html");
    }

    @GetMapping("/servicos")
    public void servicos(HttpServletResponse response) throws IOException {
        response.sendRedirect("/html/servicos.html");
    }

    @GetMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/html/index.html");
    }
}
