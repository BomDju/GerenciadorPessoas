package br.com.Attornatus.GerenciadorPessoas.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public class CriarPessoaForm {

	@NotBlank
	private String nome;
	
	@Past
	private LocalDate dataNascimento;
	
	@NotBlank
	private String logadouro;
	
	@Min (value = 8)
	private Integer cep;
	
	@Min (value = 1)
	private Integer numero;
	
	@NotBlank
	private String cidade;
	
	private boolean principal;


	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getLogadouro() {
		return logadouro;
	}

	public Integer getCep() {
		return cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCidade() {
		return cidade;
	}

	public boolean isPrincipal() {
		return principal;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

}
