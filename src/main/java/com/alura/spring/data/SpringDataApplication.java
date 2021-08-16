package com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.spring.data.service.CrudCargoService;
import com.alura.spring.data.service.CrudFuncionarioService;
import com.alura.spring.data.service.CrudUnidadeDeTrabalhoService;
import com.alura.spring.data.service.RelatorioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService;
	private final RelatorioService relatorioService;
	private boolean system = true;
	
	public SpringDataApplication(
			CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService,
			CrudUnidadeDeTrabalhoService unidadeDeTrabalhoService,
			RelatorioService relatorioService
	) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
		this.relatorioService = relatorioService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual acao voce deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidade de trabalho");
			System.out.println("4 - Relatorio");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;
			case 2:
				funcionarioService.inicial(scanner);
				break;
			case 3:
				unidadeDeTrabalhoService.inicial(scanner);
				break;
			case 4:
				relatorioService.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

}
