    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int k = scn.nextInt(); // You cannot make n,k as Long (why?) -- because array indices do not support this

        // dp[k][n] = number of ways of dividing n people into k groups such that no group is empty and every person is in a group
        Long[][] dp = new Long[k+1][n+1];

        for(Long[]  x : dp)
            Arrays.fill(x,-1L);

        System.out.println(topDown(n,k,dp));
        // System.out.println(count);
    }

    // static int count = 0; //  was used for finding the number of calls 
    private static Long topDown(int n,int k,Long[][] dp)
    {
        // count++;
      
        if(n < k)
            return 0L;

        if(n == k)
            return 1L;

        if(n != 0 && k == 1)
            return 1L;

        if(dp[k][n] != -1)
            return dp[k][n];

        return dp[k][n] = (k)*topDown(n-1,k,dp) + topDown(n-1,k-1,dp);
    }
