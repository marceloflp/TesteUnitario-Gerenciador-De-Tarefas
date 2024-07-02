package com.gerenciador.gerenciadorDeTarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.gerenciadorDeTarefas.entities.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
