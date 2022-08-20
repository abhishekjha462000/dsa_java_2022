    private static ArrayList<String> print(int[] nums,int start,ArrayList<String>[] dp)
    {
        if(start == nums.length)
        {
            ArrayList<String> base = new ArrayList<>();

            base.add("N");

            return base;
        }

        if(nums[start] == 0)
        {
            return new ArrayList<>();
        }

        if(dp[start] != null)
            return dp[start];


        ArrayList<String> ans = new ArrayList<>();

        for(int steps = 1 ; steps <= nums[start] ;steps++)
        {
            int curr = start + steps;
            if(curr > nums.length)
                break;

            ArrayList<String> rres = print(nums,curr);

            if(rres.size() != 0){
                for(String str : rres)
                {
                    ans.add(start + " "+str);
                }
            }

        }

        return dp[start] = ans;
    }
