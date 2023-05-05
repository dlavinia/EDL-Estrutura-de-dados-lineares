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

    public void addInicio(Object elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            this.fim = novoNo;
        } else {
            inicio.setAnterior(novoNo);
            novoNo.setProximo(inicio);

            inicio = novoNo;
            tamanho++;
        }
    }

    public void addFim(Object elemento) {
        No novoNo = new No(elemento);
        if (inicio == null) {
            this.inicio = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim); 
        }
            fim = novoNo;
            tamanho++;
    }

    public Object removeInicio() {
        if (inicio == null) {
           System.out.println( "Lista vazia");
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
           System.out.println( "Lista vazia");
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

    public void mostrar(){
        No aux = this.inicio;
        
        while(aux != null){
            Object elemento = aux.getElemento();
            System.out.print(elemento + "->");
            aux = aux.getProximo();
        }
        System.out.print("|fim|\n");

        // aux = fim;
        // while(aux != null){
        //     Object elemento = aux.getElemento();
        //     System.out.print(elemento + "->");
        //     aux = aux.getAnterior();
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

