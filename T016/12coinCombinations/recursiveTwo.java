    private static int recursiveWayTwo(int[] coins,int target,int idx)
    {

        if(target == 0)
            return 1;
        
        if(idx == coins.length)
            return 0;

        int ans = 0;

        // include the element at index idx

        if(idx < coins.length)
        {   if(target-coins[idx] >= 0)
                ans += recursiveWayTwo(coins,target-coins[idx],idx);
        }
        ans += recursiveWayTwo(coins,target,idx+1);

        return ans;
    } 
