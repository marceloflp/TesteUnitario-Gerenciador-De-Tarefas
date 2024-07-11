package com.gerenciador.gerenciadorDeTarefas.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gerenciador.gerenciadorDeTarefas.services.exceptions.DatabaseException;
import com.gerenciador.gerenciadorDeTarefas.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
	
		StandardError erro = new StandardError(
				Instant.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Recurso não encontrado.", 
				e.getMessage(), 
				request.getRequestURI());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		StandardError erro = new StandardError(
				Instant.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Erro ao consultar banco de dados.", 
				e.getMessage(), 
				request.getRequestURI());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
