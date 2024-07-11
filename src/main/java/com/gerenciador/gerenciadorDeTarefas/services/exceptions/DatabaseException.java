package com.gerenciador.gerenciadorDeTarefas.services.exceptions;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DatabaseException() {
		super("Erro ao acessar banco de dados.");
	}

	public DatabaseException(String msg) {
		super(msg);
	}
}
