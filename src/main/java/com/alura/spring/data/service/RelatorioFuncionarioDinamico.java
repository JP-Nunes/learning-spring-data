package com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;

import com.alura.spring.data.orm.Funcionario;
import com.alura.spring.data.repository.FuncionarioRepository;
import com.alura.spring.data.specification.SpecificationFuncionario;

public class RelatorioFuncionarioDinamico {

	private final FuncionarioRepository repository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		List<Funcionario> funcionarios = 
				repository.findAll(
						Specification.where(
								SpecificationFuncionario.nome(nome)));
		
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
}
