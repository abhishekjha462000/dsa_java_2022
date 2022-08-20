    private static int prefixArray(int[] nums)
    {
        int[] prefix = new int[nums.length];


        prefix[0] = nums[0];

        for(int i = 1 ; i < nums.length; i++)
        {
            prefix[i] = Math.min(prefix[i-1],nums[i]);
        }

        int optimalProfit = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length;i++)
        {
            if(optimalProfit < nums[i]-prefix[i])
                optimalProfit = nums[i]-prefix[i];
        }

        return optimalProfit;
    } 
