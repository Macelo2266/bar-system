package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true) // Não permite emails repetidos
    private String email;

    private String senha;
}
