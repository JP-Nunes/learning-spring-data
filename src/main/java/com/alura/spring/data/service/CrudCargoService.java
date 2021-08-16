package com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.alura.spring.data.orm.Cargo;
import com.alura.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {

	private final CargoRepository repository;
	private Boolean system = true;
	
	public CrudCargoService(CargoRepository repository) {
		this.repository = repository;
	}
	
	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Listar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
				case 1:
					salvar(scanner);
					break;
				case 2:
					atualizar(scanner);
					break;
				case 3:
					listar();
					break;
				case 4:
					deletar(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		
		repository.save(cargo);
		System.out.println("Salvo com sucesso");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id do cargo");
		int id = scanner.nextInt();
		
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		
		repository.save(cargo);
		System.out.println("Atualizado com sucesso");
	}
	
	private void listar() {
		Iterable<Cargo> cargos = repository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id do cargo");
		int id = scanner.nextInt();
		repository.deleteById(id);
		System.out.println("Deletado com sucesso");
	}
}
