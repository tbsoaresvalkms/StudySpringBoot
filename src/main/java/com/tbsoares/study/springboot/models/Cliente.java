package com.tbsoares.study.springboot.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(min = 2, max = 30, message = "O tamanho do nome deve ser entre {min} e {max} caracteres")
    private String nome;
    @NotNull
    @Length(min = 2, max = 300, message = "O tamanho do endereco deve ser entre {min} e {max} caracteres")
    private String endereco;
    @OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Long id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public void novoPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}
