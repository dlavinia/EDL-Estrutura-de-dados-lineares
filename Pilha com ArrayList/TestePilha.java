
public class TestePilha {
    public static void main(String[] args) throws PilhaVaziaEx {		  
      Pilha pilha = new Pilha(); 

      System.out.println("|--- Pilha --->");
      System.out.println("Está vazia? " + pilha.isEmpty());
      System.out.println("Tamanho: " + pilha.size() + "\n");

      System.out.println("Inserindo elementos na pilha... \n");
      for (int i = 1; i < 6; i++){
        pilha.push(i);
      }    

      System.out.println("|--- Pilha --->");
      System.out.println("Está vazia? " + pilha.isEmpty());
      System.out.println("Tamanho: " + pilha.size());
      System.out.println("Elemento no topo: " + pilha.top() + "\n");


      System.out.println("Removendo elemento no topo da pilha...\n ");
      pilha.pop();

      System.out.println("|--- Pilha --->");
      System.out.println("Está vazia? " + pilha.isEmpty());
      System.out.println("Tamanho: " + pilha.size());
      System.out.println("Elemento no topo: " + pilha.top() + "\n");
    }
  }