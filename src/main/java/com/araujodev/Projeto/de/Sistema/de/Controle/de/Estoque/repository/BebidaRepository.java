package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository;

import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Bebidas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BebidaRepository extends JpaRepository<Bebidas,Long> {
    List<Bebidas> findByUsuarioId(Long usuarioId);
}

