package com.gerenciador.gerenciadorDeTarefas.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gerenciador.gerenciadorDeTarefas.entities.enums.StatusProjeto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_projeto")
public class Projeto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descricao;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime dataInicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private LocalDateTime dataFim;
	
	private StatusProjeto status;
	
	@ManyToOne()
	@JoinColumn(name = "usuario_id", nullable= false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "projeto")
	private List<Tarefa> tarefa = new ArrayList<>();
	
	public Projeto() {
		
	}
	
	public Projeto(Long id,Usuario usuario , String descricao, LocalDateTime dataInicio, LocalDateTime dataFim, StatusProjeto status) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public StatusProjeto getStatus() {
		return status;
	}

	public void setStatus(StatusProjeto status) {
		this.status = status;
	}

	public List<Tarefa> getTarefa() {
		return tarefa;
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
		Projeto other = (Projeto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
