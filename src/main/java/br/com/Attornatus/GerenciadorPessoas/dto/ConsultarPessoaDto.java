package br.com.Attornatus.GerenciadorPessoas.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.Attornatus.GerenciadorPessoas.model.Endereco;
import br.com.Attornatus.GerenciadorPessoas.model.Pessoa;

public class ConsultarPessoaDto {
	
	private String nome;
	private LocalDate dataNascimento;
	private String logadouro;
	private Integer cep;
	private Integer numero;
	private String cidade;
	private boolean principal;
	
	
	public ConsultarPessoaDto(Pessoa p) {
		this.nome = p.getNome();
		this.dataNascimento = p.getDataNascimento();
		List<Endereco> e= p.getEnderecos();
		for (Endereco endereco : e) {
			this.logadouro = endereco.getLogadouro();
			this.cep = endereco.getCep();
			this.numero = endereco.getNumero();
			this.cidade = endereco.getCidade();
			this.principal = endereco.getPrincipal();
		}
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getLogadouro() {
		return logadouro;
	}
	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public boolean isPrincipal() {
		return principal;
	}
	public void setPrincipal(boolean principal) {
		this.principal = principal;
	}

	

}
