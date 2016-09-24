package restapp;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Produces(MediaType.APPLICATION_JSON)
public class Todo {

	
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String descricao;
	private int prioridade;

	public String getDescricao() {
		return descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

}
