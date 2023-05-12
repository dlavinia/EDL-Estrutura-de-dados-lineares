package VectorComLDL;

public class TesteVectorArray {
    public static void main(String[] args) throws IndexInvalido {
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);

        v.mostrar();
        
        v.insertAtRank(2, "a");
        System.out.println("Elemento indice 2: " +v.elemAtRank(2));

        v.replaceAtRank(2, "a1");
        System.out.println("Elemento indice 2 depois do replace: " +v.elemAtRank(2));
        v.mostrar();


        v.removeAt(2);
        System.out.println("Removendo elemento do indice 2...");

        v.mostrar();
    }
}
