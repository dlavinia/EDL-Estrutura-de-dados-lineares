package ListaDuplamenteLigada;

public class No {
    private Object elemento;
    private No proximo, anterior;


	public No(Object elemento, No proximo, No anterior) {
		this.elemento = elemento;
		this.proximo = proximo;
        this.anterior = anterior;
	}
	
	public No(Object elemento) {
		this.elemento = elemento;
		this.proximo = null;
        this.anterior = null;

	}

    public No getAnterior() {
        return anterior;
    }

    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object o){
        elemento = o;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No n){
        proximo = n;
}
}
