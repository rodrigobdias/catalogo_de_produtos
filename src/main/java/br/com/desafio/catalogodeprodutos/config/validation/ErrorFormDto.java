package br.com.desafio.catalogodeprodutos.config.validation;

public class ErrorFormDto {

	private String status_code;
	private String message;
	
	public ErrorFormDto(String status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}

	public String getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}
	
	
}
