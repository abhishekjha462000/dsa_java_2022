    private static int minJumpsTD(int[] nums,int start)
    {
        int N = nums.length;
        int[] dp = new int[N+1];

        // dp[i] would mean the # of ways to go from ith step to Nth step

        Arrays.fill(Integer.MAX_VALUE);

        dp[N] = 0;

        return minJumpsTDHelper(nums,start,dp);
    }

    private static int minJumpsTDHelper(int[] nums,int start,int[] dp)
    {
        int N = nums.length;

        if(start > N)
            return Integer.MAX_VALUE;

        if(start == N)
            return 0;

        if(nums[start] == 0)
            return Integer.MAX_VALUE;

        if(dp[start] != Integer.MAX_VALUE)
            return dp[start];


        for(int steps = 1; steps <= nums[start];steps++)
        {
            int currStep = start+steps;
            dp[start] = Math.min(dp[start],minJumpsTDHelper(nums,currStep,dp));
        }
         
        // Think about this vvvimp
        if(dp[start] != Integer.MAX_VALUE)
            return ++dp[start];
        return dp[start];
    }
