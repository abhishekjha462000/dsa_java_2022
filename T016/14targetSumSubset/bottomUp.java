    private static boolean bottomUp(int[] coins,int target)
    {
        boolean[][] dp = new boolean[coins.length][target+1];

        // dp[i][j] = is it possible to pay j rupees using coins till i index
        for(int i = 0; i < dp.length;i++) // i -- coin index
        {
            for(int j = 0; j <= target;j++) // j -- target
            {
                if(j == 0){ // if target is 0, then there is always a way -- pay nothing
                    dp[i][j] = true;
                }else if(i == 0){ // we are talking about the first coin here
                    dp[i][j] = (coins[0] == j) ? (true) : (false);
                }else{

                    /**
                     * We have coins till iₜₕ index, that is c₀,...,cᵢ and we need to answer if it is possible to pay j rupees using this
                     * So first exclude the iₜₕ coin and see if it is possible to pay using remaining c₀,...,cᵢ₋₁ coins, this would be found in dp[i-1][j].
                     * If this happens to be true, then dp[i][j] = true and we do not need to calculate further
                     **/
                    
                    dp[i][j] = dp[i-1][j];

                    if(dp[i][j] == false)
                    {
                        /**
                         * Since dp[i-1][j] has come to be false, let us just check when we include the iₜₕ coin, then the remaining amount to be paid is j-coins[i]
                         * if it is possible to pay the remaining amount using the remaining coins, then dp[i][j] = true, otherwise false;
                         **/

                        dp[i][j] = dp[i][j] || (j - coins[i] >= 0 ? (dp[i-1][j-coins[i]]) : (false));
                    }
                }
            }

            if(dp[i][target])
                return true;
        }

        return false;
    }
