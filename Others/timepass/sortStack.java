import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

import java.util.Stack;
class Main{
	public static void insertCorrect(Stack<Integer> st, int val){
		if(st.isEmpty())
		{
			st.push(val);
			return ;
		}
		if(st.peek()<=val){
			st.push(val);
			return ;
		}
		int tos = st.pop();
		insertCorrect(st,val);
		st.push(tos);
	}
	public static void sort(Stack<Integer> st){
		if(st.size()<=1){
			return ;
		}
		int val = st.pop();
		// sort the remaining stack
		sort(st);
		insertCorrect(st, val);
	}
	public static void main(String[] args) {
		initializeIO();
		Stack<Integer> st = new Stack<>();
		st.push(90);
		st.push(-2);
		st.push(-89);
		st.push(78);
		st.push(0);
		System.out.println(st);
		sort(st);
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
