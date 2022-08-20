    private static int climbVJBottomUp(int[] nums)
    {
        int N = nums.length;

        int[] dp = new int[N+1];

        dp[N] = 1;

        for(int i = N-1;i >= 0;i--)
        {
            int maxSteps = nums[i]; // Max no of steps that we can take from i

            for(int steps = 1; steps <= maxSteps; steps++)
            {
                int currFloor = i + steps;

                if(currFloor > N)
                    break;

                dp[i] += dp[currFloor];
            }
        }

        return dp[0];
    }
