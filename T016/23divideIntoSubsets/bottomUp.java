    private static long bottomUp(int n,int k)
    {

        /**
         * rows indices denotes number of groups and column indices denote number of people
         **/
        long[][] dp = new long[k+1][n+1];

        /**
         * Our objective is to find the number of ways n people can be put in k groups such that none of the group is empty
         * So our answer would be stored in dp[k][n] = # of ways in which n people can be put in k groups
         **/


        if(n == 0 || k == 0 || n < k)
            return 0;

        if(k == n)
            return 1;


        for(int col = 0;col <= n;col++)
        {
            for(int row = 0 ; row <= k ;row++)
            {
                if(row == 0 || col == 0 || col < row)
                {
                    dp[row][col] = 0;
                }else if(row == col)
                {
                    dp[row][col] = 1;
                }else{

                    // # of people = col
                    // # of groups = row

                    dp[row][col] = dp[row-1][col-1] + row * dp[row][col-1];
                }
            }
        }


        return dp[k][n];

    }
