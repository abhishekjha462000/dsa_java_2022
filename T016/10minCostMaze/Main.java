import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        initializeIO();

        Scanner scn = new Scanner(System.in);

        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] maze = new int[nr][nc];

        for(int i = 0;i < nr;i++)
        {
            for(int j = 0; j < nc;j++)
            {
                maze[i][j] = scn.nextInt();
            }
        }

        // System.out.println(minCostMaze(maze,0,0));


        // dp[i][j] would mean the minCost from (i,j) to dest
        int[][] dp = new int[nr][nc];

        for(int[] row : dp)
            Arrays.fill(row,Integer.MAX_VALUE);

        System.out.println(minCostMazeTD(maze,0,0,dp));
        System.out.println(minCostMazeBU(maze));
        System.out.println(minCostMazeBUTwo(maze));
    }

    private static int minCostMaze(int[][] maze,int sr,int sc)
    {
        // We need to reach ending row and ending column
        int er = maze.length - 1;
        int ec = maze[0].length - 1;

        if(sr > er || sc > ec)
            return Integer.MAX_VALUE;

        if(sr == er && sc == ec)
            return maze[sr][sc];


        int ans = maze[sr][sc];

        int rresOne = minCostMaze(maze,sr+1,sc);
        int rresTwo = minCostMaze(maze,sr,sc+1);

        ans += Math.min(rresOne,rresTwo);

        return ans;

    }

    private static int minCostMazeTD(int[][] maze,int sr,int sc,int[][] dp)
    {
        int er = maze.length - 1;
        int ec = maze[0].length - 1;

        if(sr > er || sc > ec)
            return Integer.MAX_VALUE;

        if(sr == er && sc == ec)
            return maze[sr][sc];

        if(dp[sr][sc] != Integer.MAX_VALUE)
            return dp[sr][sc];


        dp[sr][sc] = maze[sr][sc];

        int rresOne = minCostMazeTD(maze,sr+1,sc,dp);
        int rresTwo = minCostMazeTD(maze,sr,sc+1,dp);

        return dp[sr][sc] += Math.min(rresOne,rresTwo);
    }

    // Method One
    private static int minCostMazeBU(int[][] maze)
    {
        int nr = maze.length;
        int nc = maze[0].length;

        int[][] dp = new int[nr][nc];


        int er = dp.length-1;
        int ec = dp[0].length-1;

        // dp[i][j] would mean the minCost from (i,j) to dest
        // so our answer would be dp[0][0]
        // dp[er][ec] = maze[er][ec]


        for(int row = er ; row >= 0 ;--row)
        {
            for(int col = ec ; col >= 0; --col)
            {
                // add maze[row][col] to min(dp[row+1][col],dp[row][col+1])
                int horizontal = (row + 1) <= er ? (dp[row+1][col]) : (0);
                int vertical = (col + 1) <= ec ? (dp[row][col+1]) : (0);

                if(horizontal == 0 || vertical == 0)
                {
                    dp[row][col] = maze[row][col] + horizontal + vertical;
                }else{
                    dp[row][col] = maze[row][col] + Math.min(horizontal,vertical);
                }
            }
        }

        return dp[0][0];
    }

    // Method two


    private static int minCostMazeBUTwo(int[][] maze)
    {
        int nr = maze.length;
        int nc = maze[0].length;

        int[][] dp = new int[nr][nc];


        int er = dp.length-1;
        int ec = dp[0].length-1;

        // dp[i][j] is the mincost from (0,0) to (i,j)
        // so dp[0][0] = maze[0][0]

        // dp[0][0] = maze[0][0]

        for(int row = 0; row <= er ; row++)
        {
            for(int col = 0; col <= ec ; col++)
            {
                // dp[i][j] would be maze[i][j] + dp[i-1][j] and dp[i][j-1];

                int one = (row-1) >= 0 ? (dp[row-1][col]) :(0);
                int two = (col-1) >= 0 ? (dp[row][col-1]) :(0);

                if(one == 0 || two == 0)
                {
                    dp[row][col] = maze[row][col] + one + two;
                }else{
                    dp[row][col] = maze[row][col] + Math.min(one,two);
                }
            }
        }
        return dp[er][ec];
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
