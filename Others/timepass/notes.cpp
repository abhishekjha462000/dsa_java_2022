#include <bits/stdc++.h>
using namespace std;
ostream& operator<<(ostream& os, queue<int> q){
	if(q.size()==0)
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
	#endif
 	queue<int> q;
 	q.push(10);
 	q.push(20);
 	q.push(30);
 	q.push(40);
 	cout << q << "-->" << q.size() << endl;
 	q.pop();
 	cout << q << "-->" << q.size() << endl;
 	q.front() = -1;
 	q.back() = -1;
 	cout << q << "-->" << q.size() << endl;

 	return 0;
}
/*
	queue<int> q;
	q.push(20);
	q.emplace(20);
	q.pop();
	q.front();
	q.back();
	q.size();
	q.empty();
	q1.swap(q2);

*/
/*
	// all O(1)
	stack<int> s;
	s.push(20);
	s.emplace(20);
	s.pop();// does not return anything
	s.top();
	s.size();
	s.empty();
	s1.swap(s2);
	// non iterable and no auto loop
	// you will have to make yourself
*/

/*	
	// all O(1)
	#define pi pair<int,int>
	pair<int,int> p;
	pi p2(p);
	pi p3 = p2;
	pi p4;
	p4 = p3;


	p.first;
	p.second;

	p = {1,2};
	p = make_pair(3,4);
	p1.swap(p2);
*/
/*
	vector<int> v;
	v.push_back(20);
	v.pop_back();
	v.emplace_back(20);
	v.size();
	v.at(index);
	v[index];
	v.front();
	v.back();
	v.clear();
	v1.swap(v2);
	v.begin();
	v.end();
	v.erase(iterator);
	vector<int>::iterator it = v.begin();
	v1.swap(v2); O(1)
	iterable using for loop and auto loop
*/
