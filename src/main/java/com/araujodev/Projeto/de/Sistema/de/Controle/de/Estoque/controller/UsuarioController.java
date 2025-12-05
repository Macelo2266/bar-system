package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.controller;

import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Usuario;
import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario login) {
        Usuario usuario = repository.findByEmailAndSenha(login.getEmail(), login.getSenha());
        if (usuario != null) {
            return usuario;
        }
        throw new RuntimeException("Login inválido");
    }
}
