package com.sonoraeventos.sonora.controller;

import com.sonoraeventos.sonora.data.OrcamentoEntity;
import com.sonoraeventos.sonora.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    @Autowired
    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoEntity>> listarOrcamentos() {
        List<OrcamentoEntity> orcamentos = orcamentoService.listarOrcamentos();
        return ResponseEntity.ok(orcamentos);
    }

    @PostMapping
    public ResponseEntity<OrcamentoEntity> enviarOrcamento(@RequestBody OrcamentoEntity orcamento) {
        OrcamentoEntity novoOrcamento = orcamentoService.salvarOrcamento(orcamento);
        return new ResponseEntity<>(novoOrcamento, HttpStatus.CREATED);
    }
}
