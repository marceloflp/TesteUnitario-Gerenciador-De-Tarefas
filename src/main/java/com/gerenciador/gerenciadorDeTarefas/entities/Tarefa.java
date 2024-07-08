package com.gerenciador.gerenciadorDeTarefas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.gerenciador.gerenciadorDeTarefas.entities.enums.StatusTarefa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tarefa")
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataConclusao;
	private StatusTarefa status;

	@ManyToOne()
	@JoinColumn(name = "responsavel_id", nullable = false)
	private Usuario responsavel;
	
	private Projeto projeto;
	
	public Tarefa() {
		
	}

	public Tarefa(Long id, String titulo, LocalDateTime dataCriacao, LocalDateTime dataConclusao, StatusTarefa status,
			Usuario responsavel, Projeto projeto) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataCriacao = dataCriacao;
		this.dataConclusao = dataConclusao;
		this.status = status;
		this.responsavel = responsavel;
		this.projeto = projeto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(LocalDateTime dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}

	public Usuario getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
