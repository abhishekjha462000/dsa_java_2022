    private static int maxValue(int[] vls,int[] wt,int cap, int idx)
    {
        if(cap == 0)
            return 0;

        if(idx == vls.length-1)
        {
            if(cap < wt[idx])
                return 0;
            return vls[idx];
        }


        int rres = maxValue(vls,wt,cap,idx+1); // if exclude the current item

        if(idx < vls.length) // This `if` statement is unnecessary.
        {
            if(cap - wt[idx] >= 0)
            {
                int rresTwo = maxValue(vls,wt,cap-wt[idx],idx+1); // if we include the current item

                // If after including the current item we get more value than excluding it, then return this as it is more profitable

                if(rresTwo+vls[idx] > rres)
                    return rresTwo+vls[idx];
            }
        }

        return rres;
    }
