package br.com.Attornatus.GerenciadorPessoas.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class CriarEnderecoForm {

	@NotBlank
	private String logadouro;
	
	@Min (value = 8)
	private Integer cep;
	
	@Min (value = 1)	
	private Integer numero;
	
	@NotBlank
	private String cidade;
	private boolean principal;

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
