    private static int topDown(int n,int m,int[] dp)
    {
        if(n < m)
            return 1;

        if(n == m)
            return 2;

        if(dp[n] != -1)
            return dp[n];
        
        int ans = 0;

        ans += topDown(n-1,m,dp);

        if(n >= m)
        ans += topDown(n-m,m,dp);

        return dp[n] = ans;
    }
