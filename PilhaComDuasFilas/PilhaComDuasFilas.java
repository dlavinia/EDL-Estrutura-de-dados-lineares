package PilhaComDuasFilas;

public class PilhaComDuasFilas {
    private Fila f1;
    private Fila f2;

    public PilhaComDuasFilas(){
            this.f1 = new Fila(10);
            this.f2 = new Fila(10);
	}

    public int size() {
        return this.f1.size();
    }

    public boolean isEmpty() {
        return this.f1.isEmpty();
    }

    public void push(Object e) {
        this.f2.enqueue(e);

        while (!this.f1.isEmpty())
            this.f2.enqueue(this.f1.dequeue());

        Fila filaTemp = this.f1;
        this.f1 = this.f2;
        this.f2 = filaTemp;
    }

    public Object pop() throws FilaVaziaEx {
        if (this.isEmpty())
            throw new FilaVaziaEx("A pilha está vazia.");
        return this.f1.dequeue();
    }

    public Object top() throws FilaVaziaEx {
        if (this.isEmpty())
            throw new FilaVaziaEx("A pilha está vazia.");
        return this.f1.first();
    }
}
