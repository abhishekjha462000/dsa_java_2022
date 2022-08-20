    private static int minJumpsBU(int[] nums)
    {
        int N = nums.length;

        int[] dp = new int[N+1];

        // dp[i] would store the number of ways to go from i to N

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[N] = 0;

        // We need the answer for dp[0]

        for(int i = N-1; i >= 0;i--)
        {
            int maxJumps = nums[i];

            if(maxJumps != 0)
            {
                for(int steps = 1; steps <= maxJumps;steps++)
                {
                    int currStep = i + steps; 
                    if(currStep <= N)
                        dp[i] = Math.min(dp[i],dp[currStep]);
                }
                
                // Think about this vvimp
                if(dp[i] != Integer.MAX_VALUE)
                    ++dp[i];
            }

        }
        return dp[0];
    }
