    private static int fibBottomUpOptimized(int n)
    {
        int ff = 0;
        int ss = 1;

        int ans = 0;

        for(int i = 2; i <= n;i++)
        {
            ans = ff + ss;

            ff = ss;
            ss = ans;
        }
        return ans;
    }
