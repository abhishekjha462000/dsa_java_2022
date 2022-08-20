    // call like this printAlternateSubsequences(nums,0,"",false)
    private static void printAlternateSubsequences(int[] nums,int idx,String ans, boolean takeOrNot)
    {
        if(idx == nums.length)
        {
            if(!ans.equals(""))
                System.out.println(ans);
            else
                System.out.println("empty");
            return;
        }
      
        // takeOrNot shows if the element at the index idx is taken or not, if it is false then we can include the next element to be called, that is the reason we have an extra call.
        if(takeOrNot == false)
        {
            
            printAlternateSubsequences(nums,idx+1,ans+nums[idx]+" ", true); // include 
            
        }

        printAlternateSubsequences(nums,idx+1,ans,false); // exclude


    }
