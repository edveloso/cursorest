package restapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TodoDAO {

	private static Map<Integer, Todo> repositorio = new HashMap<Integer, Todo>();
	
	public TodoDAO() {
		Todo todo = new Todo();
		todo.setDescricao("Estudar django");
		todo.setPrioridade(-100);
		todo.setId(1);
		repositorio.put(1, todo);
	}
	
	public void salvar(Todo todo){
		int key = repositorio.size()+1;
		todo.setId(key);
		repositorio.put(key, todo);
	}
	
	public void alterar(int id, Todo todo){
		repositorio.put(id, todo);
	}
	
	public void remover(int id){
		repositorio.remove(id);
	}
	
	public List<Todo> listar(){
		List<Todo> lista = new ArrayList<Todo>();
		for(Integer k : repositorio.keySet()){
			lista.add(repositorio.get(k));
		}
		return lista;
	}
	
	public Todo get(int id){
		return repositorio.get(id);
	}
	
	
}
