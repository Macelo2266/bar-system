package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository;

import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {
    List<Venda> findByUsuarioIdAndDataVendaBetween(Long usuarioId, LocalDateTime dataVendaAfter, LocalDateTime dataVendaAfter1);

    List<Venda> findByUsuarioId(Long usuarioId);
}
