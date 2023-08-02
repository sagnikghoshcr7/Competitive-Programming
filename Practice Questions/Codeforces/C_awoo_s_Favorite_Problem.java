// JAI SHREE RAM
/*

░██████╗░█████╗░░██████╗░███╗░░██╗██╗██╗░░██╗░██████╗░██╗░░██╗░█████╗░░██████╗██╗░░██╗░█████╗░██████╗░███████╗
██╔════╝██╔══██╗██╔════╝░████╗░██║██║██║░██╔╝██╔════╝░██║░░██║██╔══██╗██╔════╝██║░░██║██╔══██╗██╔══██╗╚════██║
╚█████╗░███████║██║░░██╗░██╔██╗██║██║█████═╝░██║░░██╗░███████║██║░░██║╚█████╗░███████║██║░░╚═╝██████╔╝░░░░██╔╝
░╚═══██╗██╔══██║██║░░╚██╗██║╚████║██║██╔═██╗░██║░░╚██╗██╔══██║██║░░██║░╚═══██╗██╔══██║██║░░██╗██╔══██╗░░░██╔╝░
██████╔╝██║░░██║╚██████╔╝██║░╚███║██║██║░╚██╗╚██████╔╝██║░░██║╚█████╔╝██████╔╝██║░░██║╚█████╔╝██║░░██║░░██╔╝░░
╚═════╝░╚═╝░░╚═╝░╚═════╝░╚═╝░░╚══╝╚═╝╚═╝░░╚═╝░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░░╚═╝░░░

*/

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;

public class C_awoo_s_Favorite_Problem {
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
        fs.nextInt();
        String s = fs.next();
        String t = fs.next();
    
        prtYesNo(solve(s, t));
    }

    private static boolean solve(String s, String t) {
        return hasSameNum(s, t, 'a')
                && hasSameNum(s, t, 'b')
                && hasSameNum(s, t, 'c')
                && s.replace("b", "").equals(t.replace("b", ""))
                && checkRelativeOrder(s.replace("c", ""), t.replace("c", ""), 'a', 'b')
                && checkRelativeOrder(s.replace("a", ""), t.replace("a", ""), 'b', 'c');
    }

    private static boolean hasSameNum(String s, String t, char target) {
        return s.chars().filter(c -> c == target).count() == t.chars().filter(c -> c == target).count();
    }

    private static boolean checkRelativeOrder(String s1, String s2, char left, char right) {
        int delta = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == left && s2.charAt(i) == right) ++delta;
            else if (s1.charAt(i) == right && s2.charAt(i) == left) {
                --delta;
                if (delta == -1) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException { int t = fs.nextInt(); while(t-->0) sagnik(); out.flush(); }  // Make t = 1 baby

    // dont worry bout me, i'm not high
    private static int arrMax(int[] A) {return Arrays.stream(A).max().getAsInt();}
    private static int arrMin(int[] A) {return Arrays.stream(A).min().getAsInt();}
    private static int arrSum(int[] A) {return Arrays.stream(A).sum();}
    private static int countNumInArr(int[] A, int n) {return (int) Arrays.stream(A).filter(x -> x == n).count();}
    private static void swap(int[] A, int i, int j) { int temp = A[i]; A[i] = A[j]; A[j] = temp; }
    private static void reverse(int[] A) {int s=0,e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s) {int e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s, int e) {while(s<e){swap(A,s,e);s++;e--;}}

    private static int countSetBits(int number){int count=0; while(number>0){++count; number &= number-1;} return count;}

    private static boolean isEven(int i) { return (i & 1) == 0; }
    private static boolean isVowel(char c) { return c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U';}
    private static boolean isSorted (int[] a, int s, int e) { for(int i=s; i<e-1; i++) if(a[i]>a[i+1]) return false; return true; }
    private static boolean isRevSorted (int[] a, int s, int e) { for(int i=s; i<e-1; i++) if(a[i]<a[i+1]) return false; return true; }
    private static boolean isPrime(int x) {if(x==1) return false; for(int i=2; i*i<=x; i++){if(x%i==0) return false;} return true;}
    private static boolean[] genSieve(int n) {boolean[] A = new boolean[n+1]; Arrays.fill(A, true); A[0]=A[1]=false; for(int p=2; p<=n; p++) if(A[p] && (long)p*p<=n) for (int i=p*p; i<=n; i+=p) A[i]=false; return A;}

    private static int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b) {return (a*b)/gcd(a, b);}
    private static int[] listToArr(List<Integer> x) {return x.stream().mapToInt(i -> i).toArray();}
    private static String[] dynamicListToArr(List<String> x) {return x.toArray(new String[x.size()]);}

    private static int[] setArray(int n) {int A[]=new int[n]; for(int i=0;i<n;i++) A[i]=sc.nextInt(); return A;}
    private static long[] lsetArray(int n) {long A[]=new long[n]; for(int i=0;i<n;i++) A[i]=sc.nextLong(); return A;}
    private static int[][] set2dArray(int n, int m) {int[][] a = new int[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = sc.nextInt(); return a;}
    private static long[][] lset2dArray(int n, int m) {long[][] a = new long[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = sc.nextLong(); return a;}
    // private static char[][] set2sCharArray(int n, int m) {char[][] a = new char[n][m]; for (int i=0; i<n; i++) {String s = sc.next(); for (int j=0; j<m; j++) a[i][j] = s.charAt(j);} return a;}
    private static char[][] set2sCharArray(int n, int m) {char[][] a = new char[n][m]; for(int i=0; i<n; i++) {char[] c = sc.next().toCharArray(); a[i] = c;} return a;}

    private static void prtList(List<Integer> x) {for(int i : x) {System.out.print(i+" ");}}
    private static void prtArr(int[] A) {for(int i=0;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtYesNo(boolean c) {System.out.println(c ? "YES" : "NO");}

    private static void debug(Object... o) {if(o.length != 0) System.err.println(Arrays.deepToString(o)); else System.err.println();}

    // DecimalFormat df = new DecimalFormat("#.###");
    // DecimalFormat df = new DecimalFormat(); df.setMaximumFractionDigits(12);
    // System.out.println(df.format(input_Decimal_Here));

    // fastIO cos why not
    public static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        private static String next() throws IOException {while(!st.hasMoreTokens()) try {st=new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();} return st.nextToken();}

        private static int[] setArray(int n) throws IOException {int[] a = new int[n]; for (int i=0; i<n; i++) a[i] = nextInt(); return a;}
        private static long[] lsetArray(int n) throws IOException {long a[] = new long[n]; for(int i=0; i<n; i++) a[i] = nextLong(); return a;}
        private static int[][] set2dArray(int n, int m) throws IOException {int[][] a = new int[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = fs.nextInt(); return a;}
        private static long[][] lset2dArray(int n, int m) throws IOException {long[][] a = new long[n][m]; for (int i=0; i<n; i++) for (int j=0; j<m; j++) a[i][j] = fs.nextLong(); return a;}
        // private static char[][] set2sCharArray(int n, int m) throws IOException {char[][] a = new char[n][m]; for (int i=0; i<n; i++) {String s = fs.next(); for (int j=0; j<m; j++) a[i][j] = s.charAt(j);} return a;}
        private static char[][] set2sCharArray(int n, int m) throws IOException {char[][] a = new char[n][m]; for(int i=0; i<n; i++) {char[] c = fs.next().toCharArray(); a[i] = c;} return a;}

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