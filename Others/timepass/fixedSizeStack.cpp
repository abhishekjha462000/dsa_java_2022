#include <bits/stdc++.h>
using namespace std;
class customStack{
public:
	int *data;
	int size;
	int tos;
	int max_size;
	
	customStack(int cap){
		data = new int[cap];
		size = 0;
		tos = -1;
		max_size = cap;
	}
	// In C++ stack has 5 basic methods
	void push(int val){
		// if(size == data.length)
		// since i was not able to use the above line i made max_size variable as
		// a member of customStack

		if(size ==  max_size){
			cout << "stack overflow..., cannot push" << endl;
			return ;
		}
		data[++tos] = val;
		size++;
	}
	// In C++ , pop() does not return anything however in JAVA it returns the 
	// popped value as well
	void pop(){
		if(size == 0){
			cout << "stack underflow..., cannot pop" << endl;
			return ;
		}
		--tos;
		--size;
	}
	// In JAVA, we have peek() for this
	int top(){
		if(size == 0){
			cout << "stack underflow..., nothing on top" << endl;
			return -1;
		}
		return data[tos];
	}

	// Because in c++ if member functions have the same name as data member
	// then conflict arises, this is the reason i changed `top` to `tos`
	// and `size()` to `stack_size()`
	// int size(){
	// 	return size;
	// }
	int stack_size(){
		return size;
	}

	// In JAVA, we have isEmpty()
	bool empty(){
		return (size == 0);
	}

	friend ostream& operator<<(ostream& os, const customStack& s);
};

ostream& operator<<(ostream& os, const customStack& s){
	if(s.size == 0){
		return os << "[]";
	}
	os << "[ "; 
	for(int i = 0;i<s.size;i++){
		os << s.data[i] << " ";
	}
	os << "]";
	return os;
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
	#endif
 	customStack s(4);
 	s.push(10);
 	s.push(20);
 	s.push(30);
 	s.push(40); 
 	cout << s << endl;
 	s.push(50);
 	cout << s << endl;
 	cout << s.size << endl;
 	s.pop();
 	cout << s <<"--->" << s.size<< "---->" << s.top() << endl;
 	s.pop();
 	s.pop();
 	s.pop();
 	cout << s << endl;
 	s.pop();
 	cout << s << "--->" << s.size << endl;

 	return 0;
}

// c++ stack -- push pop top size empty
