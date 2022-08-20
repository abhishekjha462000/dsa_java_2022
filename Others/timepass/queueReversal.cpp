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
void reverse(queue<int>& q){
	if(q.size()<=1)
		return ;

	int val = q.front();
	q.pop();
	reverse(q);
	q.push(val);
}
int main(){
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
	#endif
	queue<int> q;
	for(int i = 0;i<5;i++){
		q.push(i);
	}
	cout << q << endl;
	reverse(q);
	cout << q << endl;

	return 0;
}
