    private static int bottomUp(int[] nums){
        int N = nums.length;


        // the dp matrix has 2 rows, the first row stands when we include the current element and the second row stand when we do not include the current element


        // dp[0][i] = max sum of non adjacent elements till the element at index i and including this element
        // dp[1][i] = max sum of non adjacent elements till the element at index i and excluding this element

        int include = nums[0];
        int exclude = 0;





        for(int i = 1 ; i < nums.length ; i++)
        {
            int newInclude = exclude + nums[i]; // include the current element -- for this to happen the previous element should not have been included
            int newExclude = Math.max(include,exclude); // exclude the current element -- in this we can consider both the cases when the last element was included as well as excluded --  so we take the max of both of them as our final answer

            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include, exclude);
    }
