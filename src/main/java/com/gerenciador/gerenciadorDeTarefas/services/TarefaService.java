package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Tarefa;
import com.gerenciador.gerenciadorDeTarefas.repositories.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repositorio;
	
	public List<Tarefa> listarTarefas() {
		return repositorio.findAll();	
	}
	
	public Tarefa buscarPorId(Long id) {
		Optional<Tarefa> proj = repositorio.findById(id);
		return proj.get();
	}
	
	public Tarefa salvarTarefa(Tarefa obj) {
		return repositorio.save(obj);
	}
	
	public void deletarTarefa(Long id) {
		repositorio.deleteById(id);
		
	}
	
	public Tarefa atualizarTarefa(Long id, Tarefa obj) {
		Tarefa tarefa = repositorio.getReferenceById(id);
		updateTarefa(tarefa, obj);
		
		return repositorio.save(obj);
	}

	private void updateTarefa(Tarefa tarefa, Tarefa obj) {
		tarefa.setTitulo(obj.getTitulo());
		tarefa.setResponsavel(obj.getResponsavel());
		tarefa.setProjeto(obj.getProjeto());
		tarefa.setDataCriacao(obj.getDataCriacao());
		tarefa.setDataConclusao(obj.getDataConclusao());
		tarefa.setStatus(obj.getStatus());
	}
}
