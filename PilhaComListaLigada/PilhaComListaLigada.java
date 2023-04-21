package PilhaComListaLigada;
import ListaLigada.ListaLigada;

public class PilhaComListaLigada {
    private ListaLigada ll;
	
	public PilhaComListaLigada(){
		this.ll = new ListaLigada();
	}
	
	public int size() {
		return this.ll.tamanho();
	}
	
	public boolean isEmpty() {
		return this.ll.tamanho() == 0;
	}
	
	public void push(Object o) {
		this.ll.addFim(o);
	}
	
	public Object pop() throws PilhaVaziaEx {
		if (this.isEmpty()) throw new PilhaVaziaEx("A pilha está vazia");
		Object o = this.ll.ultimo();
		this.ll.removerFim();
		return o;
	}
	
	public Object top() throws PilhaVaziaEx {
		if (this.isEmpty()) throw new PilhaVaziaEx("A pilha está vazia");
		return this.ll.ultimo();
	}
}
