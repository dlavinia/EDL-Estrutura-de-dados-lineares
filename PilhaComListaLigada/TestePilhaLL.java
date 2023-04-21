package PilhaComListaLigada;

public class TestePilhaLL {
    public static void main(String[] args) {
        PilhaComListaLigada p = new PilhaComListaLigada();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);


		try{
			System.out.println(p.top());
			p.pop();
            System.out.println(p.top());
			p.pop();
            System.out.println(p.top());
			p.pop();
            System.out.println(p.top());
			p.pop();
            System.out.println(p.top());
			p.pop();
		
		}catch(PilhaVaziaEx erro){
			System.out.println(erro.getMessage());
			
		}
    }
}
