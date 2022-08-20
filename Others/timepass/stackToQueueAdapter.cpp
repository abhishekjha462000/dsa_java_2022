#include <bits/stdc++.h>
using namespace std;
class stackToQueueAdapter{
	// make queue using stack and push in O(1)
public:
	/// push pop size empty front back 
	stack<int> *mainS;
	stack<int> *helperS;


	stackToQueueAdapter(){
		mainS = new stack<int>;
		helperS = new stack<int>;
	}
	void push(int val){
		// cout << "done" << endl;
		mainS->push(val);
		return ;
	}
	void pop(){
		if(mainS->size()==0){
			cout << "queue is empty... Nothing to pop" << endl;
			return ;
		}
		while(mainS->size()!=1){
			int val = mainS->top();
			mainS->pop();
			helperS->push(val);
		}
		mainS->pop();
		while(!helperS->empty()){
			int val = helperS->top();
			mainS->push(val);
			helperS->pop();
		}
	}
	int front(){
		if(mainS->empty())
		{
			cout << "queue is empty... Nothing at front" << endl;
			return -1;
		}
		while(mainS->size() != 1){
			int removeval = mainS->top();
			mainS->pop();
			helperS->push(removeval);
		}
		int val = mainS->top();
		while(!helperS->empty()){
			int aval = helperS->top();
			helperS->pop();
			mainS->push(aval);
		}
		return val;
	}
	int back(){
		if(mainS->empty())
		{
			cout << "queue is empty...Nothing at back" << endl;
			return -1;
		}
		int val = mainS->top();
		return val;
	}
	int size(){
		return mainS->size();
	}
	bool empty(){
		return mainS->empty();
	}
	friend ostream& operator<<(ostream& os, stackToQueueAdapter& q){
		if(q.size()==0){
			return os << "[]";
		}
		// cout << "entered" << endl; // for debugging
		while((q.mainS)->size()!=0){
			int val = (q.mainS)->top();
			(q.mainS)->pop();
			(q.helperS)->push(val); 
		}
		os << "[ ";
		while(!(q.helperS)->empty()){
			int val = (q.helperS)->top();
			// cout << val << endl; // for debugging
			os << val << " ";
			(q.helperS)->pop();
			(q.mainS)->push(val);
		}
		os << "]";
		return os;
	}
};
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	
	stackToQueueAdapter q;
	q.push(10);
	q.push(20);
	q.push(30);
	cout << q << endl;
	q.pop();
	cout << q << endl;
	cout << q.size() << endl;
	cout << q.front() << endl;
	cout << q.back() << endl;
	return 0;
}
