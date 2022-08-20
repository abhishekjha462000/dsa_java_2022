    private static int topDown(int[] red,int[] blue,int[] green,int idx)
    {
        /**
         * I have introduced this varaible called marker -- this tells me the color with which I am going to paint a house
         * marker == 0 would mean that i painted the house with red
         * marker == 1 would mean that i painted the house with blue
         * marker == 2 would mean that i painted the house with green
         **/

        Integer[][] dp = new Integer[3][red.length];

        
        /**
         * Why did you initialize these values -- because in line no 60 I was required to pass them into the min function.
         **/

        dp[0][0] = Integer.MAX_VALUE;
        dp[1][0] = Integer.MAX_VALUE;
        dp[2][0] = Integer.MAX_VALUE;

        for(int marker = 0 ; marker < 3 ; marker++)
        {
            /**
             * In this loop i paint the house at 0th index with red,blue and green and then ask the min cost to paint the remaining houses.
             **/
            dp[marker][0] = Math.min(dp[marker][0], helper(red,blue,green,idx+1,marker,dp));
            
            int costOfHouseZero = 0;

            if(marker == 0)
                costOfHouseZero = red[0];
            else if(marker == 1)
                costOfHouseZero = blue[0];
            else
                costOfHouseZero = green[0];

            // costOfHouseZero is the cost of painting the 0th house
            dp[marker][0] +=  costOfHouseZero;
        }

        return Math.min(dp[0][0],Math.min(dp[1][0],dp[2][0]));
    }


    private static int helper(int[] red,int[] blue,int[] green,int idx,int marker,Integer[][] dp)
    {
        /**
         * if idx is out of array then the mimimum cost that you could generate is 0
         **/
        if(idx == red.length)
            return 0;

        if(dp[marker][idx] != null)
            return dp[marker][idx];

        int ans =  Integer.MAX_VALUE;

        if(marker == 0)
        {
            /**
             * marker == 0 means that the previous house was filled with red, thus we can paint the house that we are currently at using either blue or green color
             **/
            

            ans = Math.min(ans, helper(red,blue,green,idx+1,1,dp)+blue[idx]); // paint blue here

            ans = Math.min(ans, helper(red,blue,green,idx+1,2,dp)+green[idx]); //  paint green here

        }else if(marker == 1){
            
            /**
             * marker == 1 means that the previous house was filled with blue, thus we can paint the house that we are currently at using either red or green color
             **/

            ans = Math.min(ans, helper(red,blue,green,idx+1,0,dp)+red[idx]); // paint red here

            ans = Math.min(ans, helper(red,blue,green,idx+1,2,dp)+green[idx]); //  paint green here

        }else{
            /**
             * marker == 2 means that the previous house was filled with green, thus we can paint the house that we are currently at using either red or blue color
             **/

            ans = Math.min(ans, helper(red,blue,green,idx+1,0,dp)+red[idx]); // paint red here

            ans = Math.min(ans, helper(red,blue,green,idx+1,1,dp)+blue[idx]); //  paint blue here
        }


        return dp[marker][idx] = ans;
    }
