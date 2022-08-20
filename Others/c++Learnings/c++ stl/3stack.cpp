#include <iostream>
#include <stack>
using namespace std;
void print(ostream& os,stack<int>& s){
	if(s.empty()) // checks whether the stack is empty or not
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
	os << "]";
	return os;
}
int main(){
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif

	stack<int> s;
	for(int i = 0 ;i<5;i++){
		s.push(i+1);
	}
	s.emplace(6);
	// stack cannot be printed without removing its elements
	cout << s << endl;
	s.pop(); // does not return the removed element
	cout << s << endl;
	cout << s.top() << endl;
	s.top() = -78;
	cout << s << endl;

	// clearing the stack
	// There is no method like s.clear()
	s =  {};
	cout << s << endl;

	// SWAPPING TWO STACKS ... this is O(1) thanks to the move constructor
	stack<int> s1;
	stack<int> s2;
	for(int i = 0 ;i<5;i++){
		s1.push(5-i);
	}

	for(int i = 0;i<5;i++){
		s2.push(i+1);
	}
	cout << "Before swapping..." << endl;
	cout << "s: " << s1 << endl;
	cout << "s2: " << s2 << endl;
	s1.swap(s2);
	// swap(s1,s2); implicitly calls s1.swap(s2)
	cout << "After swapping..." << endl;
	cout << "s: " << s1 << endl;
	cout << "s2: " << s2 << endl;
	s.swap(s2);


	// in stacks no range based for loops
	// for(auto &x:s1){
	// 	cout << x << endl;
	// }

	// as they dont have s.begin() and s.end() iterators
	return 0;
}
