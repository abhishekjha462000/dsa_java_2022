ㅤㅤimport static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int[] coins = new int[n];


        for(int i = 0; i < n;i++)
        {
            coins[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        // int[] dp = new int[target + 1];

        // dp[0] = 1;

        // for(int i = 0; i < dp.length;i++)
        // {
        //     for(int coin : coins)
        //     {
        //         if(coin <= i)
        //             dp[i] += dp[i-coin];
        //     }
        // }

        // System.out.println(dp[target]);


        ArrayList<String>[] dp = new ArrayList[target+1];

        // Arrays.fill(dp,new ArrayList<String>()); // why was this giving error ??
        for(int i = 0; i < dp.length;i++)
        {
            dp[i] = new ArrayList<String>();
        }

        dp[0].add("");

        for(int i = 0; i <dp.length;i++)
        {
            for(int coin : coins)
            {
                if(coin <= i)
                {
                    ArrayList<String> rres = dp[i-coin];

                    if(rres.size() != 0)
                    {
                        for(String x : rres)
                        {
                            dp[i].add(x + coin);
                        }
                    }
                }
            }
        }

        for(ArrayList<String> x : dp)
        {
            System.out.println(x);
        }
        
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
