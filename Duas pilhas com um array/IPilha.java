/**
 * Pilhas
 * V -> Pilha Vermelha
 * P -> Pilha Preta
 */

public interface IPilha  {

    void pushV(Object o);
    void pushP(Object o);

	Object popV() throws PilhaVaziaEx; 
    Object popP() throws PilhaVaziaEx; 
    
	Object topV() throws PilhaVaziaEx; 
    Object topP() throws PilhaVaziaEx; 

	boolean pVisEmpty(); 
    boolean pPisEmpty(); 

	int sizeV(); 
    int sizeP(); 
}
