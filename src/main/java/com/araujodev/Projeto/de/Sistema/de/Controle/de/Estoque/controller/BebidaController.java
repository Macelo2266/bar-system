package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.controller;


import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Bebidas;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Usuario;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Venda;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository.BebidaRepository;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository.UsuarioRepository;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bebidas")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET,
        RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})

public class BebidaController {

    @Autowired
    private BebidaRepository bebidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping
    public List<Bebidas> listar(@RequestParam Long usuarioId) {
        return bebidaRepository.findByUsuarioId(usuarioId);
    }

    // Salvar bebida vinculada ao usuário
    @PostMapping
    public Bebidas criar(@RequestBody Bebidas bebida, @RequestParam Long usuarioId) {
        Usuario dono = usuarioRepository.findById(usuarioId).orElseThrow();
        bebida.setUsuario(dono);
        return bebidaRepository.save(bebida);
    }

    // Deletar
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        bebidaRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Bebidas atualizar(@PathVariable Long id,
                             @RequestParam Long usuarioId,
                             @RequestBody Bebidas atualizada) {

        Bebidas bebida = bebidaRepository.findById(id).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();

        bebida.setUsuario(usuario);
        bebida.setNome(atualizada.getNome());
        bebida.setCategoria(atualizada.getCategoria());
        bebida.setPreco(atualizada.getPreco());
        bebida.setQuantidade(atualizada.getQuantidade());
        bebida.setImagem(atualizada.getImagem());

        return bebidaRepository.save(bebida);
    }

    // Atualizar Estoque
    @PatchMapping("/{id}/estoque")
    public Bebidas atualizarEstoque(@PathVariable Long id, @RequestParam int quantidade) {
        Bebidas bebida = bebidaRepository.findById(id).orElseThrow();
        bebida.setQuantidade(bebida.getQuantidade() + quantidade);
        return bebidaRepository.save(bebida);
    }

    @PatchMapping("/{id}/vender")
    public Bebidas vender(
            @PathVariable Long id,
            @RequestParam int quantidadeVendida,
            @RequestParam Long usuarioId
    ) {
        Bebidas bebida = bebidaRepository.findById(id).orElseThrow();
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow();

        if (bebida.getQuantidade() < quantidadeVendida) {
            throw new RuntimeException("Estoque insuficiente!");
        }

        bebida.setQuantidade(bebida.getQuantidade() - quantidadeVendida);

        // Criar registro de venda
        Venda venda = new Venda();
        venda.setQuantidadeVendida(quantidadeVendida);
        venda.setValorUnitario(bebida.getPreco());
        venda.setValorTotal(bebida.getPreco() * quantidadeVendida);
        venda.setDataVenda(LocalDateTime.now());
        venda.setBebida(bebida);
        venda.setUsuario(usuario);

        vendaRepository.save(venda);

        return bebidaRepository.save(bebida);
    }


}
