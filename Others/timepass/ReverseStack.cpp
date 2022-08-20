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
void insert(stack<int>& s,int val){
	if(s.empty() || s.top()<=val){
		s.push(val);
		return ;
	}
	int remove = s.top();
	s.pop();
	insert(s,val);
	s.push(remove);
}
void reverse(stack<int>& s){
	if(s.empty())
		return ;
	int val = s.top();
	s.pop();
	reverse(s);
	insert(s,val);
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
	#endif
 	stack<int> s;
 	for(int i = 0;i<5;i++){
 		s.push(5-i);
 	}
 	cout << s;
 	reverse(s);
 	cout << s;
 	return 0;
}

// c++ stack -- push pop top size empty
