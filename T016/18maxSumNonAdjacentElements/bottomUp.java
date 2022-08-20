    private static int bottomUp(int[] nums){
        int N = nums.length;


        // the dp matrix has 2 rows, the first row stands when we include the current element and the second row stand when we do not include the current element


        // dp[0][i] = max sum of non adjacent elements till the element at index i and including this element
        // dp[1][i] = max sum of non adjacent elements till the element at index i and excluding this element

        int[][] dp = new int[2][N];



        dp[0][0] = nums[0];
        dp[0][1] = 0;


        for(int i = 1 ; i < nums.length ; i++)
        {
            dp[0][i] = dp[1][i-1]+nums[i]; // include the current element -- for this to happen the previous element should have been excluded
            dp[1][i] = Math.max(dp[0][i-1],dp[1][i-1]); // exclude the current element -- in this we can consider both the cases when the last element was included as well as excluded --  so we take the max of both of them as our final answer
            
        }
        return Math.max(dp[0][N-1],dp[1][N-1]);
    }
