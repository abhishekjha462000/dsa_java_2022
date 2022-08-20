    private static int coinsSumCombinationRecursive(int[] coins,int target,int start)
    {

        // diff between these two...

        // this is correct too ...
        // if(target == 0 )
        //     return 1;
        // if(start == coins.length)
        // {
        //     return 0;
        // }

        

       
        if(start == coins.length)
        {
            if(target == 0 )
                return 1;
            return 0;
        }
        int coin = coins[start];


        int ans = 0;


        for(int number  = 1; number * coin <= target;number++)
        {
            ans += coinsSumCombinationRecursive(coins,target-(number)*coin,start+1);
        }

        ans += coinsSumCombinationRecursive(coins,target,start+1); // when you do not take the coin

        return ans;
    }
