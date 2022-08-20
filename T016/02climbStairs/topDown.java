    private static int climbTopDown(int n,int[] dp)
    {
        // dp[i] means number of ways to go from 0 to ith stair
        if(n < 0)
            return 0;
        if(n == 0)
            return 1; // No need to store it in dp[n] (why?)
        // The reason is this line is above the line which checks if dp[n] is 0 or not. So even if we store it in dp[0] we are still not going to use it.
        
        if(dp[n] != 0)
            return dp[n];
            
        return dp[n] = climbTopDown(n-1,dp)+climbTopDown(n-2,dp)+climbTopDown(n-3,dp);
    }
