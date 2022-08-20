    private static int maxGoldBUTwo(int[][] goldMine)
    {
        int nr = goldMine.length;
        int nc = goldMine[0].length;

        int[][] dp = new int[nr][nc];

        /**
         * dp[i][j] would store the max gold collected till (i,j)
         * 
         * then dp[row][0] would be goldMine[row][0]
         **/



        // In this approach fill the dp matrix columnwise
        for(int j = 0;j < nc;j++)
        {
            for(int i = 0;i < nr;i++)
            {
                // dp[i][j] would be goldMine[i][j] + max(dp[i-1][j-1],dp[i][j-1],dp[i+1][j-1])

                dp[i][j] = goldMine[i][j];

                if(j-1 >= 0)
                {
                    int one = (i-1 >= 0) ? dp[i-1][j-1]:(0);
                    int two = (i+1 < nr) ? dp[i+1][j-1]:(0);
                    int three = dp[i][j-1];

                    int ans = Math.max(one,Math.max(two,three));

                    dp[i][j] += ans;
                }
            }
        }

        // Since our motive was to reach at the last column


        System.out.println();
        for(int i=0;i <nr ;i++)
        {
            for(int j = 0 ; j <nc ;j++)
            {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
        
        System.out.println();

        int ans = Integer.MIN_VALUE;

        for(int row = 0, col = nc-1 ; row < nr ; row++)
        {
            ans = Math.max(ans,dp[row][col]);
        }

        return ans;
    }
