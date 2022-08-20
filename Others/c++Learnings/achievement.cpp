#include <iostream>
#include <vector>
#include <queue>
using namespace std;

// did hasCycle raat ke 4:20 pr (f*** logic ^^")

ostream& operator<<(ostream& os, const vector<int>& v)
{
	if(v.empty())
		return os << "[]";

	os << "[ ";

	for(const auto& x : v)
	{
		os << x << " ";
	}

	return os << "]";
}
vector<int> bfs(vector<int> adj[],int n)
{

	bool visited[n+1]{false};
	vector<int> ans;

	for(int i=1;i<=n;i++)
	{
		if(!visited[i])
		{
			queue<int> q;
			q.push(i);
			visited[i] = true;

			while(!q.empty())
			{
				int removed = q.front();

				q.pop();
				ans.push_back(removed);

				for(int neighbour : adj[removed])
				{
					if(!visited[neighbour])
					{
						q.push(neighbour);
						visited[neighbour] = true;
					}
				}
			}
		}
	}
	return ans;
}

void dfs_helper(vector<int>& ans,vector<int>* adj,int n,bool* visited,int i)
{
	visited[i] = true;

	ans.push_back(i);

	for(int neighbour : adj[i])
	{
		if(!visited[neighbour])
		{
			dfs_helper(ans,adj,n,visited,neighbour);
		}
	}
}
vector<int> dfs(vector<int> adj[],int n)
{
	vector<int> ans ;
	bool visited[n+1]{false};
	for(int i = 1;i<=n;i++)
	{
		if(!visited[i])
		{
			dfs_helper(ans,adj,n,visited,i);
			ans.push_back(-1);

		}

	}
	return ans;
}

bool hasCycleHelper(vector<int>* adj,int n ,vector<int>& vis,int start,int end)
{
	// if there is a cycle from start to end 
	vis[end] = 1;
	for(int neighbour : adj[end]){
		if(vis[neighbour] == 1 && neighbour != start)
			return true;
		if(vis[neighbour] == 1 && neighbour == start)
			continue;

		if(vis[neighbour] == 0 && neighbour != start)
			return hasCycleHelper(adj,n,vis,end,neighbour);
	}
	return false;
}


void reset(vector<int>& vis)
{
	for(auto& x : vis)
	{
		x = false;
	}
}
bool hasCycle(vector<int>* adj,int n)
{
	vector<int> vis(n+1,0);
	for(int start=1;start<=n;start++)
	{
		if(!vis[start])
		{
			bool smallAns;
			vis[start] = 1;
			for(int end : adj[start])
			{
				cout << start << "   " << end << endl;
				reset(vis);
				smallAns = hasCycleHelper(adj,n,vis,start,end);
			}
			if(!smallAns)
				cout << "Did not get cycle..." << endl;
			if(smallAns == true)
				return true;

		}
	}
	return false;
}



int main()
{
	#ifndef ONLINE_JUDGE
			freopen("input.txt","r",stdin);
			freopen("output.txt","w",stdout);
			freopen("error.txt","w",stderr);
	#endif
	int n,m;
	cin >> n >> m;

	vector<int> adj[n+1]; // assuming 1 based indexing in graph
	while(m-- != 0)
	{
		int src,des;
		cin >> src >> des;

		adj[src].push_back(des);
		adj[des].push_back(src);
	}

	// for(int i=1;i<=n;i++)
	// {
	// 	if(adj[i].empty()) continue;

	// 	cout << i << " --> " << adj[i] << endl;
	// }

	// vector<int> ans = bfs(adj,n);

	// cout << ans << endl;

	// vector<int> ans = dfs(adj,n);

	// cout << ans << endl;

	if(hasCycle(adj,n))
	{
		cout << "cycle detected..." << endl;
	}else
	{
		cout << "No cycle..." << endl;
	}
	return 0;
} 
