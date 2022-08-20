    
    // fill the dp matrix with -1
    private static int unboundedTopDown(int[] vls,int[] wt,int cap,int start,int[][] dp)
    {
        if(cap < 0)
            return 0;

        if(start == vls.length)
            return 0;

        if(dp[start][cap] != -1)
            return dp[start][cap];

        int item_wt = wt[start];

        int ans = 0;

        for(int i = 1; i *item_wt <= cap ;i++)
        {
            ans = Math.max(ans,unboundedTopDown(vls,wt,cap-i*item_wt,start+1,dp)+i*vls[start]);
        }

        ans = Math.max(ans,unboundedTopDown(vls,wt,cap,start+1,dp));


        return dp[start][cap] = ans;
    }
