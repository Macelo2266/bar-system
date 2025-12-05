package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "bebida_id")
    private Bebidas bebida;

    private Integer quantidadeVendida;
    private Double valorUnitario;
    private Double valorTotal;

    private LocalDateTime dataVenda;

    @PrePersist
    public void prePersist() {
        this.dataVenda = LocalDateTime.now();
    };
}
