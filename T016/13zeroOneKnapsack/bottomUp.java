    private static int bottomUp(int[] wt,int[] vls,int cap)
    {
        int N = wt.length;

        int[][] dp = new int[N][cap+1];

        // row denotes the items and columns denote the capacity

        // dp[i][j] = max value that can be achieved with a bag of capacity j and using items till only iₜₕ index

        for(int i = 0;i < N;i++) // i stands for row -- item
        {
            for(int j = 0;j <= cap ; j++) // j stands for column -- capacity
            {
                if(j == 0) //  This means that capacity is zero
                {
                    dp[i][j] = 0;
                }else if(i == 0){
                    // we are at the first item, if this item can be put into the bag with capacity j then our answer would be vls[i] otherwise the answer would be 0

                    dp[i][j] = (wt[i] <= j) ? (vls[i]) : (0);
                }else{
                    // we want to find the max value that can be acheived using W₀,...,Wᵢ and capacity j

                    // exclude the iₜₕ item, then ans = dp[i-1][j]

                    int one = dp[i-1][j]; 

                    // include the iₜₕ item, then remaining cap = j - Wᵢ and then problem reduces to dp[i-1][j-Wᵢ]

                    int two = (j-wt[i] >= 0) ? (dp[i-1][j-wt[i]]+vls[i]) : (0);

                    
                    /**
                     * I initially wrote 
                     * 
                     * int two = (j-wt[i] >= 0) ? (dp[i-1][j-wt[i]]) : (0);
                     * dp[i][j] = Math.max(one, two + vls[i]);
                     * 
                     * 
                     * This was wrong as when wt[i] > j then also we are including vls[i] in calculation which is clearly wrong
                     **/
                    dp[i][j] = Math.max(one,two);
                    
                }
            }
        }

        return dp[N-1][cap];
    }
