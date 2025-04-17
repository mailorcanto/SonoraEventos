package com.sonoraeventos.sonora.controller;

import com.sonoraeventos.sonora.model.Orcamento;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private List<Orcamento> orcamentos = new ArrayList<>();

    @GetMapping
    public List<Orcamento> listarOrcamentos() {
        return orcamentos;
    }

    @PostMapping
    public Orcamento enviarOrcamento(@RequestBody Orcamento orcamento) {
        orcamentos.add(orcamento);
        return orcamento;
    }
}