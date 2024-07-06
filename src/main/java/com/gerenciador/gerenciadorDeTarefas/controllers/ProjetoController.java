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

import com.gerenciador.gerenciadorDeTarefas.entities.Projeto;
import com.gerenciador.gerenciadorDeTarefas.services.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoService service;
	
	@GetMapping()
	public ResponseEntity<List<Projeto>> listarProjetos(){
		List<Projeto> usuarios = service.listarProjetos();
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Projeto> projetoId(@PathVariable Long id){
		Projeto obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Projeto> inserirProjeto(@RequestBody Projeto obj){
		obj = service.salvarProjeto(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
