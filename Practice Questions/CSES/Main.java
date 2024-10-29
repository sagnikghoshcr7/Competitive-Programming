// JAI SHREE RAM

import java.util.*;
import java.math.BigInteger;
import java.io.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
    static final Random random = new Random();
    static StringBuilder sb = new StringBuilder();
    static final int mod = 1_000_000_007;
    static final int MAXN = 1000001;
    static final long INF = (long) 1e10;
    static final int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };
    static final int[] dx8 = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy8 = { -1, 0, 1, -1, 1, -1, 0, 1 };
    static final int[] dx9 = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dy9 = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    static final double eps = 1e-10;
    static long [] larr = new long[100001];
    static int cnt = 0, tmpSum = 0;

    private static void sagnik() throws IOException {
        int n = fs.nextInt(), m = fs.nextInt(), k = fs.nextInt();
        int[] ppl = fs.setArray(n);
        int[] flat = fs.setArray(m);

        Arrays.sort(ppl); Arrays.sort(flat);

        int i=0, j=0, ans=0;
        while (i < n && j < m) {
            // Found a suitable apartment for the applicant
            if (Math.abs(ppl[i] - flat[j]) <= k) {
                i++; j++; ans++;
            } else {
                // If the desired apartment size of the applicant is too big,
                // move the apartment pointer to the right to find a bigger one
                if (ppl[i] - flat[j] > k) j++;
                // If the desired apartment size is too small,
                // skip that applicant and move to the next person
                else i++;
            }
        }

        out.print(ans);
    }

    public static void main(String[] args) throws IOException { int t = 1; while(t-->0) sagnik(); out.flush(); }  // Make t = 1 baby

    // fastIO cos why not
    public static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        private static String next() throws IOException {while(!st.hasMoreTokens()) try {st=new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();} return st.nextToken();}

        private static int[] setArray(int n) throws IOException {int[] a = new int[n]; for (int i=0; i<n; i++) a[i] = nextInt(); return a;}
        private static long[] lsetArray(int n) throws IOException {long a[] = new long[n]; for(int i=0; i<n; i++) a[i] = nextLong(); return a;}
        private static int[][] set2dArray(int n, int m) throws IOException {int[][] a = new int[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = fs.nextInt(); return a;}
        private static long[][] lset2dArray(int n, int m) throws IOException {long[][] a = new long[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = fs.nextLong(); return a;}
        // private static char[][] set2dCharArray(int n, int m) throws IOException {char[][] a = new char[n][m]; for (int i=0; i<n; i++) {String s = fs.next(); for (int j=0; j<m; j++) a[i][j] = s.charAt(j);} return a;}
        private static char[][] set2dCharArray(int n, int m) throws IOException {char[][] a = new char[n][m]; for(int i=0; i<n; i++) {char[] c = fs.next().toCharArray(); a[i] = c;} return a;}

        private static int nextInt() throws IOException {return Integer.parseInt(next());}
        private static Long nextLong() throws IOException {return Long.parseLong(next());}
        private static double nextDouble() throws IOException {return Double.parseDouble(next());}
        private static char nextChar() throws IOException {return next().toCharArray()[0];}
        private static String nextString() throws IOException {return next();}
        private static String nextLine() throws IOException {return br.readLine();}
        private static String nextToken() throws IOException {while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();}} return st.nextToken();}
        private static BigInteger nextBigInteger() throws IOException {return new BigInteger(next());}
    }
}