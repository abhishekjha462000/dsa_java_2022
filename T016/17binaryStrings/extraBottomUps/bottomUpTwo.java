    
    // This is same as the previous approach just that we have combined the zeroes and ones array in a single dp matrix
    private static int bottomUp(int n)
    {
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        if(n == 2)
            return 3;

        int[][] dp = new int[2][n+1];

        // dp[0][j] = number of binary strings of length j without consecutive zeroes which end at 0
        // dp[1][j] = number of binary strings of length j without consecutive zeroes which end at 1

        dp[0][1] = 1; // Since the number of binary strings of length 1 without consecutive zeroes which end at 0
        dp[1][1] = 1; // Since the number of binary strings of length 1 without consecutive zeroes which end at 1

        for(int i = 2; i <= n ; i++)
        {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = dp[0][i-1]+dp[1][i-1];
        }

        return dp[0][n]+dp[1][n];
    }
