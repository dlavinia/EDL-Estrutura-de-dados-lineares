public class FilaComPilhas {
    public static void main(String[] args) throws FilaVaziaEx, PilhaVaziaEx {
		FilaComDuasPilhas f = new FilaComDuasPilhas(); //criando fila tamnho 1 e duplicação
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
