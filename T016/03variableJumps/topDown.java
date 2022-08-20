    private static int climbVJTD(int[] nums)
    {
        int N = nums.length;
        int[] dp = new int[N+1];
        Arrays.fill(dp,-1);

        // dp[i] will store the number of ways to go from i till N.
        // dp[N] = 1
        dp[N] = 1;
      
        climbVJTDHelper(nums,0,dp);

        return dp[0]; // This would return the number of ways to go from 0 to Nth stair
    }



    private static int climbVJTDHelper(int[] nums,int start,int[] dp)
    {
        int N = nums.length;
        if(start > N)
        {
            return 0;
        }
        if(start == N)
            return 1;

        if(nums[start] == 0)
            return 0;
      
        if(dp[start] != -1)
            return dp[start];

        int ans = 0;

        for(int steps = 1; steps <= nums[start] ; steps++)
        {
            int currFloor = start+steps;
          
            if(currFloor > N) // This is not necessary but still this has been done to optimize.
              break;

            ans += climbVJTDHelper(nums,currFloor,dp); // No of ways to move from currFloor till N
        }
      
        return dp[start] = ans;
    }
