package com.gerenciador.gerenciadorDeTarefas.entities.dto;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	private String email;
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
