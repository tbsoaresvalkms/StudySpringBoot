package com.tbsoares.study.springboot.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = true)
    private Cliente cliente;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Item> items;
    private LocalDate data;
    @Min(1)
    private Double valorTotal;

    public Pedido(Long id, Cliente cliente, List<Item> items, Double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.valorTotal = valorTotal;
        this.data = LocalDate.now();
    }
}
