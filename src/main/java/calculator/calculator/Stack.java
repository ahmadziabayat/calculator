package calculator.calculator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//using array to implement a stack
//downward stack
public class Stack<T>
{
    private T [ ] spaces;
    private int TOS;

    private int capacity;


    @SuppressWarnings("unchecked")
	public Stack ()
    {
        capacity = 50;
        spaces  = (T [ ]) new Object [capacity];
        TOS = capacity;

    }
    

    public boolean overflow ()
    {
        return (TOS == 0);
    }

    public boolean empty ()
    {
    // checks if the stack is empty
        return (TOS == capacity);
    }

    public boolean push (T newMem)
    {
        boolean ok = true;
        if (overflow ())
        {
            System.out.println ("stack overflow");
            ok = false;
        }
        else
        {
            spaces[--TOS] = newMem;
            System.out.println (newMem + " pushed");
        }

        return ok;
    }

    public T pop ()
    {
    	// removes an element from the top of this stack
        T popped = null;
        if (empty ())
            System.out.println ("empty");
         else
             popped = spaces[TOS++];

        return popped;

    }

    public T peekTOS ( )
    {
    // returns the element on top of this stack
        T atTOS = null;
        if (!empty ())
            atTOS = spaces [TOS];
        return atTOS;

    }
    public T peekN(int n){
    	// peek at index n
    	   return spaces[n];
    }
    public int size(){
    	return TOS + 1;
    }
    
    public void displayStack(String s){
    	System.out.print(s);
    	System.out.print("Stack (bottom -->top): ");
    	for (int i = 0; i < size(); i++){
    		System.out.print(peekN(i));
    		System.out.print(' ');
    		
    	}
    	System.out.println(" ");
    }

 
}

