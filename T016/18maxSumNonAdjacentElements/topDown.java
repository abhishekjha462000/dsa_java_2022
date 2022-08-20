import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{



    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] nums = new int[n];

        for(int i = 0 ;  i < n ; i++)
        {
            nums[i] = scn.nextInt();
        }


        // dp[0][idx] would store the max sum of non adjacent elements if we start from the index idx and do not include it.
        // dp[1][idx] would store the max sum of non adjacent elements if we start from the index idx and include it.
        Integer[][] dp = new Integer[2][nums.length];
        System.out.println(topDown(nums,0,false,dp));

    }




    private static int topDown(int[] nums,int idx,boolean takeOrNot,Integer[][] dp)
    {
        // base case


        if(idx == nums.length)
        {
            return 0;
        }

        int code = (takeOrNot == true) ? (1) : (0);

        if(dp[code][idx] != null)
            return dp[code][idx];

        int ans = Integer.MIN_VALUE;
        if(takeOrNot == false)
        {
            // takeOrNot == false means that the previous element was included or not
            // we can either inlcude the current element or exclude the current element

            ans = Math.max(ans,topDown(nums,idx+1,true,dp) + nums[idx]); // include the current element

        }


        ans = Math.max(ans,topDown(nums,idx+1,false,dp)); // exclude the current element 


        return dp[code][idx] = ans;
    }
    





    private static void initializeIO(){
        try 
        {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        }
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }



}
