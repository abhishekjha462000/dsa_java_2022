// #include <iostream>
#include <bits/stdc++.h>
// #include <string>
// #include <string.h>
#include <cstring>
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)
using namespace std;
void init_code(){
	fast_io;
	#ifndef	ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
	#endif
}
int main(){
	init_code();
	string s;
	string part ;
	cin >> s;
	cin >> part;
	vector<pair<int,int>> v;
	int j = 0;
	for(int i=0;i<s.length();i++){
		if(part[j]==s[i]){
			j++;
		}else{
			j=0;
			if(part[j]==s[i])
				j++;
		}
		if(j == part.length()){
			v.push_back(make_pair(i-part.length()+1,i));
			j=0;
		}
	}
	// for(auto x : v){
	// 	cout << x.first << "--->" << x.second << endl;
	// }
	string ans = "";
	int jj = 0;
	for(int i =0;i<s.length();i++){
		if(i>=v[jj].first && i<v[jj].second)
			continue;
		if(i == v[jj].second){
			jj++;
			continue;
		}

		ans += s[i];
	}

	cout << ans << endl;
	return 0;
}
