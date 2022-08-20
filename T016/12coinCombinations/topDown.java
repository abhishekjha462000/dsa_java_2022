import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        initializeIO();


        Scanner scn = new Scanner(System.in);


        int n = scn.nextInt();

        int[] coins = new int[n];


        for(int i = 0 ; i < n ; i++)
        {
            coins[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[][] dp = new int[coins.length][target+1];


        /**
         * Why do we need to initialize my dp matrix with -1 and not 0??
         * 
         * (Also, one thing to note is that when you initialize the dp matrix with 0 the code runs slower and when you initialize it with -1 it runs faster(why?))
         * 
         * For this I consider the test case 
         * 3
         * 2 6 12
         * 15
         * 
         *   12                 12
         *   \                   \
         *    \(include 12)       \(include 12)
         *     9(focus on this)    9(focus on this)
         *    / X (6)             /
         *   9                   / (include 6)
         *    \                 /
         *     \               15  
         *      \ (2 2 2)      / X (2)
         *       \            /
         *        \          /
         *         \___15___/
         * 
         * 
         * 
         * 
         * Let us say we filled the dp array with 0. Then in the first case when the recursion reaches 9---12 it would store 0 as there are no ways to pay 9 rupees using 12 rupees coin.
         * 
         * This value would be stored and when the recursion reaches 9--12 on the other side then since the value at 9---12 is already stores as 0, so the recursion would again calculate the value in this subtree.
         * Thus, we should always fill the dp array with a value which could never be the answer for any subproblem. If we fill the dp array with a value which could be a potential answer then when we arrive at a 
         * subproblem whose answer is same as the value with which the dp array is filled, then the dp array would not work as an indicator for this subproblem and if by any means it happens that this subproblem is a
         * BIG problem then we are doomed for sure.
         **/
        for(int[] x : dp)
            Arrays.fill(x,-1);
        System.out.println(coinsSumCombinationTopDown(coins,target,0,dp));

    }

    private static int coinsSumCombinationTopDown(int[] coins,int target,int start,int[][] dp)
    {


        if(start == coins.length)
        {
            if(target == 0 )
                return 1;
            return 0;
        }
        int coin = coins[start];

        if(dp[start][target] != -1)
            return dp[start][target];

        int ans = 0;


        for(int number  = 1; number * coin <= target;number++)
        {
            ans += coinsSumCombinationTopDown(coins,target-(number)*coin,start+1,dp);
        }

        ans += coinsSumCombinationTopDown(coins,target,start+1,dp); // when you do not take the coin

        return dp[start][target] = ans;
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
