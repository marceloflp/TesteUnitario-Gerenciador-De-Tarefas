package com.gerenciador.gerenciadorDeTarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciador.gerenciadorDeTarefas.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
