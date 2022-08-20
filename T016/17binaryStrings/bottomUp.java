    private static int bottomUp(int n)
    {
        int[] dp = new int[n+1]; // last index n

        dp[0] = 0;
        
        if(1 <= n)
            dp[1] = 2;

        if(2 <= n)
            dp[2] = 3;

        for(int i = 3 ; i <= n ; i++)
        {
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];

    }
  
