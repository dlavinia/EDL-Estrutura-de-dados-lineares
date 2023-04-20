
//i índice do elemento do início
// f índice imediatamente após o último elemento
public class Fila implements IFila {

    int i = 0, f = 0, N;
    Object O[];

    public Fila(int n) {
        O = new Object[n];
        this.N = n; // Tamanho
    }

    @Override
    public void enqueue(Object o) {
        if (size() == N - 1) { // encheu coleguinha
            int novoTam = N * 2;
            Object[] b = new Object[novoTam];

            int ii = i;
            for (int ff = 0; ff < size(); ff++) {
                b[ff] = O[ii];
                ii = (ii + 1) % N;
            }

            f = size(); // definir o novo final
            i = 0; // definir o novo inicio
            N = novoTam;
            O = b;
        }
        O[f] = o;
        f = (f + 1) % N;
    }

    @Override
    public Object dequeue() throws FilaVaziaEx {
        if (isEmpty())
            throw new FilaVaziaEx("A Pilha está vazia");
        Object temp = O[i];
        i = (i + 1) % N;
        return temp;
    }

    @Override
    public Object first() throws FilaVaziaEx {
        return this.O[i];
    }

    @Override
    public int size() {
        return (N-i+f)%N;
    }

    @Override
    public boolean isEmpty() {
        return f==i;
    }

}
