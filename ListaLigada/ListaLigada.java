package ListaLigada;

public class ListaLigada {
    No inicio;
	No fim;
	int tamanho;
	
	public ListaLigada(){
		this.inicio = null;
		this.fim = null;
		this.tamanho = 0;
	}
		
	public void addFim(Object o) {
		No item = new No(o);
		
		if (this.inicio == null) {
			this.inicio = item;
			this.fim = item;
		} else {
			this.fim.setProximo(item);
			this.fim = item;
		}
		
		this.tamanho++;
	}
	
	public void removeInicio() {
		if (this.tamanho < 1)
			throw new RuntimeException("Lista vazia");
		
		this.inicio = inicio.getProximo();
		this.tamanho--;
	}
	
	public Object removerFim() {
		if (tamanho == 0)
			throw new RuntimeException("Lista ligada vazia");
		
		No fim = this.fim;		
		if (tamanho == 1) {
			this.inicio = null;
			this.fim = null;
			this.tamanho--;
			return fim.getElemento();
		}
		
		No No = this.inicio;
		for (int i = 1; i < this.tamanho-1; i++) {
            No = No.getProximo();
        }
            
		No.setProximo(null);;

		this.fim = No;
		this.tamanho--;

		return fim.getElemento();
	}

    public Object get(int index) throws RuntimeException {
		if (index < 0 || index >= tamanho)
			throw new RuntimeException("Index inválido");
		
		No No = this.inicio;
		for (int i = 0; i < index; i++) {
			if (i == index) break;
			No = No.getProximo();
		}	
		return No.getElemento();	
	}
	
    public int size() {
		return this.tamanho;
	}
	public Object ultimo() {
		return this.fim.getElemento();
	}
	
}

