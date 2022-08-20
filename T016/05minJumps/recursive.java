    // start = 0
    private static int minJumps(int[] nums,int start)
    {
        int N = nums.length;

        if(start > N)
            return Integer.MAX_VALUE;

        if(start == N)
            return 0;

        if(nums[start] == 0)
            return Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;

        for(int steps = 1; steps <= nums[start]; steps++)
        {
            int currStep = start+steps;

            ans =  Math.min(ans,minJumps(nums,currStep));
        }

        
        // This last step is very important
        if(ans != Integer.MAX_VALUE)
            return ans + 1;
        return ans;

    }
