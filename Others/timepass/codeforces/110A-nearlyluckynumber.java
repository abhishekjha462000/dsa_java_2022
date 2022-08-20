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
    public static void print(String s){
        System.out.println(s);
    }
    public static void print(int n){
        System.out.println(n);
    }
    public static boolean lucky(int n){
        // int n = num;
        if(n==0) return false;
        while(n!=0){
            int dig=n%10;
            if(!(dig==4||dig==7))return false;
            n/=10;
        }
        return true;
        
    }
    public static boolean nearlyLucky(String s){
        int len = s.length();
        int nold=0;
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            int n=ch-'0';
            if(n==7||n==4)nold++;
        }
        // print(nold);
        if(lucky(nold))
        return true;
        return false;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        if(nearlyLucky(s))
        print("YES");
        else
        print("NO");
    }
}


