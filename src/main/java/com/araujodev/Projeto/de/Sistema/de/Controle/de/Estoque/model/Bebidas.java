package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bebidas")
public class Bebidas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String categoria;
    private Double preco;
    private Integer quantidade;

    @Column(length = 500)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
