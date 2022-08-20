#include <iostream>
#include <bits/stdc++.h>
#include <utility>
#define pi pair<int,int>
using namespace std;
ostream& operator<<(ostream& os,const pair<int,int>& p){
	return os << "{" << p.first << ", " << p.second << "}";
}
istream& operator>>(istream& is,pair<int,int>& p){// don't declare pair as const here
	is >> p.first >> p.second;
	return is;
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	pair<int,int> p;
	p = make_pair(1,2);
	cout << p << endl;
	p = {34,56};
	cout << p << endl;
	pair<int,int> p2;
	p2 = {78,-90};
	p2.swap(p);
	cout << "p after swap: " << p << endl;
	cout << "p2 after swap: " << p2 << endl;

	pair<int,int> p3;
	cin >> p3;
	cout << p3 << endl;
	return 0;
}
