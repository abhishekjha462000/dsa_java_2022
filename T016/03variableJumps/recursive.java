    private static int climbVJ(int[] nums)
    {
        int start = 0;

        return climbVJHelper(nums,start);
    }

    private static int climbVJHelper(int[] nums,int start)
    {
        int N = nums.length;

        // I want to reach from 0 to Nth stair

        if(start > N)
            return 0;

        if(start == N)
            return 1;

        if(nums[start] == 0)
            return 0; // This is dead floor

        int ans = 0;
        for(int steps = 1; steps <= nums[start] ; steps++)
        {
            int currFloor = start+steps;
          
            if(currFloor > N) // This is not necessary but still this has been done to optimize.
              break;

            ans += climbVJHelper(nums,currFloor); // No of ways to move from currFloor till N
        }

        return ans;
    }
