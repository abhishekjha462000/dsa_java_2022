    private static Long divideIntoTeams(Long n,Long k)
    {
        if(n < k)
            return 0L;

        if(n == k)
            return 1L;

        if(n != 0 && k == 1)
            return 1L;


        return (k)*divideIntoTeams(n-1,k) + divideIntoTeams(n-1,k-1);
    }
