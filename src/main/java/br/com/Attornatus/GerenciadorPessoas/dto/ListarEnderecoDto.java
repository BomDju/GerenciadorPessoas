package br.com.Attornatus.GerenciadorPessoas.dto;

import br.com.Attornatus.GerenciadorPessoas.model.Endereco;

public class ListarEnderecoDto {

	private String nomeDaPessoa;
	private String logadouro;
	private Integer cep;
	private Integer numero;
	private String cidade;

	public ListarEnderecoDto(Endereco e) {
		this.nomeDaPessoa = e.getPessoa().getNome();
		this.logadouro = e.getLogadouro();
		this.cep = e.getCep();
		this.numero = e.getNumero();
		this.cidade = e.getCidade();
	}

	public String getNomeDaPessoa() {
		return nomeDaPessoa;
	}

	public void setNomeDaPessoa(String nomeDaPessoa) {
		this.nomeDaPessoa = nomeDaPessoa;
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

}
