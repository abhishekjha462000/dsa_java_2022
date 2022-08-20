    private static int climbBottomUpOptimized(int n)
    {

        int ff = 1;
        int ss = ff;
        int tt = ff + ss;

        int ans = 0;

        for(int i = 3;i <= n;i++)
        {
            ans = ff + ss + tt;

            ff = ss;
            ss = tt;
            tt = ans;
        }

        return ans;
    }
