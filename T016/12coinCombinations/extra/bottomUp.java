    @SuppressWarnings("unchecked")
    private static ArrayList<String> printCoinCombinations(int[] coins,int target)
    {
        ArrayList<String>[] dp = new ArrayList[target+1];


        for(int i = 0 ; i < dp.length ; i++)
        {
            dp[i] = new ArrayList<>();
        }


        dp[0].add(""); // shows that there is only one way for target = 0


        for(int coin : coins)
        {
            for(int amt = coin ; amt <= target ;amt++)
            {
                if(dp[amt-coin].size() != 0)
                {
                    for(String s : dp[amt-coin])
                    {
                        dp[amt].add(s+coin);
                    }
                }
            }
        }

        return dp[target];
    }
