package VectorComLDL;

import ListaDuplamenteLigada.ListaDuplamenteLigada;

public class Vector {
    
    ListaDuplamenteLigada ldl;
    int tamanho;
    
    public Vector() {
        ldl = new ListaDuplamenteLigada();
        tamanho = 0;
    }
    
    public void add(Object o) {
        ldl.addFim(o);
        this.tamanho++;
    }
   
    public void insertAtRank(int r, Object o) throws IndexInvalido {
        if (!(r > 0 && r < this.tamanho)) 
            throw new IndexInvalido("Indice inválido."); 
                
        ldl.insertBefore(ldl.atRank(r), o);
        this.tamanho++;
    }
    
    public Object elemAtRank(int r) throws IndexInvalido {
        if (!(r > 0 && r < this.tamanho)) 
            throw new IndexInvalido("Indice inválido.");
        
        return this.ldl.atRank(r).getElemento();
    }
    
    public void removeAt(int r) throws IndexInvalido {
        if (!(r > 0 && r < this.tamanho)) 
            throw new IndexInvalido("Indice inválido.");
        
        this.ldl.remove(this.ldl.atRank(r));
        this.tamanho--;
    }
    
    public void replaceAtRank(int r, Object o) throws IndexInvalido {
        if (!(r > 0 && r < this.tamanho)) 
            throw new IndexInvalido("Indice inválido.");
        
        this.ldl.atRank(r).setElemento(o);
    }
    
    public int size() {
        return this.tamanho;
    }
    
    public boolean isEmpty() {
        return this.tamanho == 0;
    }
    
    public void mostrar() {
        this.ldl.mostrar();
    }
}
