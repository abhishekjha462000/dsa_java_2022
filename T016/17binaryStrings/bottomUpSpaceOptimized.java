    private static int bottomUp(int n)
    {
        int[] dp = new int[n+1]; // last index n

        if(n == 0)
            return 0;

        if(n == 1)
            return 2;

        if(n == 2)
            return 3;


        int ff = 2;
        int ss = 3;

        int finalAns = 0;

        for(int i = 3 ; i <= n ; i++)
        {
            finalAns = ff + ss;

            ff = ss;

            ss = finalAns;
        }

        return finalAns;

    }
