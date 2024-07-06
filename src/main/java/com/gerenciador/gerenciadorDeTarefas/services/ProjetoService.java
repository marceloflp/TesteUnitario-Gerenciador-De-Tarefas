package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Projeto;
import com.gerenciador.gerenciadorDeTarefas.repositories.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository repositorio;
	
	public List<Projeto> listarProjetos() {
		return repositorio.findAll();	
	}
	
	public Projeto buscarPorId(Long id) {
		Optional<Projeto> proj = repositorio.findById(id);
		return proj.get();
	}
	
	public Projeto salvarProjeto(Projeto obj) {
		return repositorio.save(obj);
	}
	
	public void deletarProjeto(Long id) {
		repositorio.deleteById(id);
		
	}
	
	public Projeto atualizarProjeto(Long id, Projeto obj) {
		Projeto proj = repositorio.getReferenceById(id);
		updateProjeto(proj, obj);
		
		return repositorio.save(obj);
	}

	private void updateProjeto(Projeto proj, Projeto obj) {
		proj.setDescricao(obj.getDescricao());
		proj.setDataInicio(obj.getDataInicio());
		proj.setDataFim(obj.getDataFim());
		proj.setStatus(obj.getStatus());
	}
}
