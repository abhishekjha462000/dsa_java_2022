import java.util.*;
import java.io.*;
import static java.lang.System.*;
import java.util.Stack;
import java.util.Queue;

	/**
	 * Author : @sam45jh
	 **/

	/**
         * Tree (By the way this is a Binary search tree now that i see this)
         * because its inorder is sorted already
         *         ___50
         * 	  /     \
         *       25     75
         *      / \    / \
         *     12 37  62  87
         * 	  /    \
         *       30    70
         * 
         * preorder : root left right -- 50 25 12 37 30 75 62 70 87
         * inorder : left root right -- 12 25 30 37 50 62 70 75 87
         * postorder : left right root -- 12 30 37 25 70 62 87 75 50
         **/
public class Main{
	
    public static void main(String[] hi) throws IOException{
        initializeIO();    
    		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));     
        int n = Integer.parseInt(br.readLine());

        Integer[] nums = new Integer[n];

        String[] values = br.readLine().split(" ");

        for(int i=0;i<n;i++)
        {
        	String str = values[i];
        	if(str.equals("n") == false)
        	{
        		nums[i] = Integer.parseInt(values[i]);
        	}else{
        		nums[i] = null;
        	}
        }

        BT b = new BT(nums);

        
        System.out.println(b);

    }
	
    private static void initializeIO(){
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            System.setErr(new PrintStream(new FileOutputStream("error.txt")));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}