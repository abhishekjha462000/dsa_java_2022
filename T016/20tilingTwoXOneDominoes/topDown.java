  private static int topDown(int n,int[] dp){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = topDown(n-1,dp) + topDown(n-2,dp);
    }
