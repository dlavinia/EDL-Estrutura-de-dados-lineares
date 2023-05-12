package ListaComListaDuplamenteLigada;

import ListaDuplamenteLigada.ListaDuplamenteLigada;
import ListaDuplamenteLigada.No;

public class Lista {
    ListaDuplamenteLigada ldl;

    public Lista() {
        this.ldl = new ListaDuplamenteLigada();
    };

    public int size() {
        return this.ldl.tamanho();
    }

    public boolean isEmpty() {
        return this.ldl.tamanho() == 0;
    }

    public boolean isFirst(No no){
        return no==this.ldl.getInicio(); 
   }
    public boolean isLast(No no){ 
        return no==this.ldl.getFim();    }

    public Object first(){
        return (this.ldl.getInicio()).getElemento(); 
    }
    public Object last(){
        
        return (this.ldl.getFim()).getElemento(); 
    }
    
    public Object before(int p) throws IndexInvalido{
        if (p < 0 || p > this.ldl.tamanho()){
            throw new IndexInvalido("Indice inválido.");
        }
        No no = this.ldl.atRank(p);
        no = no.getAnterior();
        Object elem = no.getElemento();
        return elem;
    }
    public Object after(int p) throws IndexInvalido{
        if (p < 0 || p > this.ldl.tamanho()){
            throw new IndexInvalido("Indice inválido.");
        }
        No no = this.ldl.atRank(p);
        no = no.getProximo();
        Object elem = no.getElemento();
        return elem;
    }

    public void replaceElement(No n, Object o){
        n.setElemento(o);
    }
    public void swapElements(No n, No q){
        Object aux = n.getElemento();
        n.setElemento(q.getElemento());
        q.setElemento(aux);
    }
    
    public void insertBefore(No n, Object o){
        this.ldl.insertBefore(n, o);
    }

    public void insertAfter(No n, Object o){
        this.ldl.insertAfter(n, o);
    }
    public void insertFirst(Object o){
        this.ldl.addInicio(o);
    }
    public void insertLast(Object o){
        this.ldl.addFim(o);
    }
    public void remove(No n){
        this.ldl.remove(n);
    }
}

