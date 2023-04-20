package FilaComListaLigada;

public class testeFilaLL {
    public static void main(String[] args) {
        FilaComListaLigada f = new FilaComListaLigada();

        f.enqueue(1);
		f.enqueue(2);
		f.enqueue(3);
		f.enqueue(4);
		try{
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
			System.out.println(f.first());
			f.dequeue();
		
		}catch(FilaVaziaEx erro){
			System.out.println(erro.getMessage());
			
		}
    }
}
