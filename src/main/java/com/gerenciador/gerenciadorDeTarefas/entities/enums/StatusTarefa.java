package com.gerenciador.gerenciadorDeTarefas.entities.enums;

public enum StatusTarefa {

	NAO_INICIADO(1), 
	EM_ANDAMENTO(2), 
	CONCLUIDO(3), 
	ATRASADO(4);

	private int code;

	private StatusTarefa(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static StatusTarefa valueOf(int code) {
		for (StatusTarefa value : StatusTarefa.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid StatusTarefa code");
	}
}
