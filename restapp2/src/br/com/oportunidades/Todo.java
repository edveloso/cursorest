package br.com.oportunidades;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.internal.NotNull;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Produces(MediaType.APPLICATION_JSON)
public class Todo {

	@NotNull
	private String nome;
	private int idade;

	
	public Todo() {
	}

	public Todo(String nome) {
		this.nome = nome;
	}

	public Todo(String nome, int idade) {
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
