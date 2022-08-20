#include <iostream>
#include <string>
#include <array>
#include <vector>
#include <utility>
#include <stack>
#include <queue>
#include <deque>
#include <list>
#include <map>
#include <unordered_map>
#include <set>
#include <unordered_set>
#include <climits>
using namespace std;

#define io ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL)

#define umap unordered_map
#define uset unordered_set
#define debug(x) cout << #x << " is " << x << endl;

using ll = long long;
using vi = vector<int>;
using vvi = vector<vi >;
using vii = vector<pair<int,int> >;
using pii = pair<int,int>;
using pll = pair<ll,ll>;
using maxheap = priority_queue<int,vi >;
using minheap = priority_queue<int, vi, greater<int> >;
using graph = vvi;


string longest_substring_no_duplicates(string& str)
{
	if(str.size() == 0 || str.size() == 1)
	{
		return str;
	}

	umap<char,pair<int,int> > prev;

	umap<char,pair<int,int> > curr;

	int idx = 0;

	curr.insert({str[0],pair<int,int>(1,idx)});
	idx++;

	for(int i=0;i<str.size();i++)
	{
		char c = str[i];

		auto it = curr.find(c);

		if(it != curr.end())
		{
			if(prev.size() > curr.size())
			{
				umap<char,pair<int,int> > curr2;

				int index = curr[c].second;

				int idx = 0;

				// char temp[257] = {' '};

				array<char,257> temp;
				temp.fill(' ');
				for(const auto& x : curr)
				{
					// temp[idx] = ch
					char ch = x.first;

					int idx = x.second.second;

					temp[idx] = ch;
				}

				int k = 0;

				for(int j=index + 1;j < 257;j++)
				{
					if(temp[j] != ' ')
					{
						curr2[temp[j]] = pair<int,int>(1,k);
						k++;
					}
				}

				// curr2[c] = pair<int,int>(1,k);
				// curr2.emplace(c,/)// doubt
				curr.swap(curr2);
				idx = k + 1;

			}else{
				prev.swap(curr);

				curr.clear();

				int index = prev[c].second;

				idx = 0;

				// char temp[257] = {' '};
				array<char,257> temp;
				temp.fill(' ');

				for(const auto& x : prev)
				{
					int idx = x.second.second;
					char ch = x.first;

					temp[idx] = ch;
				}

				int k = 0;

				for(int j = index + 1; j < 257;j++)
				{
					if(temp[j] != ' ')
					{
						curr[temp[j]] = pair<int,int>(1,k);
						k++;
					}
				}
				curr[c] = pair<int,int>(1,k);
				idx = k + 1;
			}
		}else{
			curr.insert({c,pair<int,int>(1,idx)});
			idx++;
		}
	}

	if(prev.size() < curr.size())
	{
		prev.swap(curr);
		curr.clear();
	}

	string ans(prev.size(),'a');

	for(const auto& x : prev)
	{
		int index = x.second.second;

		char ch = x.first;

		ans[index] = ch;

	}

	// cout << ans;

	return ans;
}

signed main()
{
	#ifndef ONLINE_JUDGE
		freopen("input.txt","r",stdin);
		freopen("output.txt","w",stdout);
		freopen("error.txt","w",stderr);
	#endif
	io;

	string str;

	getline(cin,str);

	cout << longest_substring_no_duplicates(str) << endl;

	return 0;
}
