    private static void Ksort(int[] nums,int k)
    {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // push first k+1 elements into the PriorityQueue -- why ? -- because the element at the index k can also be at 0th index

        for(int i = 0;i<=k;i++){
            pq.add(nums[i]);
        }

        int windowEnd = k+1;
        int i = 0;
        while(windowEnd < nums.length)
        {
            nums[i++] = pq.remove();
            pq.add(nums[windowEnd++]);
        }

        while(i < nums.length)
        {
            nums[i++] = pq.remove();
        }
    }
