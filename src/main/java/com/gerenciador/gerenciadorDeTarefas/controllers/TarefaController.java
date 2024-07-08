package com.gerenciador.gerenciadorDeTarefas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gerenciador.gerenciadorDeTarefas.entities.Tarefa;
import com.gerenciador.gerenciadorDeTarefas.services.TarefaService;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService service;
	
	@GetMapping()
	public ResponseEntity<List<Tarefa>> listarTarefas(){
		List<Tarefa> tarefas = service.listarTarefas();
		
		return ResponseEntity.ok().body(tarefas);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Tarefa> tarefaId(@PathVariable Long id){
		Tarefa obj = service.buscarPorId(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping()
	public ResponseEntity<Tarefa> inserirTarefa(@RequestBody Tarefa obj){
		obj = service.salvarTarefa(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) {
		service.deletarTarefa(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa proj) {
		Tarefa tarefa = service.atualizarTarefa(id, proj);
		
		return ResponseEntity.ok().body(tarefa);
	}
}
