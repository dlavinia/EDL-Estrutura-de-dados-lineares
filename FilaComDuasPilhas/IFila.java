
public interface IFila {
	    public abstract void enqueue(Object o) throws FilaVaziaEx, PilhaVaziaEx;
	    public abstract Object dequeue() throws FilaVaziaEx, PilhaVaziaEx;
	    public Object first() throws FilaVaziaEx, PilhaVaziaEx;
	    public abstract int size();
	    public abstract boolean isEmpty();
}
