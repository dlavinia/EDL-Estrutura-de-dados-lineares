package FilaComListaLigada;
import ListaLigada.ListaLigada;

public class FilaComListaLigada implements IFila{

    ListaLigada ll;
	
	public FilaComListaLigada() {
		this.ll = new ListaLigada();
	}
	
	public void enqueue(Object o) {
		ll.addFim(o);
	}
	
	public Object dequeue() throws FilaVaziaEx {
		if (this.isEmpty()) throw new FilaVaziaEx("Fila vazia");
		Object o = this.ll.get(0);
		this.ll.removeInicio();
		return o;
	}

	public Object first() throws FilaVaziaEx{
		if (this.isEmpty()) throw new FilaVaziaEx("Fila vazia");
		return this.ll.get(0);
	}

	public int size() {
		return this.ll.tamanho();
	}

	public boolean isEmpty() {
		return this.ll.tamanho() == 0;
	}
}
