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

        maxSumNonAdjacentElements(nums,0,false,0);
        System.out.println(max);

    }





    static int max = Integer.MIN_VALUE;

    private static void maxSumNonAdjacentElements(int[] nums,int idx, boolean takeOrNot,int asf)
    {
        if(idx == nums.length)
        {
            if(asf > max)
            {
                max = asf;
            }
            return;
        }

        if(takeOrNot == false)
        {
            
            maxSumNonAdjacentElements(nums,idx+1,true,asf+nums[idx]); // include 
            
        }

        maxSumNonAdjacentElements(nums,idx+1,false, asf); // exclude


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
