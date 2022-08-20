   private static int tiling(int n){
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        return tiling(n-1) + tiling(n-2);
    }
