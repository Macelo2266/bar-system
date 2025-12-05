package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.controller;

import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Venda;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*")
public class VendaController {
    @Autowired
    private VendaRepository vendaRepository;

    // Retorna a lista de vendas de hoje
    @GetMapping("/relatorio-dia")
    public List<Venda> relatorioDia(@RequestParam Long usuarioId) {
        LocalDateTime inicioDia = LocalDate.now().atStartOfDay();
        LocalDateTime fimDia = LocalDate.now().atTime(LocalTime.MAX);

        return vendaRepository.findByUsuarioIdAndDataVendaBetween(usuarioId, inicioDia, fimDia);
    }

    // Retorna apenas o valor total vendido hoje (Soma)
    @GetMapping("/faturamento")
    public Double faturamentoDia(@RequestParam Long usuarioId) {
        List<Venda> vendasHoje = relatorioDia(usuarioId);

        return vendasHoje.stream()
                .mapToDouble(Venda::getValorTotal)
                .sum();
    }
}
