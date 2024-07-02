package com.gerenciador.gerenciadorDeTarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
