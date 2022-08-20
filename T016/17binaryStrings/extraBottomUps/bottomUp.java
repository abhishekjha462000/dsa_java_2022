    private static int bottomUp(int n)
    {
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        if(n == 2)
            return 3;

        int[] zeroes = new int[n+1];
        int[] ones = new int[n+1];

        // zeroes[i] = number of binary strings of length i ending at 0 without consecutive zeroes
        // ones[i] = number of binary strings of length i ending at 1 without consecutive zeroes

        zeroes[1] = 1;
        ones[1] = 1;

        for(int i = 2; i <= n;i++)
        {
            zeroes[i] = ones[i-1];
            ones[i] = zeroes[i-1]+ones[i-1];
        }

        return zeroes[n] + ones[n]; // number of binary strings of length n without consecutive 0's = number of binary strings of length n ending at 0 without consecutive 0's + number of binary strings of length n ending at 1 without consecutive 0's
    }
