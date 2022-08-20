    private static int maxGoldBU(int[][] goldMine)
    {
        int nr = goldMine.length;

        int nc = goldMine[0].length;

        int[][] dp = new int[nr][nc];

        // dp[i][j] would mean the max gold collected starting from (i,j)

        // we would need to find max(dp[0][0],dp[1][0],...,dp[last_row][0])

        // The smaller problem would be at dp[lst_row][last_col]

        for(int col = nc-1; col >= 0 ;col--)
        {
            for(int row = nr-1; row >= 0;row--)
            {
                // we need three values dp[row+1][col+1],dp[row][col+1],dp[row-1][col+1]
                dp[row][col] = goldMine[row][col];

                if(col + 1 != nc)
                {
                    int one = (row+1 < nr) ? (dp[row+1][col+1]) : (0);
                    int two = (row-1 >= 0)? (dp[row-1][col+1]) : (0);
                    int three = dp[row][col+1];

                    int ans = Math.max(one,Math.max(two,three));

                    dp[row][col] += ans;
                }
            }
        }


        int ans = Integer.MIN_VALUE;

        for(int row = 0,col = 0; row < goldMine.length ; row++)
        {
            ans = Math.max(ans,dp[row][col]);
        }

        return ans;
    }
