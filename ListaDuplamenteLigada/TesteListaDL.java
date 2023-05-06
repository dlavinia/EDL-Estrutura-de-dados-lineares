package ListaDuplamenteLigada;


public class TesteListaDL {
    public static void main(String[] args) {
        ListaDuplamenteLigada ldl = new ListaDuplamenteLigada();
        System.out.println("Tamanho: "+ ldl.tamanho());
        System.out.println("Está vazia? "+ ldl.isEmpty());

        ldl.addFim(1);
        ldl.addFim(2);
        ldl.addFim(3);
        ldl.addFim(4);
        ldl.addFim(5);
        ldl.addFim(6);

        // ldl.addInicio("a");
        // ldl.addInicio("b");
        // ldl.addInicio("c");

        ldl.mostrar();

        // ldl.removeFim();
        // ldl.removeInicio();
        // ldl.mostrar();
       
        No p = ldl.atRank(0);
        ldl.insertAfter(p, "X");
       
        No q = ldl.atRank(2);
        ldl.insertBefore(q, "Y");
        ldl.mostrar();

        System.out.println(ldl.rankOf(q));

        System.out.println("Tamanho: "+ ldl.tamanho());
        System.out.println("Está vazia? "+ ldl.isEmpty());
    }
   
}
