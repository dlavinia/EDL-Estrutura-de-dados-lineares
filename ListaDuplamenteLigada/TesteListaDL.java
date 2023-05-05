package ListaDuplamenteLigada;


public class TesteListaDL {
    public static void main(String[] args) {
        ListaDuplamenteLigada ldl = new ListaDuplamenteLigada();
        System.out.println("Tamanho: "+ ldl.tamanho());
        System.out.println("Está vazia? "+ ldl.isEmpty());

        ldl.addFim(1);
        ldl.addFim(2);
        ldl.addFim(3);

        ldl.mostrar();

        ldl.addInicio("a");
        ldl.addInicio("b");
        ldl.addInicio("c");

        ldl.mostrar();

        ldl.removeFim();
        ldl.removeInicio();
        ldl.mostrar();
    }

}
