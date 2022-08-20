    private static int unbounded(int[] vls,int[] wt,int cap,int start)
    {
        if(cap < 0)
            return 0;
        if(start == vls.length)
            return 0;

        int item_wt = wt[start];


        int ans = 0;

        for(int i = 1; i * item_wt <= cap ;i++)
        {
            ans = Math.max(ans,unbounded(vls,wt,cap-i*item_wt,start+1)+i* vls[start]);
        }

        ans = Math.max(ans, unbounded(vls,wt,cap,start+1));

        return ans;
    }
