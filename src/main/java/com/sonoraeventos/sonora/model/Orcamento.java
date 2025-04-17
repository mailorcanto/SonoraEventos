package com.sonoraeventos.sonora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orcamento {
    private Long id;
    private String nomeCliente;
    private String email;
    private String telefone;
    private String dataEvento;
    private String local;
    private int numeroConvidados;
    private List<Servico> servicosDesejados;
    private String observacoes;
}