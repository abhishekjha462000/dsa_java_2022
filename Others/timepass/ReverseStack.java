import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

import java.util.Stack;
class Main{
	public static void insertAtBottom(Stack<Integer> st, int val){
		// Base case is when stack is empty
		// just insert the element at the bottom
		if(st.isEmpty())
		{
			st.push(val);
			return ;
		}

		// otherwise pop the topmost element and push the val in the remaining
		// stack(Note that you would not do this, this would be done by recursion)
		int removed = st.pop();
		insertAtBottom(st,val);
		// Now that the val has been inserted at the bottom, let us again put the
		// val into the stack
		st.push(removed);
	}
	public static void reverse(Stack<Integer> st){
		// Base case is when stack is empty or stack has only 1 element
		if(st.size() <= 1)
			return ;
		// Otherwise if the stack is not empty, pop the top element and the 
		// reverse the remaining stack using recursion 
		int val = st.pop();
		reverse(st);
		// now insert the val at the bottom of the stack
		insertAtBottom(st,val);
	}
	public static void main(String[] args) {
		initializeIO();
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<5;i++){
			st.push(i+1);
		}
		System.out.println(st);
		reverse(st);
		System.out.println(st);
	}
	private static void initializeIO(){
    	try 
    	{
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            // System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}
