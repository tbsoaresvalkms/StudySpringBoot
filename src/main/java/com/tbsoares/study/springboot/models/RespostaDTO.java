package com.tbsoares.study.springboot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {
    private Double valorTotal;
    private Long pedido;
    private String mensagem;
}
