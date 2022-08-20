    private static int maxGold(int[][] goldMine)
    {

        int nr = goldMine.length; // number of rows in goldMine
        int nc = goldMine[0].length; // number of columns in goldMine

        int ans = Integer.MIN_VALUE;

        /**start from every point in the 0th column
         * and find the max gold coins that could be collected starting from that point
         * Take the maximum of all of these. That would be our maximum.
         **/

        for(int row =  0 ,col = 0 ; row < nr; row++)
        {
            /**
             * `helper(goldMine,row,col)` would return the max gold coins collected starting from the position (row,col)
             **/
            ans = Math.max(helper(goldMine,row,col),ans);
        }

        return ans;
    }

    private static int helper(int[][] goldMine,int start_row,int start_col)
    {
        /**
         * If we are already at the last column, then we just need to collect the gold at that position.
         **/
        if(start_col == goldMine[0].length - 1)
            return goldMine[start_row][start_col];

        int ans = goldMine[start_row][start_col];

        int rres = Integer.MIN_VALUE;

        if(start_row+1 < goldMine.length)
        {
            rres = Math.max(rres,helper(goldMine,start_row+1,start_col+1));
        }

        if(start_row-1 >= 0)
        {
            rres = Math.max(rres,helper(goldMine,start_row-1,start_col+1));
        }

        rres = Math.max(rres,helper(goldMine,start_row,start_col+1));

        ans += rres;

        return ans;
    }
