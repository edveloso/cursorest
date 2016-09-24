package br.com.oportunidades;

public class TodoNotFoundException extends RuntimeException {

	public TodoNotFoundException() {
		super("Todo nao encontrado");
	}
	
}
