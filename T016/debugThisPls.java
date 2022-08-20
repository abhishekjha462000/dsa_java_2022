import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    // 9319277275 -- somendra tiwari sir 

    
    // static ArrayList<String>[] dp = new ArrayList[10000];
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] goldMine = new int[nr][nc];


        for(int i = 0;i<nr;i++)
        {
            for(int j = 0;j < nc;j++)
            {
                goldMine[i][j] = scn.nextInt();
            }
        }

        System.out.println(maxGoldPath(goldMine,0));
    }

    private static String maxGoldPath(int[][] goldMine,int start)
    {
        String path = "";


        int ans = Integer.MIN_VALUE;


        // for(int row =  0,col = 0 ; row < goldMine.length;row++)
        // {
            StringBuilder sb = new StringBuilder("");
            int temp = helper(goldMine,0,0,sb);
            System.out.println(sb);
            System.out.println(temp);

            // if(ans < temp)
            // {
            //     ans = temp;

            //     path = sb.toString();
            // }
        // }

        // System.out.println(ans);
        return path ;
    }
    

    private static int helper(int[][] goldMine,int row,int col,StringBuilder store)
    {
        System.out.println("called " + row + " "+col);
        System.out.println(store);
        if(col == goldMine[0].length-1)
        {

            store.append(row +""+col+" -- ");
            System.out.println(store);
            return goldMine[row][col];
        }

        int ans = goldMine[row][col];

        if(col + 1 < goldMine[0].length)
        {
            int temp = Integer.MIN_VALUE;

            String supplimentry = row +""+col+" -- ";

            StringBuilder one = new StringBuilder(store.toString()+supplimentry);
            StringBuilder two = new StringBuilder(store.toString()+supplimentry);
            StringBuilder three = new StringBuilder(store.toString()+supplimentry);
            // store.append(supplimentry);

            System.out.println("One Two Three Before sending"+" My code is "+ row + ""+col);
            System.out.println(one +" &&& "+two+" &&& "+three); 
            int rresOne = -8989;
            int rresTwo = -456789;
            System.out.println(store);
            if(row + 1 < goldMine.length)
            {
                rresOne = helper(goldMine,row+1,col+1,one);
                temp = Math.max(temp,rresOne);
            }

            if(row-1 >= 0)
            {
                rresTwo = helper(goldMine,row-1,col+1,two);
                temp = Math.max(temp,rresTwo);
            }

            int rresThree = helper(goldMine,row,col+1,three);
            temp = Math.max(temp,rresThree);

            System.out.println("One Two Three after receiving"+" My code is "+ row + ""+col);
            System.out.println(one +" &&& "+two+" &&& "+three);
 
            store = new StringBuilder();
            if(temp == rresOne){
                System.out.println("added "+one.toString());
                store.append(one);
            }else if(temp == rresTwo){
                                System.out.println("added "+two.toString());

                store.append(two);
            }else{
                                System.out.println("added "+three.toString());

                store.append(three);
            }

            ans += temp;
            System.out.println("store " + store + "cost " + ans);

        }

        return ans;
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
