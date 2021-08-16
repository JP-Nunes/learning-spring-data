package com.alura.spring.data.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cpf;
	private Double salario;
	private LocalDate dataContratacao;
	
	@ManyToOne
	@JoinColumn(name = "cargo_id", nullable = false)
	private Cargo cargo;
	
	@Fetch(FetchMode.SELECT)
	@ManyToMany
	@JoinTable(
		name = "funcionarios_unidades", 
		joinColumns = {
			@JoinColumn(name = "fk_funcionario")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "fk_unidades")
		}
	)
	private List<UnidadeDeTrabalho> unidadesDeTrabalho;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public List<UnidadeDeTrabalho> getUnidadesDeTrabalho() {
		return unidadesDeTrabalho;
	}

	public void setUnidadesDeTrabalho(List<UnidadeDeTrabalho> unidadesDeTrabalho) {
		this.unidadesDeTrabalho = unidadesDeTrabalho;
	}

	@Override
	public String toString() {
		return 
			"Funcionario [id=" + id + ", nome=" + nome 
			+ ", cpf=" + cpf + ", salario=" + salario 
			+ ", dataContratacao=" + dataContratacao + ", cargo=" + cargo;
	}
	
}
