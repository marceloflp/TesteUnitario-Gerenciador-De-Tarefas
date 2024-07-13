package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;
import com.gerenciador.gerenciadorDeTarefas.repositories.UsuarioRepository;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.DatabaseException;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();	
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new ResourceNotFoundException("Erro ao buscar usuário."));
	}
	
	public Usuario salvarUsuario(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletarUsuario(Long id) {
		try {
			if(!repositorio.existsById(id)) throw new ResourceNotFoundException("Erro ao deletar usuário.");
			repositorio.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e.getMessage());
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario atualizarUsuario(Long id, Usuario obj) {
		try {
			Usuario user = repositorio.getReferenceById(id);
			updateUsuario(user, obj);
			
			return repositorio.save(obj);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(e.getMessage());
		}
	}

	private void updateUsuario(Usuario user, Usuario obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setSenha(obj.getSenha());
	}
}
