    private static int setBits(int n)
    {
        int[] dp = new int[n+1];
        // dp[i] = # of set bits in i
      
        dp[0] = 0;
      
        for(int i = 1;i <= n;i++)
        {
            dp[i] = dp[i/2] + (i & 1);
        }

        return dp[n];
    }
