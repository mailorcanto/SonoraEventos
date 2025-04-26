package com.sonoraeventos.sonora.service;

import com.sonoraeventos.sonora.data.OrcamentoEntity;
import com.sonoraeventos.sonora.data.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    @Autowired
    public OrcamentoService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    public List<OrcamentoEntity> listarOrcamentos() {
        return orcamentoRepository.findAll();
    }

    public OrcamentoEntity salvarOrcamento(OrcamentoEntity orcamento) {
        return orcamentoRepository.save(orcamento);
    }
}


