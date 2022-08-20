    private static int paintHouseMinCost(int[] red,int[] blue,int[] green,int idx)
    {

        /**
         * cost[0] = minimum cost of painting the houses if we paint the house at 0th index with red
         * cost[1] = minimum cost of painting the houses if we paint the house at 1th index with blue
         * cost[2] = minimum cost of painting the houses if we paint the house at 2th index wihth green
         **/
        int[] cost = new int[3];

        Arrays.fill(cost,Integer.MAX_VALUE);

        /**
         * I have introduced this varaible called marker -- this tells me the color with which I am going to paint a house
         * marker == 0 would mean that i painted the house with red
         * marker == 1 would mean that i painted the house with blue
         * marker == 2 would mean that i painted the house with green
         **/
      
      
        for(int marker = 0 ; marker < 3 ; marker++)
        {
            /**
             * In this loop i paint the house at 0th index with red,blue and green and then ask the min cost to paint the remaining houses.
             **/
            cost[marker] = Math.min(cost[marker], helper(red,blue,green,idx+1,marker));
            
            int costOfHouseZero = 0;

            if(marker == 0)
                costOfHouseZero = red[0];
            else if(marker == 1)
                costOfHouseZero = blue[0];
            else
                costOfHouseZero = green[0];

            // costOfHouseZero is the cost of painting the 0th house
            cost[marker] +=  costOfHouseZero;
        }

        /**
         * Sort all the costs and the minimum cost would be stored at the 0th index of the cost array
         **/
        Arrays.sort(cost);

        return cost[0];
    }


    private static int helper(int[] red,int[] blue,int[] green,int idx,int marker)
    {
        /**
         * if idx is out of array then the mimimum cost that you could generate is 0
         **/
      
        if(idx == red.length)
            return 0;


        int ans =  Integer.MAX_VALUE;

        if(marker == 0)
        {
            /**
             * marker == 0 means that the previous house was filled with red, thus we can paint the house that we are currently at using either blue or green color
             **/
           
            ans = Math.min(ans, helper(red,blue,green,idx+1,1)+blue[idx]); // paint blue here

            ans = Math.min(ans, helper(red,blue,green,idx+1,2)+green[idx]); //  paint green here

        }else if(marker == 1){
            
            /**
             * marker == 1 means that the previous house was filled with blue, thus we can paint the house that we are currently at using either red or green color
             **/

            ans = Math.min(ans, helper(red,blue,green,idx+1,0)+red[idx]); // paint red here

            ans = Math.min(ans, helper(red,blue,green,idx+1,2)+green[idx]); //  paint green here

        }else{
            /**
             * marker == 2 means that the previous house was filled with green, thus we can paint the house that we are currently at using either red or blue color
             **/

            ans = Math.min(ans, helper(red,blue,green,idx+1,0)+red[idx]); // paint red here

            ans = Math.min(ans, helper(red,blue,green,idx+1,1)+blue[idx]); //  paint blue here
        }


        return ans;
    }
    
