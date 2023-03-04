package br.com.Attornatus.GerenciadorPessoas.controller.exception;

public class ValidationError {
	
	private String campo;
	private String error;

	public ValidationError(String campo, String error) {
		this.campo = campo;
		this.error = error;
	}

	public String getCampo() {
		return campo;
	}

	public String getError() {
		return error;
	}
	
	

}
