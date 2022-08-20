import java.util.*;
import java.io.*;


public class Main{
    /* declare some global variables */
    static FastReader scn;
    static FastWriter out;
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
    
 
    /* print functions for primitives */
    
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
    
    /* main function */
    public static void main(String[] hi) throws IOException{
        scn = new FastReader();
        out = new FastWriter();
        long startTimeProg = System.currentTimeMillis();
        long endTimeProg = Long.MAX_VALUE;
        int t = scn.nextInt();
        while(t--!=0){
            // do for each testcase
        }
        endTimeProg = System.currentTimeMillis();
        print("[finished : " + (endTimeProg - startTimeProg) + ".ms ]");
        
    }
}


