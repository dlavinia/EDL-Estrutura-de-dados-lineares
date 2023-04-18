import java.util.ArrayList;

public class Pilha {

    private ArrayList<Object> pilha;
    public Pilha() {
        pilha = new ArrayList<>();
    }
  
    public void push(Object obj) {
       pilha.add(obj);
    }

    public Object pop() throws PilhaVaziaEx {
        if (isEmpty()) {
            throw new PilhaVaziaEx("A pilha está vazia.");
        }
        else {
            return pilha.remove(pilha.size()-1) ;
        }
    }

    public Object top() throws PilhaVaziaEx {
        if (isEmpty()) {
            throw new PilhaVaziaEx("A pilha está vazia.");
        }
        else {
            return pilha.get(pilha.size()-1);
        }
    }

    public boolean isEmpty() {
        return pilha.size() == 0;
    }
  
    public int size() {
        return pilha.size();
    }

}
