package br.com.Attornatus.GerenciadorPessoas.dto;

import java.time.LocalDate;

import br.com.Attornatus.GerenciadorPessoas.model.Pessoa;

public class ListarPessoaDto {
	
	private Integer id;
	private String nome;
	private LocalDate dataNascimento;

	public ListarPessoaDto(Pessoa p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.dataNascimento = p.getDataNascimento();
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Integer getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	
	
	
}
