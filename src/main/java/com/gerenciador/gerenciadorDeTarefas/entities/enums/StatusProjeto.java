package com.gerenciador.gerenciadorDeTarefas.entities.enums;

public enum StatusProjeto {
	NAO_INICIADO(1), 
	EM_ANDAMENTO(2), 
	CONCLUIDO(3), 
	ATRASADO(4);

	private int code;

	private StatusProjeto(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StatusProjeto valueOf(int code) {
		for (StatusProjeto value : StatusProjeto.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusProjeto code");
	}
}
