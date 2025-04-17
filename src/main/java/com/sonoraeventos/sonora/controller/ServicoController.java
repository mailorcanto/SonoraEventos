package com.sonoraeventos.sonora.controller;

import com.sonoraeventos.sonora.model.Servico;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private List<Servico> servicos = new ArrayList<>();

    @GetMapping
    public List<Servico> listarServicos() {
        return servicos;
    }

    @PostMapping
    public Servico adicionarServico(@RequestBody Servico servico) {
        servicos.add(servico);
        return servico;
    }
}
