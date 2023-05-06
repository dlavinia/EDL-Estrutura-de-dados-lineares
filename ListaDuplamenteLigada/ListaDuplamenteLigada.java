package ListaDuplamenteLigada;

public class ListaDuplamenteLigada {
    No inicio;
    No fim;
    int tamanho;

    public ListaDuplamenteLigada() {
        inicio = null;
        fim = null;
        tamanho = 0;
    }

    public No addInicio(Object elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            this.fim = novoNo;
        } else {
            inicio.setAnterior(novoNo);
            novoNo.setProximo(inicio);

            inicio = novoNo;
            tamanho++;
        }
        return novoNo;
    }

    public No addFim(Object elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            this.inicio = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
        }
        fim = novoNo;
        tamanho++;
        return novoNo;

    }

    public Object removeInicio() {
        if (inicio == null) {
            System.out.println("Lista vazia");
        }
        Object elemento = inicio.getElemento();

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        }
        tamanho--;

        return elemento;
    }

    public Object removeFim() {

        if (inicio == null) {
            System.out.println("Lista vazia");
        }
        Object elemento = fim.getElemento();

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.getAnterior();
            fim.setProximo(null);
        }
        tamanho--;

        return elemento;
    }

    public Object remove(No p){
        Object elemento = p.getElemento();
        (p.getAnterior()).setProximo(p.getProximo());
        (p.getProximo()).setAnterior(p.getAnterior());
        p.setAnterior(null);
        p.setProximo(null);

        return elemento;

    }
    public void insertAfter(No p, Object e) {
        No q = new No(e);
        q.setAnterior(p);
        q.setProximo(p.getProximo());
        (p.getProximo()).setAnterior(q);
        p.setProximo(q);

    }

    public void insertBefore(No p, Object e) {
        No q = new No(e);
        q.setProximo(p);
        q.setAnterior(p.getAnterior());
        (p.getAnterior()).setProximo(q);
        p.setAnterior(q);

    }

    public No atRank(int rank){
        No novoNo;
        if(rank <= (tamanho()/2)){
            novoNo = this.inicio;
            for (int i=0; i<rank; i++){
                novoNo = novoNo.getProximo();
            }
        }else{
            novoNo = fim.getAnterior();
            for(int i=0; i < tamanho()-rank-1;i++){
                novoNo.getAnterior();
            }
        }
        return novoNo;
    }

    public Object rankOf(No no){
        No n = this.inicio.getProximo();
        int r = 0;
        while (n != no && n!=this.fim){
            n = n.getProximo();
            r++;
        }
        return r;
    }

    public void mostrar() {
        No aux = this.inicio;

        while (aux != null) {
            Object elemento = aux.getElemento();
            System.out.print(elemento + "->");
            aux = aux.getProximo();
        }
        System.out.print("|fim|\n");

        // aux = fim;
        // while(aux != null){
        // Object elemento = aux.getElemento();
        // System.out.print(elemento + "->");
        // aux = aux.getAnterior();
        // }
        // System.out.print("Inicio\n\n");

    }

    public int tamanho() {
        return tamanho;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }
}
