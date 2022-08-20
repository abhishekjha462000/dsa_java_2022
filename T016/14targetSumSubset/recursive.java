    private static boolean isTargetPossible(int[] coins,int target,int start)
    {
        if(target < 0)
            return false;
        if(start == coins.length)
        {
            if(target == 0)
                return true;
            return false;
        }

        // exclude the coin

        boolean rresOne = isTargetPossible(coins,target,start+1);

        if(rresOne)
            return true;
        // Include the coin

        boolean rresTwo = isTargetPossible(coins,target-coins[start],start+1);

        if(rresTwo)
            return true;

        return false;
    }
