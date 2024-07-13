package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Tarefa;
import com.gerenciador.gerenciadorDeTarefas.repositories.TarefaRepository;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.DatabaseException;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repositorio;

	public List<Tarefa> listarTarefas() {
		return repositorio.findAll();
	}

	public Tarefa buscarPorId(Long id) {
		Optional<Tarefa> proj = repositorio.findById(id);
		return proj.orElseThrow(() -> new ResourceNotFoundException("Erro ao buscar tarefa."));
	}

	public Tarefa salvarTarefa(Tarefa obj) {
		return repositorio.save(obj);
	}

	public void deletarTarefa(Long id) {
		try {
			if(! repositorio.existsById(id)) throw new ResourceNotFoundException("Erro ao deletar tarefa.");
			repositorio.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public Tarefa atualizarTarefa(Long id, Tarefa obj) {
		try {
			Tarefa tarefa = repositorio.getReferenceById(id);
			updateTarefa(tarefa, obj);

			return repositorio.save(obj);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
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
