package VectorComArray;

public class Vector {
    
    Object[] array;
    int proximo;
    int tamanhoMax;
    
    public Vector() {
        this.array = new Object[2];
        this.proximo = 0;
        this.tamanhoMax = 2;
    }
    
    public void add(Object o) {
        if (this.proximo == this.tamanhoMax) this.duplicaTam();
        this.array[this.proximo] = o;
        this.proximo++;
    }
   
    public void insertAtRank(int r, Object o) throws IndexInvalido {
        if (!(r > 0 && r < this.proximo)) 
            throw new IndexInvalido("Indice inválido."); 
        
        if (this.proximo == this.tamanhoMax) this.duplicaTam();
        
        for (int i = this.proximo; i > r; i--)
            this.array[i] = this.array[i-1];
        this.array[r] = o;
        this.proximo++;
    }
    
    public Object elemAtRank(int r) throws IndexInvalido {
        if (!(r > 0 && r < this.proximo)) 
            throw new IndexInvalido("Indice inválido.");
        
        return this.array[r];
    }
    
    public void removeAt(int r) throws IndexInvalido {
        if (!(r > 0 && r < this.proximo)) 
            throw new IndexInvalido("Indice inválido.");
        
        for (int i = r+1; i < this.proximo; i++)
            this.array[i-1] = this.array[i];
        
        this.proximo--;
    }
    
    public void replaceAtRank(int r, Object o) throws IndexInvalido {
        if (!(r > 0 && r < this.proximo)) 
            throw new IndexInvalido("Indice inválido.");
        
        this.array[r] = o;
    }
    
    
    private void duplicaTam(){
        this.tamanhoMax = this.tamanhoMax * 2;
	    Object[] novoArray = new Object[this.tamanhoMax];
	    for (int i = 0; i < this.proximo; i++)
            novoArray[i] = this.array[i];
	    this.array = novoArray;
    }
    
    public int size() {
        return this.proximo;
    }
    
    public boolean isEmpty() {
        return this.proximo == 0;
    }
    
    public void mostrar() {
        for (int i = 0; i < this.proximo; i++)
            System.out.print(this.array[i]+"->");
        System.out.println("|fim|");
    }
}
