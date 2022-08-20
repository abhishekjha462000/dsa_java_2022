    private static ArrayList<String> print(int[] nums,int start)
    {
        if(start == nums.length)
        {
            ArrayList<String> base = new ArrayList<>();

            base.add("N"); // "N" stands for the last stair.

            return base;
        }

        if(nums[start] == 0)
        {
            return new ArrayList<>(); // There is no path from this point to "N", that is why we returned an empty arraylist.
        }
      
      
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

        return ans;
    }
