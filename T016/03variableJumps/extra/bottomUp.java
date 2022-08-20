    private static ArrayList<String> bottomUp(int[] nums)
    {
        ArrayList<String>[] dp = new ArrayList[nums.length+1];

        int N = nums.length;

        for(int i = 0;i <dp.length ;i++)
        {
            dp[i] = new ArrayList<>();
        }


        dp[N].add("N");

        // dp[i] = ArrayList of paths from i to "N"

        for(int i = N-1; i >= 0;i--)
        {
            if(nums[i] == 0)
                continue;

            // when nums[i] is not 0
            int maxJumps = nums[i];

            for(int steps = 1; steps <= maxJumps;steps++)
            {
                int curr = i + steps;

                if(curr > N)
                    break;

                if(dp[curr].size() != 0)
                {
                    for(String s : dp[curr])
                    {
                        dp[i].add(i+" "+s);
                    }
                }
            }
        }


        // final answer would be in dp[0]

        return dp[0];
    }
