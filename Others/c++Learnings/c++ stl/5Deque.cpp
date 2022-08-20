#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;
ostream& operator<<(ostream& os, const deque<int>& d){
	if(d.empty())
		return os << "[]";
	os << "[ ";
	for(int i = 0;i<d.size();i++){
		os << d[i] << " ";
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
	// deque is probably the best stl(IMO)
	deque<int> d;
	for(int i = 0;i<5;i++){
		d.push_back(i+1);
	}
	cout << d << endl;
	for(int i=0;i<5;i++){
		d.push_front(i+1);
	}
	cout << d << endl;
	d.emplace_back(-1);
	d.emplace_front(-1);
	cout << d << endl;

	cout << d.front() << endl;
	cout << d.back() << endl;

	cout << d << endl;
	d.front() = -90; // actually it returns a reference
	d.back() = -90; // this also
	cout << d << endl;

	cout << d.size() << endl;
	cout << d[4] << endl;
	cout << d.at(5) << endl;

	d.at(5) = -8; // they also return references
	d[4] = -45; // this also
	cout << d << endl;


	// HOW TO CLEAR THE DEQUE

	d.clear();

	cout << d << "--->" << d.size() << (d.empty()?" true":" false") << endl;


	// SWAPPING IN QUEUES

	deque<int> d1;
	deque<int> d2;
	for(int i=0;i<20;i++){
		if(i<10)
			d1.push_back(i+1);
		else
			d2.push_back(i+1);
	}

	cout << "BEFORE SWAPPING..." << endl;
	cout << "d1: "<< d1 << endl;
	cout << "d2: "<< d2 << endl;

// 
	//d1.swap(d2);
	swap(d1,d2); // implicitly calls d1.swap(d2)
	cout << "AFTER SWAPPING..." << endl;
	cout << "d1: "<< d1 << endl;
	cout << "d2: "<< d2 << endl;


	// REVERSE IN DEQUES

	reverse(d1.begin(),d1.end()); // for this #include <algorithm>
	cout << d1 << endl;


	// SORTING IN DEQUES
	sort(d1.begin(),d1.end()); // for this #include <algorithm> 
	cout << d1 << endl;


	// RANGE BASED ALSO WORK BECAUSE THEY HAVE ITERATORS
	deque<int>:: iterator it = d1.begin();
	while(it!=d1.end()){
		cout << *it <<" ";
		it = it + 1;
	}
	cout << endl;
	// auto loop
	for(const auto& x:d1){
		cout << x << " ";
	}
	cout << endl;
	return 0;
}
