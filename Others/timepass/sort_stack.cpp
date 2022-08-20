#include <iostream>
#include <ostream>
#include <bits/stdc++.h>
using namespace std;
void print(ostream& os,stack<int>& s){
	if(s.empty())
		return ;
	int val = s.top();
	s.pop();
	print(os,s);

	os << val << " ";
	s.push(val);
}
ostream& operator<<(ostream& os,stack<int>& s){
	os << "[ ";
	print(os,s);
	os << "]\n";
	return os;
}
void insertCorrect(stack<int>& s,int val){
	if(s.empty())
	{
		s.push(val);
		return ;
	}
	if(s.top() <= val){
		s.push(val);
		return ;
	}
	int top = s.top();
	s.pop();
	insertCorrect(s, val);
	s.push(top);
}
void sort(stack<int>& s){
	if(s.size()<=1){
		// stack is already sorted, nothing to do
		return ;
	}

	// pick the top element
	int val = s.top();
	s.pop();
	// Now sort the remaining stack
	sort(s);
	// insert val to the its correct position in stack
	insertCorrect(s,val);
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
	#endif
 	stack<int> s;
 	s.push(90);
 	s.push(-2);
 	s.push(-89);
 	s.push(78);
 	s.push(0);
 	cout << s;
 	// sort the stack
 	sort(s);
 	cout << s;
 	return 0;
}

// c++ stack -- push pop top size empty
