package com.sonoraeventos.sonora.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    private Long id;
    private String nome;
    private String descricao;
}
