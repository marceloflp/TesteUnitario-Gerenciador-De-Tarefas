package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Projeto;
import com.gerenciador.gerenciadorDeTarefas.repositories.ProjetoRepository;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.DatabaseException;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repositorio;
	
	public List<Projeto> listarProjetos() {
		return repositorio.findAll();	
	}
	
	public Projeto buscarPorId(Long id) {
		Optional<Projeto> proj = repositorio.findById(id);
		return proj.orElseThrow(() -> new ResourceNotFoundException("Erro ao buscar projeto."));
	}
	
	public Projeto salvarProjeto(Projeto obj) {
		return repositorio.save(obj);
	}
	
	public void deletarProjeto(Long id) {
		try {
			if(!repositorio.existsById(id)) throw new ResourceNotFoundException("Erro ao deletar projeto.");
			
			repositorio.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}	
	}
	
	public Projeto atualizarProjeto(Long id, Projeto obj) {
		try {
			Projeto proj = repositorio.getReferenceById(id);
			updateProjeto(proj, obj);
			
			return repositorio.save(obj);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateProjeto(Projeto proj, Projeto obj) {
		proj.setDescricao(obj.getDescricao());
		proj.setDataInicio(obj.getDataInicio());
		proj.setDataFim(obj.getDataFim());
		proj.setStatus(obj.getStatus());
	}
}
