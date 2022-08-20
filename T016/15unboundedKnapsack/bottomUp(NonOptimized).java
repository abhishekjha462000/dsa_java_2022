    private static int bottomUp(int[] vls,int[] wt, int cap)
    {
        int N = vls.length; //  Total no of items 
        int[][] dp = new int[vls.length][cap+1];

        // dp[i][j] would mean the max value that could be achieved from a bag of capacity j starting from items with index i
        // So our final answer would be at dp[0][cap]

        // The smaller problem is dp[j][0] = 0

        // We need to traverse the dp matrix in a bottom to up fashion in the direction of increasing row

        for(int col = 0; col <= cap; col++)
        {
            for(int row = N-1;row >= 0;row--)
            {
                if(col == 0)
                {
                    dp[row][col] = 0;
                }else if(row == N-1){
                    // Here capacity is col and the item is at index N-1
                    int value_of_last_item = vls[N-1];
                    int wt_of_last_item = wt[N-1];

                    // Yha pr maine glti se `col` ki jagah `cap` likh diya tha due to which i was wrong answer 
                    dp[row][col] = value_of_last_item * (col/wt_of_last_item);
                }else{
                    // capacity = col and we need to start from item at the index (row)

                    dp[row][col] = dp[row+1][col]; // exclude the current item

                    int item_wt = wt[row];

                    for(int times = 1; times * item_wt <=  col ; times++)
                    {
                        dp[row][col] = Math.max(dp[row][col],dp[row+1][col-times*item_wt]+times*vls[row]);
                    }
                }
            }
        }

        return dp[0][cap];
    }
