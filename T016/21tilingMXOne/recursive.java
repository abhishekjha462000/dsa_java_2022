  private static int tilling(int n,int m)
    {
        if(n < m)
            return 1;

        if(n == m)
            return 2;
        

        int ans = 0;

        ans += tilling(n-1,m);

        if(n >= m)
        ans += tilling(n-m,m);

        return ans;
    }
