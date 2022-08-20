    private static void longestConsecutiveSequence(int[] nums)
    {
        HashMap<Integer,Boolean> ynMap  = new HashMap<>();


        for(int i = 0; i < nums.length;i++)
        {
            ynMap.put(nums[i],true);
        }


        for(int i = 0;i < nums.length;i++)
        {
            if(ynMap.containsKey(nums[i]+1))
                ynMap.put(nums[i]+1,false);
        }

        HashMap<Integer,Integer> sequenceStartMap = new HashMap<>();



        for(Map.Entry<Integer,Boolean> e : ynMap.entrySet())
        {
            if(e.getValue())
                sequenceStartMap.put(e.getKey(),1);
        }


        // System.out.println(sequenceStartMap);

        for(Map.Entry<Integer,Integer> e : sequenceStartMap.entrySet())
        {
            int val = e.getKey();

            while(true)
            {
                if(ynMap.containsKey(val+1))
                {
                    sequenceStartMap.put(e.getKey(),e.getValue()+1);
                    val++;
                }else{
                    break;
                }
            }
        }

        // System.out.println(sequenceStartMap);


        int start = 0;
        int length = Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> e : sequenceStartMap.entrySet())
        {
            if(length < e.getValue())
            {
                start = e.getKey();
                length = e.getValue();
            }
        }

        while(length-- != 0)
        {
            System.out.println(start++);
        }


    }
