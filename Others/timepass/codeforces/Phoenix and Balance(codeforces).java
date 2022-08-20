import java.util.*;
import java.io.*;
import static java.lang.System.*; // for error stream (static) was necessary.

// @author : sam45jh
public class Main{
    /* declare some  variables */
    public static void main(String[] hi) throws IOException{
        initializeIO();
        scn = new FastReader();
        out = new FastWriter();
        // String[] s = scn.nextLine().trim().split(" ");
        // to prove the intuition behind the problem would be mathematically challenging.
        int n = scn.nextInt();
        int x = 0;
        int y = 0;
        for(int i = 1;i<n;i++){
            int val = power(2,i);
            if(i<(n/2))
                x+=val;
            else
                y+=val;
        }
        x+=power(2,n);
        print(abs(x-y));
    }
    public static  int abs(int x){
        if(x<0)
            return -x;
        return x;
    }
    public static int power(int x,int n){
        if(n==0)
            return 1;
        int val = power(x,n/2);
        val=val*val;
        if((n&1)==1)
            val=val*x;
        return val;
    }
    static FastReader scn;
    static FastWriter out;
    static int imax = Integer.MAX_VALUE;
    static int imin = Integer.MIN_VALUE;
    static long mod = ((long) 1e9) + 7;
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        BufferedWriter bw;
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        <T> void print(T obj) throws IOException {
            bw.write(obj.toString());
            bw.flush();
        }

        void println() throws IOException {
            print("\n");
        }

        <T> void println(T obj) throws IOException {
            print(obj.toString() + "\n");
        }

        void print(int[] arr) throws IOException {
            for (int x : arr) {
                print(x + " ");
            }
            println();
        }

        void print(long[] arr) throws IOException {
            for (long x : arr) {
                print(x + " ");
            }
            println();
        }

        void print(boolean[] arr) throws IOException{
            for(boolean x:arr)
                print(x+" ");
        }

        void print(double[] arr) throws IOException {
            for (double x : arr) {
                print(x + " ");
            }
            println();
        }

        void print(float[] nums) throws IOException{
            for(float x: nums){
                print(x+" ");
            }
            println();
        }
        void printCharN(char c, int n) throws IOException {
            for (int i = 0; i < n; i++) {
                print(c);
            }
        }
    }

    /* print functions for primitives and String*/
    private static void print(int s) throws IOException {
        out.println(s);
    }
    private static void print(long s) throws IOException {
        out.println(s);
    }
    private static void print(boolean s) throws IOException{
        out.println(s);
    }
    private static void print(double s) throws IOException {
        out.println(s);
    }
    private static void print(String s) throws IOException{
        out.println(s);
    }
    private static void print(float s) throws IOException{
        out.println(s);
    }
    private static void print(char ch) throws IOException{
        out.println(ch);
    }

    /* Setting debug functions for primitives and String*/
    private static void debug(int s) throws IOException{
        err.println(s);
    }
    private static void debug(long s) throws IOException{
        err.println(s);
    }
    private static void debug(boolean s) throws IOException{
        err.println(s);
    }
    private static void debug(float s) throws IOException{
        err.println(s);
    }
    private static void debug(double s) throws IOException{
        err.println(s);
    }
    private static void debug(String s) throws IOException{
        err.println(s);
    }
    private static void debug(char s) throws IOException{
        err.println(s);
    }
    /* debugs for non primitives */
    private static void debug(ArrayList<Integer> nums) throws  IOException{
        err.println(nums);
    }
    private static void debug(int[] nums) throws IOException{
        err.println(Arrays.toString(nums));
    }
    private static void debug(long[] nums) throws IOException{
        err.println(Arrays.toString(nums));
    }
    private static void debug(boolean[] nums) throws IOException{
        err.println(Arrays.toString(nums));
    }
    /* Reading arrays */
    public static int[] readIntArray(int n){
        int[] nums = new int[n];
        for(int i=0;i<nums.length;i++){
            nums[i]=scn.nextInt();
        }
        return nums;
    }

    /* Disclaimer */
    // note that if you want to use a function than use IOException;
    // public static void call() throws IOException{
    //     print(10+"Abhishek Jha");
    // }

    /* Main function */


    public static boolean bs(int[] nums, int key){
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        while(start<=end){
            int val = nums[mid];
            if(val == key)return true;
            else if(val < key) start = mid + 1;
            else end = mid - 1;

            mid = (start+end)/2;
        }
        return false;
    }

    /* sorting an array in nlogn time */
    public static void sort(int[] nums){
        // the reason I dont use Arrays.sort(nums) is that it uses quick sort and
        // that has a TC of n2 in worst case. However, Collections sort uses merge sort
        // which is always nlogn even in worst case.
        ArrayList<Integer> vals = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            vals.add(nums[i]);
        }
        Collections.sort(vals);
        for(int i=0;i<vals.size();i++){
            nums[i]=vals.get(i);
        }
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
