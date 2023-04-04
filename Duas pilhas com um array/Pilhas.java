/**
 * Pilhas
 * V -> Pilha Vermelha
 * P -> Pilha Preta
 */
public class Pilhas {

    private int capacidade, topoV, topoP;
    private Object[] PilhasArray;

    public Pilhas(int capacidade) {
        this.capacidade = capacidade;
        topoV = -1;
        topoP = capacidade;
        PilhasArray = new Object[capacidade];
    }
  
    public void pushV(Object obj) {
        if (topoV + 1 == topoP){
            int qtdP = sizeP();
            capacidade *= 2;
            
            Object[] NovoArray = new Object[capacidade];
            for (int i=0; i<topoV; i++) {
                NovoArray[i] = PilhasArray[i];
            }
            for (int i=capacidade - 1; i>capacidade - qtdP; i--) {
              NovoArray[i] = PilhasArray[i - (capacidade/2)];
            }
            PilhasArray = NovoArray;
            topoP = capacidade - qtdP;
        }
        PilhasArray[++topoV] = obj;
    }

    public void pushP(Object obj) {
        if (topoV + 1 == topoP){
            int qtdP = sizeP();
            capacidade *= 2;
    
            Object[] NovoArray = new Object[capacidade];
            for (int i=0; i<topoV; i++) {
                NovoArray[i] = PilhasArray[i];
            }
            for (int i=capacidade - 1; i>capacidade - qtdP; i--){
              NovoArray[i] = PilhasArray[i - (capacidade/2)];
            }
            PilhasArray = NovoArray;
            topoP = capacidade - qtdP;
        }
        PilhasArray[--topoP] = obj;
    }

    public Object popV() throws PilhaVaziaEx {
        if (pVisEmpty()) {
            throw new PilhaVaziaEx("A pilha Vermelha está vazia.");
        }
        else {
            return PilhasArray[topoV--];
        }
    }

    public Object popP() throws PilhaVaziaEx {
        if (pPisEmpty()) {
            throw new PilhaVaziaEx("A pilha  está vazia.");
        }
        else {
            return PilhasArray[topoP++];
        }
    }

    public Object topV() throws PilhaVaziaEx {
        if (pVisEmpty()) {
            throw new PilhaVaziaEx("A pilha Vermelha está vazia.");
        }
        else {
            return PilhasArray[topoV];
        }
    }

    public Object topP() throws PilhaVaziaEx {
        if (pPisEmpty()) {
            throw new PilhaVaziaEx("Pilha Preta está vazia.");
        }
        else {
            return PilhasArray[topoP];
        }
    }

    public boolean pVisEmpty() {
        return topoV == -1;
    }
  
    public boolean pPisEmpty() {
        return topoP == capacidade;
    }

    public int sizeV() {
        return topoV + 1;
    }

    public int sizeP() {
        return capacidade - topoP;
    }

}
