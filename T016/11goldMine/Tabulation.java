    private static int maxGoldTD(int[][] goldMine)
    {

        /**
         * Find the dimensions of goldMine
         **/

        int nr = goldMine.length;
        int nc = goldMine[0].length;

        int ans = Integer.MIN_VALUE;

        int[][] dp = new int[nr][nc];

        for(int[] x : dp)
        {
            Arrays.fill(x,-1);
        }


        for(int row = 0, col = 0; row < goldMine.length; row++)
        {
            ans = Math.max(ans,helperTD(goldMine,row,col,dp));
        }

        return ans;
    }
    
    
    
    private static int helperTD(int[][] goldMine,int row,int col,int[][] dp)
    {
        if(col == goldMine[0].length-1)
        {
            return goldMine[row][col];
        }

        if(dp[row][col] != -1)
        {
            return dp[row][col];
        }

        int ans = goldMine[row][col];

        int rres = Integer.MIN_VALUE;

        if(row-1 >= 0)
        {
            rres = Math.max(rres,helperTD(goldMine,row-1,col+1,dp));
        }

        if(row+1 < goldMine.length)
        {
            rres = Math.max(rres,helperTD(goldMine,row+1,col+1,dp));
        }

        rres = Math.max(rres,helperTD(goldMine,row,col+1,dp));

        ans += rres;

        return dp[row][col] = ans;
    }
