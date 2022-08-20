    private static int binaryStringsTopDown(int n,int[] dp)
    {
        if(n == 0)
            return 0;

        if(n == 1)
            return 2;

        if(n == 2)
            return 3;

        if(dp[n] != -1)
            return dp[n];

        return dp[n] = binaryStringsTopDown(n-1,dp)+binaryStringsTopDown(n-2,dp);

    }
