package FilaComListaLigada;

public interface IFila {
	    public abstract void enqueue(Object o) throws FilaVaziaEx;
	    public abstract Object dequeue() throws FilaVaziaEx;
	    public Object first() throws FilaVaziaEx;
	    public abstract int size();
	    public abstract boolean isEmpty();
}
