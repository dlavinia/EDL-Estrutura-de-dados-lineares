package PilhaComDuasFilas;


public interface IPilha  {

    void push(Object o);

	Object pop() throws PilhaVaziaEx; 
    
	Object top() throws PilhaVaziaEx; 

	boolean isEmpty(); 

	int size(); 
}
