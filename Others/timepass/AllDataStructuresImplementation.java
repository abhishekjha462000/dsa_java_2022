import java.lang.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

import java.util.Queue;

class node{
	int data;
	node next;
	{
		data = 0 ; // no need 
		next = null;// no need 
	}
	node(){

	}
	node(int val){
		data = val;
		next = null;// no need 
	}
}
class normalStack{
	int[] data;
	int size;
	int top;
	{
		size = 0 ;
		top  = -1;
	}

	normalStack(int cap){
		data = new int[cap];
		size = 0;
		top = -1;
	}
	void push(int val){
		if(top == data.length-1)
		{
			System.out.println("Stack overflow");
			return ;
		}
		data[++top] = val;
		size++;
	}
	void pop(){
		if(size == 0){
			System.out.println("Stack underflow");
			// return -1;
			return ;
		}
		top--;
		size--;
	}
	int peek(){
		if(size == 0){
			System.out.println("Stack underflow");
			return -1;
		}
		return data[top];
	}
	int size(){
		return size;
	}
	boolean isEmpty(){
		return (top == -1);
	}

	@Override
	public String toString(){
		if(size == 0)
			return "[]";
		String ans = "[ ";
		int pos = 0;
		while(pos <= top){
			ans += data[pos]+" ";
			pos++;
		}
		ans += "]";
		return ans;

	}
}
class dynamicStack{
	int[] data;
	int top;
	int size;

	dynamicStack(int cap){
		data = new int[cap];
		top = -1;
		size = 0;
	}
	void push(int val){
		if(size == data.length)
		{
			int cap = data.length;
			System.out.println("Stack overflow, resizing now...");
			// do something
			int[] olddata = data;
			data = new int[2*cap];
			for(int i = 0;i<cap;i++){
				data[i] = olddata[i];
			}
			olddata = null;
		}
		data[++top] = val;
		size++;
	}
	void pop(){
		if(size == 0){
			System.out.println("Stack underflow...");
			return;
		}
		top = top-1;
		size--;
	}
	int size(){
		return size;
	}
	int peek(){
		if(size == 0){
			System.out.println("Stack underflow...");
			return -1;
		}
		int val = data[top--];
		size--;
		return val;
	}
	boolean isEmpty(){
		return (size == 0);
	}
	@Override
	public String toString(){
		if(size == 0){
			return "[]";
		}
		String ans = "[ ";
		int pos = 0;
		while(pos <= top){
			ans += data[pos]+" ";
			pos++;
		}
		ans += "]";
		return ans;
	}
}
class list{
	node head;
	node tail;
	int size;
	{
		head = null;
		size = 0;
	}

	list(){
		head = null;
		size = 0;
	}
	void addFirst(int val){
		node n = new node(val);
		if(size == 0){
			head = tail = n;
		}else{
			n.next = head;
			head = n;
		}
		n = null;
		size++;
	}
	void addLast(int val){
		node n = new node(val);
		if(size == 0){
			head = tail = n;
		}else{
			node curr = head;
			while(curr.next !=null){
				curr = curr.next;
			}
			curr.next = n;
			tail = n;
			curr = null;
		}
		n = null;
		size++;
	}
	int size(){
		return size;
	}
	void add(int index, int val){
		// add only if index in 0 to size
		if(index == 0){
			addFirst(val);
		}else if(index == size()){
			addLast(val);
		}else{
			node prev = null;
			node curr = head;
			while(index--!=0){
				prev =curr;
				curr = curr.next;
			}
			node n = new node(val);
			prev.next = n;
			n.next = curr;
			// Nullify them also not necessary but thought proces
			// must be clear
			prev = null;
			curr = null;
			n = null;
			size++;
		}
	}

