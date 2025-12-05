package com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.repository;

import com.araujodev.Projeto.de.Sistema.de.Controle.de.Estoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
}
