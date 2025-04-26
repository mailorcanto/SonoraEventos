package com.sonoraeventos.sonora.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orcamento")
@Data
public class OrcamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCliente;
    private String emailCliente;
    private String telefoneCliente;
    private String dataEvento;
    private String tipoEvento;
    private Integer numeroConvidados;
    private String observacoes;
    private String servicosDesejados;
}





