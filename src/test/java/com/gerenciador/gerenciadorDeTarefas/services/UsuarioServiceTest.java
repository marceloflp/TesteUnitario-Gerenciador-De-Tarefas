package com.gerenciador.gerenciadorDeTarefas.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;
import com.gerenciador.gerenciadorDeTarefas.entities.dto.UsuarioDTO;
import com.gerenciador.gerenciadorDeTarefas.repositories.UsuarioRepository;

class UsuarioServiceTest {
	
	private static final long id = 1L;
	private static final String nome = "Mark";
	private static final  String email = "mark@email.com";
	private static final String senha = "12345";

	@InjectMocks
	private UsuarioService service;
	
	@Mock
	private UsuarioRepository repository;
	
	private Usuario usuario;
	
	private UsuarioDTO usuarioDTO;
	
	private Optional<Usuario> optionalUsuario;
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		startUsuario();
	}

	@Test
	void testListarUsuarios() {
		fail("Not yet implemented");
	}

	//TESTANDO findById(buscarPorId)
	@Test
	void whenBuscarPorIdThenReturnAnUsuarioInstace() {
		/* 
		 * Configura o comportamento esperado do mock: 
		 * quando qualquer chamada a repository.findById for feita com qualquer valor long,
		 * então retorne o valor de optionalUsuario.
	    */
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(optionalUsuario);
		
		// Chama o método buscarPorId do serviço passando o ID.
		UsuarioDTO response = service.buscarPorId(id);
		
		Assertions.assertNotNull(response); // Verifica se o resultado não é nulo.
		Assertions.assertEquals(UsuarioDTO.class, response.getClass()); // Verifica se o tipo do objeto retornado é UsuarioDTO.
		Assertions.assertEquals(id, response.getId()); // Verifica se o ID do objeto retornado é igual ao ID esperado.
		Assertions.assertEquals(nome, response.getNome()); // Verifica se o nome do objeto retornado é igual ao nome esperado.
		Assertions.assertEquals(email, response.getEmail()); // Verifica se o e-mail do objeto retornado é igual ao e-mail esperado.
	}

	@Test
	void testSalvarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletarUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testAtualizarUsuario() {
		fail("Not yet implemented");
	}
	
	private void startUsuario() {
		usuario = new Usuario(id, nome, email, senha);
		usuarioDTO = new UsuarioDTO(id, nome, email);
		optionalUsuario = Optional.of(new Usuario(id, nome, email, senha));
	}

}
