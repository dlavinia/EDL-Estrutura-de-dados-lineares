public class FilaComDuasPilhas implements IFila {
    private Pilha p1;
	private Pilha p2;
	
	public FilaComDuasPilhas() {
		this.p1 = new Pilha();
		this.p2 = new Pilha();
	}

	@Override
	public void enqueue(Object o) throws FilaVaziaEx, PilhaVaziaEx {
		int tamanho = size();
		for(int i = 0; i < tamanho; i++) {
			p2.push(p1.pop());
		}
		p2.push(o);
		tamanho = p2.size();
		for(int i = 0; i < tamanho; i++) {
			p1.push(p2.pop());
		}
	}

	@Override
	public Object dequeue() throws FilaVaziaEx, PilhaVaziaEx {
		if(isEmpty()) {
			throw new FilaVaziaEx("A fila está vazia.");
		}
		return p1.pop();
	}
	
	@Override
	public Object first() throws FilaVaziaEx, PilhaVaziaEx {
		if(p1.isEmpty() && p2.isEmpty()) {
			throw new FilaVaziaEx("A fila está vazia.");
		}
		if (p2.isEmpty()) {
            while (!p1.isEmpty()) {
                p2.push(p1.pop());
            }
			while (!p2.isEmpty()) {
                p1.push(p2.pop());

            }
        }

        return p1.top();
    }

	@Override
	public int size() {
		return p1.size();
	}

	@Override
	public boolean isEmpty() {
		return p1.isEmpty();
	}
}
