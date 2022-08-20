import java.util.*;
import java.lang.*;
public class Main{
    public static void fill(int[] nums,Scanner scn){
        for(int i=0;i<nums.length;i++){
            nums[i]=scn.nextInt();
        }
    }
    public static void fill(int[][] nums,Scanner scn){
        int nr=nums.length;
        int nc=nums[0].length;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j]=scn.nextInt();
            }
        }
    }
    public static void print(int[] nums){
        System.out.println(Arrays.toString(nums));
    }
    public static void print(int[][] nums){
        for(int[] val:nums)
        print(val);
    }
    public static void fill(long[] nums,Scanner scn){
        for(int i=0;i<nums.length;i++){
            nums[i]=scn.nextLong();
        }
    }
    public static void fill(long[][] nums,Scanner scn){
        int nr=nums.length;
        int nc=nums[0].length;
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                nums[i][j]=scn.nextLong();
            }
        }
    }
    public static void print(long[] nums){
        System.out.println(Arrays.toString(nums));
    }
    public static void print(long[][] nums){
        for(long[] val:nums)
        print(val);
    }
    public static void reverse(int[] nums){
        reverse(nums,0,nums.length-1);
    }
    public static void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public static void reverse(int[] nums,int i,int j){
        int start=i;
        int end=j;
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public static void reverse(long[] nums){
        reverse(nums,0,nums.length-1);
    }
    public static void reverse(long[] nums,int i,int j){
        int start = i;
        int end =j;
        while(start<=end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    public static void swap(long[] nums,int i,int j){
        long tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=nums[i];
    }
    public static void sort(int[] nums){
        Arrays.sort(nums);
    }
    public static void sort(long[] nums){
        Arrays.sort(nums);
    }
    public static int[] clone(int[] nums){
        return nums.clone();
    }
    public static long[] clone(long[]  nums){
        return nums.clone();
    }
    public static int abs(int a){
        if(a<0)
        return -a;
        return a;
    }
    public static long abs(long a){
        if(a<0)
        return -a;
        return a;
    }
    public static int minf(){
        return Integer.MIN_VALUE;
    }
    public static int pinf(){
        return Integer.MAX_VALUE;
    }
    public static void print(int n){
        System.out.println(n);
    }
    public static void print(long n){
        System.out.println(n);
    }
    public static void print(String s){
        System.out.println(s);
    }
    public static char val(String[] maze,int i,int j){
        // if(i>=0&&i<maze.length&&j>=0&&j<maze[0].length())
            return maze[i].charAt(j);
        
    }
    public static boolean good(String[] maze,int i,int j){
        char ch = maze[i].charAt(j);
        int nr = maze.length;
        int nc = maze[0].length();
        if(ch=='.'){
            
            int count =0;
            if(i-1>=0 && j-1>=0&& val(maze,i-1,j-1)=='*')count++;
            if(i-1>=0 && val(maze,i-1,j)=='*')count++;
            if(i-1>=0 && j+1<nc && val(maze,i-1,j+1)=='*')count++;
            if(j-1>=0 && val(maze,i,j-1)=='*')count++;
            if(j+1<nc && val(maze,i,j+1)=='*')count++;
            if(i+1<nr && j-1>=0 && val(maze,i+1,j-1)=='*')count++;
            if(i+1<nr&& val(maze,i+1,j)=='*')count++;
            if(i+1<nr && j+1<nc && val(maze,i+1,j+1)=='*')count++;
            
            if(count ==0)
            return true;
            
            else
            return false;
        }else if(ch!='.'&&ch!='*'){
            int n = ch-'0';
            int count =0;
            if(i-1>=0 && j-1>=0&& val(maze,i-1,j-1)=='*')
            {
                if(val(maze,i-1,j-1)=='*')
                count++;
                
            }
            if(i-1>=0 && val(maze,i-1,j)=='*')count++;
            if(i-1>=0 && j+1<nc && val(maze,i-1,j+1)=='*')count++;
            if(j-1>=0 && val(maze,i,j-1)=='*')count++;
            if(j+1<nc && val(maze,i,j+1)=='*')count++;
            if(i+1<nr && j-1>=0 && val(maze,i+1,j-1)=='*')count++;
            if(i+1<nr&& val(maze,i+1,j)=='*')count++;
            if(i+1<nr && j+1<nc && val(maze,i+1,j+1)=='*')count++;
            
            if(count == n)
            return true;
            else
            return false;
        }
        else
        return true;
    }
    public static boolean isvalid(String[] maze){
        boolean[][] ans = new boolean[maze.length][maze[0].length()];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length();j++){
                // System.out.print("<"+i+","+j+">");
                ans[i][j]=good(maze,i,j);
                // System.out.print(ans[i][j]+" ");
                if(!ans[i][j])
                return false;
            }
        }
    //   for(int i=0;i<ans.length;i++){
    //       for(int j=0;j<ans[0].length;j++){
    //           System.out.print(ans[i][j]+" ");
    //       }
    //       System.out.println();
    //   }
        return true;
    }
    public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
       int nr = scn.nextInt();
       int nc =scn.nextInt();
       String[] maze = new String[nr];
       for(int i=0;i<nr;i++){
           maze[i]=scn.next();
       }
    //   for(String val:maze)
    //   System.out.println(val);
       if(isvalid(maze)){
           print("YES");
       }else{
           print("NO");
       }
    }
}

