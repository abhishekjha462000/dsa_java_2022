    private static int coinsSumCombination(int[] coins,int target)
    {
        int N = target;

        int[] dp = new int[N+1];

        dp[0] = 1;


        for(int coin : coins)
        {
            for(int amt = coin ; amt <= N ; amt++) 
            {
                dp[amt] += dp[amt-coin];
            }

        }

        return dp[N];
    }
