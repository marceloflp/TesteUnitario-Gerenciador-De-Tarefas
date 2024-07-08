package com.gerenciador.gerenciadorDeTarefas.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gerenciador.gerenciadorDeTarefas.entities.Projeto;
import com.gerenciador.gerenciadorDeTarefas.entities.Tarefa;
import com.gerenciador.gerenciadorDeTarefas.entities.Usuario;
import com.gerenciador.gerenciadorDeTarefas.entities.enums.StatusProjeto;
import com.gerenciador.gerenciadorDeTarefas.entities.enums.StatusTarefa;
import com.gerenciador.gerenciadorDeTarefas.repositories.ProjetoRepository;
import com.gerenciador.gerenciadorDeTarefas.repositories.TarefaRepository;
import com.gerenciador.gerenciadorDeTarefas.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UsuarioRepository userRepo;
	
	@Autowired
	private ProjetoRepository projRepo;
	
	@Autowired
	private TarefaRepository tareRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario user1 = new Usuario(null, "Roberto Alves",
				"emailRob@email.com", "12345");
		
		userRepo.save(user1);
		
		Projeto proj = new Projeto(null, 
				"Desenvolvimento de um sistema web para gestão de tarefas",
				Instant.parse("2024-06-01T00:00:00Z"),
				Instant.parse("2024-12-31T23:59:59Z"),
				StatusProjeto.EM_ANDAMENTO);
		
		projRepo.save(proj);
		
		Tarefa tarefa = new Tarefa(null, "Implementar autenticação OAuth2",
				Instant.parse("2024-07-07T10:00:00Z"),
				Instant.parse("2024-07-10T15:00:00Z"),
				StatusTarefa.EM_ANDAMENTO,
				user1,
				proj);
		
		tareRepo.save(tarefa);
	}
}
