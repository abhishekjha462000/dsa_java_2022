import static java.lang.System.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class Main{
    private static int[] readIntArray(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine());

        String[] values = br.readLine().split(" ");

        int[] nums = new int[n];

        for(int i=0;i<n;i++)
        {
            nums[i] = Integer.parseInt(values[i]);
        }

        return nums;
    }
    public static void main(String[] args) throws IOException{
        initializeIO();
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();

        int[][] maze = new int[nr][nc];

        for(int i = 0;i < nr;i++)
        {
            for(int j = 0;j < nc;j++)
            {
                maze[i][j] = scn.nextInt();
            }
        }

        System.out.println(minCost(maze));
    }

    private static int minCost(int[][] maze)
    {
        int nr = maze.length;
        int nc = maze[0].length;

        return minCostHelper(maze,0,0);
    }

    private static int minCostHelper(int[][] maze,int sr,int sc)
    {
        int er = maze.length-1;
        int ec = maze[0].length-1;

        if(sr > er || sc > ec)
            return Integer.MAX_VALUE;

        if(sr == er && sc == ec)
            return maze[sr][sc];// doubt

        int rresOne = minCostHelper(maze,sr+1,sc);
        int rresTwo = minCostHelper(maze,sr,sc+1);

        int myAns = Math.min(rresOne,rresTwo);

        if(myAns != Integer.MAX_VALUE)
            return myAns+maze[sr][sc];

        return myAns;

    }

    private static int minCost(int[][] maze)
    {
        // last row

        int er = maze.length-1;
        int ec = maze[0].length-1;

        for(int row = er; row >= 0;row--)
        {
            for(int col = ec;col >= 0;col--)
            {
                int valOne = (row+1 <= er) ? maze[row+1][col]:(0);
                int valTwo = (col+1 <= ec) ? maze[row][col+1]:(0);

                if(valOne == 0 || valTwo == 0)
                    maze[row][col] += (valOne + valTwo);
                else
                    maze[row][col] += Math.min(valOne,valTwo);
            }
        }

        return maze[0][0];
    }
    private static int gold(int[][] mine)
    {

        for(int col =mine[0].length - 1; col >= 0;col--)
        {
            for(int row = 0;row < mine.length ; row++)
            {
                int op1 = ((row-1 >= 0) && (col+1 < mine[0].length)) ? (mine[row-1][col+1]):(0);
                int op2 = (col+1 < mine[0].length) ? (mine[row][col+1]):(0);
                int op3 = (row+1 < mine.length && col+1 < mine[0].length) ? (mine[row+1][col+1]):(0);

                mine[row][col] += Math.max(op1,Math.max(op2,op3));
            }
        }
        int ans = mine[0][0];

        for(int row = 0, col = 0; row < mine.length ;row++)
        {
          ans = Math.max(ans,mine[row][col]);  
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
