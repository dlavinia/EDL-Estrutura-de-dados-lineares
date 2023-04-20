package PilhaComDuasFilas;

public class PilhaComFilas {

	public static void main(String[] args) {
		PilhaComDuasFilas p= new PilhaComDuasFilas(); //criando PilhaComDuasFilas tamnho 1 e duplicação
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
			
		
		}catch(FilaVaziaEx erro){
			System.out.println(erro.getMessage());
			
		}
	}

}
