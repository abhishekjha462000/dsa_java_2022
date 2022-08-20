#include <bits/stdc++.h>
using namespace std;

int minCoins(vector<int>& v,int target)
{
    if(target < 0)
    {
        return INT_MAX;
    }
    
    if(target == 0)
    {
        return 0;
    }
    
    int ans = INT_MAX;
    for(const auto& x : v)
    {
        ans = ::min(ans,minCoins(v,target-x));
    }
    
    return ans + 1;
    
}

int minCoinsTD(vector<int>& v,int target,vector<int>& dp)
{
    if(target < 0)
    {
        return INT_MAX;
    }
    
    if(target == 0)
    {
        return 0;
    }
    
    // cout << dp[target] << endl;
    
    if(dp[target] != INT_MAX)
    {
        return dp[target];
    }
    
    int ans = INT_MAX;
    
    for(const auto& x : v)
    {
        ans = ::min(ans,minCoinsTD(v,target-x,dp));
    }
    
    return dp[target] = ans+1;
}

int minCoinsBU(vector<int>& v,int target)
{
    vector<int> dp(target + 1,INT_MAX);
    
    // dp[0] is the starting point 
    
    dp[0] = 0;
    
    for(int i = 1;i < dp.size();i++)
    {
        // we need to calculate dp[i] which is 
        // int ans = INT_MAX;
        for(const auto& x : v)
        {
            int val = i - x;
            
            if(val >= 0)
                dp[i] = ::min(dp[i],dp[val]);
        }
        
        dp[i]++;
    }
    
    // for(const auto& x : dp)
    // {
    //     cout << x << " ";
    // }
    
    return dp[target];
}
int main()
{
    int n;
    cin>>n;
    
    vector<int> v(n);
    for(int i=0;i<n;i++)
    {
        cin>>v[i];
    }
    
    int target;
    cin>>target;
    
//     cout << minCoins(v,target) << endl;
    
    vector<int> dp(target+1,INT_MAX);
    
    cout << minCoinsTD(v,target,dp) << endl;
    cout << minCoinsBU(v,target) << endl;
    return 0;
}
