package com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.alura.spring.data.orm.Funcionario;
import com.alura.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends 
		PagingAndSortingRepository<Funcionario, Integer>, 
		JpaSpecificationExecutor<Funcionario>
	{

	List<Funcionario> findByNome(String nome);
	
	@Query(
			"SELECT f FROM Funcionario f "
			+ "WHERE f.nome = :nome "
			+ "AND f.salario > :salario "
			+ "AND f.dataContratacao = :data"
	)
	List<Funcionario> findByNomeSalarioMaiorDataDeContratacao(String nome, Double salario, LocalDate data);

	@Query(
			value = "SELECT f.id, f.nome, f.salario FROM funcionarios f",
			nativeQuery = true
	)
	List<FuncionarioProjecao> findFuncionariosComMaioresSalarios();
}
