    // O(n^2) approach, space complexity - O(1)
  
    private static int bruteForce(int[] nums)
    {
        int optimalProfit = Integer.MIN_VALUE;


        for(int i = 0 ;i < nums.length;i++)
        {
            // buy on ith day
            for(int j = i + 1 ; j < nums.length; j++)
            {
                // sell on jth day
                int profitEarned = nums[j]-nums[i];

                optimalProfit = Math.max(optimalProfit,profitEarned);
            }
        }

        return optimalProfit;
    }
