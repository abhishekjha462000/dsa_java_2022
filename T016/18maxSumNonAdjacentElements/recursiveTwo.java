    private static int maxSumNonAdjacentElements(int[] nums,int idx,boolean takeOrNot) // (nums,0,false) -- starting point
    {
        // base case


        if(idx == nums.length)
        {
            return 0;
        }

        int ans = Integer.MIN_VALUE;
        if(takeOrNot == false)
        {
            // takeOrNot == false means that the previous element was included or not
            // we can either inlcude the current element or exclude the current element

            ans = Math.max(ans,maxSumNonAdjacentElements(nums,idx+1,true) + nums[idx]); // include the current element

        }


        ans = Math.max(ans,maxSumNonAdjacentElements(nums,idx+1,false)); // exclude the current element 


        return ans;
    }
