    private static int climb(int n)
    {
        if(n < 0)
            return 0;

        if(n == 0)
            return 1; // from 0 --> to 0 #number of ways = 1

        return climb(n-1)+climb(n-2)+climb(n-3);
    }
