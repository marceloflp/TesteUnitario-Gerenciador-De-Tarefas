package com.gerenciador.gerenciadorDeTarefas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;
import com.gerenciador.gerenciadorDeTarefas.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public List<Usuario> listarUsuarios() {
		return repositorio.findAll();	
	}
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.get();
	}
	
	public Usuario salvarUsuario(Usuario obj) {
		return repositorio.save(obj);
	}
	
	public void deletarUsuario(Long id) {
		repositorio.deleteById(id);
		
	}
	
	public Usuario atualizarUsuario(Long id, Usuario obj) {
		Usuario user = repositorio.getReferenceById(id);
		updateUsuario(user, obj);
		
		return repositorio.save(obj);
	}

	private void updateUsuario(Usuario user, Usuario obj) {
		user.setNome(obj.getNome());
		user.setEmail(obj.getEmail());
		user.setSenha(obj.getSenha());
	}
}
