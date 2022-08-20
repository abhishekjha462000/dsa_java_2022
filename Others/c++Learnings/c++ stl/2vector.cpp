#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
#define vi vector<int>
#define all(x) x.begin(), x.end()
#define pb push_back
using namespace std;
ostream& operator<<(ostream& os, const vi& v){
	if(v.size() == 0)
		return os << "[]";
	os << "[ ";
	for(auto& x:v){
		os << x << " ";
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
	vi v(5,-1);
	cout << v << endl;
	for(int i = 0;i<5;i++){
		v.pb(i+1);
	}
	cout << v << endl;
	v.front() = -90;
	v.back() = -89;
	cout << v << endl;
	// v.clear();
	// cout << v << endl;
	for(int i = 0;i<5;i++){
		v.pop_back();
	}
	cout << v << endl;
	v[2] = -890;
	v.at(3) = -678;
	cout << v << endl;
	for(auto& x:v){
		if(x < 0 ){
			x = 0;
		}
	}
	cout << v << endl;
	for(int i=0;i<3;i++){
		v.emplace_back(i+3);
	}
	cout << v << endl;
	// v.erase();// do not use because you dont know how to use this
	if(v.empty())
		cout << "Vector is empty..." << endl;
	else{
		cout << "Vector is not empty..." << endl;
	}
	vector<int>::iterator start = v.begin();
	auto end = --v.end();
	while(start <= end){
		swap(*start,*end);
		start++;
		end--;
	}
	cout << v << endl;
	// sort(v.begin(),v.end());
	sort(all(v)); // # include <algorithm> is a must
	cout << v << endl;
	v = {};
	cout << v << endl;// cleared the vector
	
	for(int i = 0;i<11;i++){
		v.pb(i+1);
	}
	cout << v.size() << endl;
	cout << v.capacity() << endl;
	cout << v << endl;
	v.shrink_to_fit(); // makes capacity == size
	cout << v.capacity() << endl;

	return 0;
}