	void removeFirst(){
		if(size() == 0)
			return ;
		if(size() == 1){
			head = null;
			size--;
			return;
		}
		node curr = head;
		head = head.next;
		curr.next = null;
		curr = null;
		size--;
	}
	void removeLast(){
		if(size == 0)
			return ;
		if(size == 1){
			removeFirst();
			return;
		}
		node curr = head;
		while(curr.next!=tail){
			curr = curr.next;
		}
		curr.next = null;
		tail = curr;
		curr =  null;
		size--; 
	}
	void remove(int index){
		if(index <0  || index >= size)
			return ;
		if(index == 0){
			removeFirst();
			return;
		}
		if(index == size-1){
			removeLast();
			return;
		}
		node prev = null;
		node curr = head;
		while(index--!=0){
			prev = curr;
			curr = curr.next;
		}
		prev.next = curr.next;
		curr.next = null;
		prev = curr;
		curr = null;
		size--;
	}
	int getFirst(){
		if(size == 0)
		{
			System.out.println("List is empty...");
			return -1;
		}
		return head.data;
	}
	int getLast(){
		if(size == 0){
			System.out.println("List is empty...");
			return -1;
		}
		return tail.data;
	}
	int get(int index){
		if(size == 0){
			System.out.println("List is empty...");
			return -1;
		}
		if(index == 0){
			return getFirst();
		}
		if(index == size -1)
			return getLast();
		node curr = head;
		while(index--!=0){
			curr = curr.next;
		}
		return curr.data;

	}
	@Override
	public String toString(){
		String ans = "";
		node curr = head;
		ans += "[ ";
		while(curr != null){
			ans += curr.data + " ";
			curr = curr.next;
		}
		ans+= "]";
		return ans;
	}
}
class normalQueue{
	int[] data;
	int size;
	int front;
	{
		size  = 0;
		front = 0;
	}
	normalQueue(int cap){
		data = new int[cap];
	}
	void add(int val){
		if(size == data.length)
		{
			System.out.println("Queue overflow");
			return;
		}
		int index  = (front+size)%(data.length);
		data[index] = val;
		size++;
	}
	void remove(){
		if(size == 0){
			System.out.println("Queue is empty, nothing to remove...");
			return;
		}
		front = (front+1)%(data.length);
		size--;

	}
	int peek(){
		if(size == 0){
			System.out.println("Queue is empty, nothing to peek...");
			return -1;
		}
		return data[front];
	}
	int size(){
		return size;
	}
	boolean isEmpty(){
		return (size == 0);
	}
	@Override
	public String toString(){
		if(size == 0){
			return "[]";
		}
		String ans = "[ ";
		int times = 0; // front == 1 // size == 4
		while(times < size){// times 0,1,2,3
			int index = (times+front)%(data.length);
			ans += data[index]+" ";
			times++;
		}
		ans += "]";
		return ans;
	}
}
class dynamicQueue{
	int[] data;
	int front;
	int size;
	dynamicQueue(int cap){
		data = new int[cap];
		front = 0 ;
		size = 0;
	}
	void add(int val){
		if(size ==  data.length){
			// do the resizing
			System.out.println("Queue overflow, resizing...");
			int[] olddata = data;
			data = new int[2*size];
			// now fill the values in data from olddata
			int pos = 0;
			while(pos <size){
				data[pos] = olddata[(pos+front)%(data.length)];
				pos++;
			}
			front = 0;

		}
		int index = (front+size)%(data.length);
		data[index] = val;
		size++;
	}
	void remove(){
		if(size == 0){
			System.out.println("Queue is empty...");
			return ;
		}
		front = (front+1)%(data.length);
		size--;
	}
	int peek(){
		if(size == 0){
			System.out.println("Queue is empty, nothing to show...");
			return -1;
		}
		return data[front];

	}
	int size(){
		return size;
	}
	boolean isEmpty(){
		return size == 0;
	}
	@Override
	public String toString(){
		if(size == 0)
			return "[]";
		String ans = "[ ";
		int pos = 0;
		while(pos < size){
			ans += data[(pos+front)%(data.length)]+" ";
			pos++;
		}
		ans += "]";
		return ans;
	}
}
class Main{
	public static void print(dynamicQueue q){
		System.out.println(q+"-->"+q.size()+"-->"+q.isEmpty());
		return;
	}
	public static void main(String[] args) {
		initializeIO();
		

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
