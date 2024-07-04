package com.gerenciador.gerenciadorDeTarefas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;
import com.gerenciador.gerenciadorDeTarefas.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping()
	public ResponseEntity<List<Usuario>> listarUsuarios(){
		List<Usuario> usuarios = service.listarUsuarios();
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> usuarioId(@PathVariable Long id){
		Usuario obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Usuario> inserirUsuario(@RequestBody Usuario obj){
		obj = service.salvarUsuario(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
