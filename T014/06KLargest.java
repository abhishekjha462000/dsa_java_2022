    private static void KLargest(int[] nums,int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // why default pq -- think ?

        for(int i = 0;i <nums.length;i++)
        {
            if(pq.size() < k)
            {
                /**
                 * fill the PriorityQueue until its size has become k
                 **/
                pq.add(nums[i]);
            }else{

                int val = nums[i];

                // if val is greater than peek of pq then remove and insert val in PriorityQueue

                if(val > pq.peek())
                {
                    pq.remove();
                    pq.add(val);
                }
            }
        }


        while(pq.size() != 0)
        {
            System.out.println(pq.remove());
        }
    }
