    private static int bottomUp(int[] red,int[] blue,int[] green)
    {
        int N = red.length;

        int[][] dp = new int[3][N];


        /**
         * dp[i][j] would mean the minimum cost that could be achieved by coloring the house at jth index with color at ith index(i ranges from 0 to 2)
         **/

        for(int[] x : dp)
        {
            Arrays.fill(x,Integer.MAX_VALUE);
        }

        
        for(int col = 0 ; col < N ; col++)
        {
            for(int row = 0 ; row < 3 ; row++)
            {
                if(col == 0)
                {
                    if(row == 0) dp[row][col] = red[0];
                    if(row == 1) dp[row][col] = blue[0];
                    if(row == 2) dp[row][col] = green[0];
                }else{
                    if(row == 0)
                    {
                        dp[row][col] = Math.min(dp[row][col],Math.min(dp[1][col-1],dp[2][col-1])+red[col]);
                    }else if(row == 1)
                    {
                        dp[row][col] = Math.min(dp[row][col],Math.min(dp[0][col-1],dp[2][col-1])+blue[col]);
                    }else{
                        dp[row][col] = Math.min(dp[row][col],Math.min(dp[0][col-1],dp[1][col-1])+green[col]);
                    }
                }
            }
        }

        return Math.min(dp[0][N-1],Math.min(dp[1][N-1],dp[2][N-1]));
    }
    
