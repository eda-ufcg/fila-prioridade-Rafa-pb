import java.util.ArrayList;

import javax.swing.text.html.ParagraphView;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair add = new Pair(elemento, prioridade);
		this.fila.add(add);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if(fila.isEmpty()) throw new RuntimeException("empty");
		Pair aux = fila.get(0);
		int indice = 0;
		for(int i = 0; i < fila.size(); i++){
			if(fila.get(i).getPrioridade() > aux.getPrioridade()){
				aux = fila.get(i);
				indice = i;
			}
		}
		fila.remove(indice);
		return aux.getElemento();
	}

}
