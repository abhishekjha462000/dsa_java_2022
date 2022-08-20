    private static int climbBottomUp(int n)
    {
        // In bottom up approach we first solve the smaller problem and then form the solutions of the bigger problems.
        int[] dp = new int[n+1];

        // dp[i] denotes the number of ways to move from 0th stair to ith stair by taking 1, 2, or 3 steps.
        // so the smaller problem would be dp[0].
        
        // Since the smaller problem is at the index 0 so we will move from the 0th index to the last index.

        dp[0] = 1; // As the # of ways to go from 0-->0 is 1

        for(int i = 1; i <= n;i++)
        {
            int op1 = (i-1 >= 0) ? (dp[i-1]):(0);
            int op2 = (i-2 >= 0) ? (dp[i-2]):(0);
            int op3 = (i-3 >= 0) ? (dp[i-3]):(0);

            dp[i] = op1 + op2 + op3;
        }

        return dp[n]; // dp[n] = # of ways to go from 0-->n
    }
