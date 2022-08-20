// https://stackoverflow.com/questions/8400735/why-doesnt-stdsort-doesnt-work-on-stdlist
// Above link shows why sort(l1.begin(),l1.end()) does not work in case of list
#include <iostream>
#include <list>
#include <algorithm>
using namespace std;
ostream& operator<<(ostream& os, const list<int>& l){
	if(l.empty()) // tells whether list is empty or not
		return os <<"[]";
	os << "[ ";
	auto it = l.begin();
	while(it!=l.end())
	{
		os << *it << " ";
		++it;
	}
	return os << "]";
}
int main(){
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif

	// In C++, we have two types of list
	// 1.forward_list(singly linked list)
	// 2.list(doubly linked list)

	list<int> l;
	for(int i = 0;i<10;i++){
		if(i<5)
			l.push_back(i+1);
		else
			l.emplace_back(i+1);
	}

	cout << l << endl;

	for(int i = 11;i<14;i++){
		if(i==11){
			l.push_front(i);
		}
		else{
			l.emplace_front(i);
		}
	}
	cout << l << endl;

	for(int i = 0;i<3;i++){
		l.pop_back();
	}
	cout << l << endl;
	for(int i =0;i<3;i++){
		l.pop_front();
	}
	cout << l << endl;
	cout << l.size() << endl;

	// l.at(3) and l[4] not allowed as list do not have indexing

	cout << l.front() << endl;
	cout << l.back() << endl;

	l.front() = -8; // They return the references(they are lvalues)
	l.back() = -4;

	cout << l << endl;

	//CLEARING THE LIST

	l.clear();
	cout << l << endl;

	//SWAPPING THE LIST
	list<int> l1;
	list<int> l2;

	for(int i=0;i<10;i++){
		if(i<5){
			l1.push_back(i+1);
		}else{
			l2.push_back(i+1);
		}
	}
	cout << "BEFORE SWAPPING : " << endl;
	cout << "l1 : " << l1 << endl;
	cout << "l2 : " << l2 << endl;

	l1.swap(l2);
	// swap(l1,l2); // implicitly calls l1.swap(l2)

	cout << "AFTER SWAPPING : " << endl;
	cout << "l1 : " << l1 << endl;
	cout << "l2 : " << l2 << endl;

	// REVERSING A LIST
	// l1.reverse(); // implicitly calls reverse(l1.begin(),l1.end())
	reverse(l1.begin(),l1.end()); // for this include <algorithm>
	cout << l1 << endl;

	// SORTING A LIST
	// sort(l1.begin(),l1.end()); // does not work
	l1.sort();
	cout << l1 << endl;

	//ITERATING OVER A LIST

	for(const auto& x:l1)
		cout << x << " ";
	cout << endl;
	return 0;
}
