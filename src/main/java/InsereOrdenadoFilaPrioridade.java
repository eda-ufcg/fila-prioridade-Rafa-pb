public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if(last == -1){
			head = 0;
		}
		Pair add = new Pair(elemento, prioridade);
		for(int i = head; i < last; i++){
			if(fila[i].getPrioridade() < prioridade){
				shiftRight(i);
				fila[i] = add;
				last++;
				break;
			}
		}
	}
	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {	
		String retorno = fila[head].getElemento();
		head++;
		return retorno;
	}


    private void shiftRight(int index) {
        for (int i = this.last; i > index; i--) {
            this.fila[i] = this.fila[i-1];
        }
    }
}
