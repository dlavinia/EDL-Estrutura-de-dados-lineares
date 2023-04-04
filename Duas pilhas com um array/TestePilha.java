
public class TestePilha {
    public static void main(String[] args) throws PilhaVaziaEx {		  
      Pilhas P1 = new Pilhas(10); 

      System.out.println("|--- Pilha vermelha --->");
      System.out.println("Está vazia? " + P1.pVisEmpty());
      System.out.println("Tamanho: " + P1.sizeV() + "\n");

      System.out.println("<--- Pilha Preta ---|");
      System.out.println("Está vazia? " + P1.pPisEmpty() );
      System.out.println("Tamanho: " + P1.sizeP() + "\n");


      System.out.println("Inserindo elementos na pilha Vermelha... \n");
      for (int i = 0; i < 5; i++){
        P1.pushV(i*3);
      }    

      System.out.println("Inserindo elementos na pilha Preta...\n ");
      for (int i = 1; i < 6; i++){
        P1.pushP(i*2);
      }    

      System.out.println("|--- Pilha vermelha --->");
      System.out.println("Está vazia? " + P1.pVisEmpty());
      System.out.println("Tamanho: " + P1.sizeV());
      System.out.println("Elemento no topo: " + P1.topV() + "\n");


      System.out.println("<--- Pilha Preta ---|");
      System.out.println("Está vazia? " + P1.pPisEmpty() );
      System.out.println("Tamanho: " + P1.sizeP());
      System.out.println("Elemento no topo: " + P1.topP() + "\n");


      System.out.println("Removendo elemento no topo da pilha Vermelha...\n ");
      P1.popV();

      System.out.println("Removendo elemento no topo da pilha Preta...\n ");
      P1.popP();

      System.out.println("|--- Pilha vermelha --->");
      System.out.println("Está vazia? " + P1.pVisEmpty());
      System.out.println("Tamanho: " + P1.sizeV());
      System.out.println("Elemento no topo: " + P1.topV() + "\n");

      System.out.println("<--- Pilha Preta ---|");
      System.out.println("Está vazia? " + P1.pPisEmpty() );
      System.out.println("Tamanho: " + P1.sizeP());
      System.out.println("Elemento no topo: " + P1.topP() + "\n");
      
    }
  }