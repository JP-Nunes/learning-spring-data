package com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alura.spring.data.orm.Funcionario;
import com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	
	private Boolean system = true;
	private final DateTimeFormatter formatter = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Buscar funcionario por nome");
			System.out.println("2 - Buscar funcionario por nome, salario e data");
			
			int action = scanner.nextInt();
			
			switch (action) {
				case 1:
					buscarFuncionarioPorNome(scanner);
					break;
				case 2:
					buscarFuncionarioPorNomeESalarioMaiorEData(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
	
	private void buscarFuncionarioPorNome(Scanner scanner) {
		System.out.println("Qual o nome que deseja pesquisar?");
		String nome = scanner.next();
		List<Funcionario> funcionarios = 
				funcionarioRepository.findByNome(nome);
		funcionarios.forEach(System.out::println);
	}
	
	private void buscarFuncionarioPorNomeESalarioMaiorEData(Scanner scanner) {
		System.out.println("Qual o nome que deseja pesquisar?");
		String nome = scanner.next();
		
		System.out.println("O salario deve ser maior que qual valor?");
		Double salario = scanner.nextDouble();
		
		System.out.println("Qual a data de contratacao?");
		String data = scanner.next();		
		LocalDate dataFormatada = LocalDate.parse(data, formatter);
		
		List<Funcionario> funcionarios = funcionarioRepository
				.findByNomeSalarioMaiorDataDeContratacao(nome, salario, dataFormatada);
		funcionarios.forEach(System.out::println);
	}
}
