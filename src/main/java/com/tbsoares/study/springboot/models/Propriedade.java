package com.tbsoares.study.springboot.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Propriedade {
    @Id
    private String nome;
    private String valor;
    private String descricao;
    private String categoria;
    private String subcategoria;
}
