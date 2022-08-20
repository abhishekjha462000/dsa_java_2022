#include <iostream>
#include <queue>
using namespace std;
ostream& operator<<(ostream& os, queue<int> q){
	if(q.empty()) // checks whether the queue is empty
	{
		return os <<"[]";
	}
	os << "[ ";
	while(!q.empty()){
		int val = q.front();
		q.pop();
		cout << val << " ";
	}
	os << "]";
	return os;
}
int main(){
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif

	queue<int> q;
	for(int i=0;i<5;i++){
		q.push(i+1); // pushes at the end of queue
	}
	q.emplace(6); // pushes at the end of queue
	cout << q << endl;
	q.pop();// pops from the front but doesnt return 
	cout << q << "--->" << q.size() << endl;

	cout << q.front() << endl;
	cout << q.back() << endl;

	q.front() = 7; // actually it return the references of the first element
	q.back() = -1; // returns the reference of the last element
	cout << q << endl;

	// TO EMPTY THE QUEUE WE DONT HAVE q.clear()

	// INSTEAD WE HAVE q = {}

	q = {};
	cout << q << "--->" << q.size() << endl;

	//SWAPPING IN QUEUES

	queue<int> q1;
	queue<int> q2;

	for(int i = 0;i<10;i++){
		if(i<5){
			q1.push(i+1);
		}else{
			q2.push(i+1);
		}
	} 
	cout << "BEFORE SWAPPING..." << endl;
	cout << "q1: " << q1 << endl;
	cout << "q2: " << q2 << endl;

	q1.swap(q2);
	// swap(q1,q2);// implicitly calls q1.swap(q2);

	cout << "AFTER SWAPPING..." << endl;
	cout << "q1: " << q1 << endl;
	cout << "q2: " << q2 << endl;

	// RANGE BASED FOR LOOPS DO NOT WORK IN CASE OF QUEUES
	// because they do not have q.begin() and q.end() iterators
	// for(auto&x :q)
	// 	cout << x << " ";
	// cout <<  endl;

	// similarily it is not possible to sort a queue using sort function
	// as this uses iterators and they don't have iterators
	// q1.sort();
	return 0;
}
