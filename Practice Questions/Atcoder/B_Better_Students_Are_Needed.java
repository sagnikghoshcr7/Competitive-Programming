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

public class B_Better_Students_Are_Needed {
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

    static class People {
        int number;
        int a;
        int b;
        int sum;
 
        public People(int num, int a, int b) {
            this.number = num;
            this.a = a;
            this.b = b;
            this.sum = a + b;
        }
 
        int getNumber() {
            return this.number;
        }
 
        int getA() {
            return this.a;
        }
 
        int getB() {
            return this.b;
        }
 
        int getSum() {
            return this.sum;
        }
    }

    private static void sagnik() throws IOException {
        int n = fs.nextInt(), x = fs.nextInt(), y = fs.nextInt(), z = fs.nextInt();
        List<Integer> list_a = new ArrayList<>();
        List<Integer> list_b = new ArrayList<>();
        List<People> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            list_a.add(fs.nextInt());
        }
        for (int i = 0; i < n; i++) {
            list_b.add(fs.nextInt());
        }
 
        for (int i = 0; i < n; i++) {
            list.add(new People(i + 1, list_a.get(i), list_b.get(i)));
        }
 
        //sort by A
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o2.getA() == o1.getA()) {
                    return o1.getNumber() - o2.getNumber();
                } else {
                    return o2.getA() - o1.getA();
                }
            }
        });
        for (int i = 0; i < x; i++) {
            ans.add(list.get(i).getNumber());
            list.remove(i);
            i--;
            x--;
        }
 
 
        //sort by B
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o2.getB() == o1.getB()) {
                    return o1.getNumber() - o2.getNumber();
                } else {
                    return o2.getB() - o1.getB();
                }
            }
        });
        for (int i = 0; i < y; i++) {
            ans.add(list.get(i).getNumber());
            list.remove(i);
            i--;
            y--;
        }
 
 
        //sort by Sum
        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o2.getSum() == o1.getSum()) {
                    return o1.getNumber() - o2.getNumber();
                } else {
                    return o2.getSum() - o1.getSum();
                }
            }
        });
        for (int i = 0; i < z; i++) {
            ans.add(list.get(i).getNumber());
            list.remove(i);
            i--;
            z--;
        }
 
        Collections.sort(ans);
        for (int t:ans){
            out.println(t);
        }        
    }

    public static void main(String[] args) throws IOException { int t = 1; while(t-->0) sagnik(); out.flush(); }  // Make t = 1 baby

    // dont worry bout me, i'm not high
    private static int arrMax(int[] A) {return Arrays.stream(A).max().getAsInt();}
    private static int arrMin(int[] A) {return Arrays.stream(A).min().getAsInt();}
    private static long arrSum(int[] A) {long sum = 0; for(int i=0; i<A.length; i++) sum += A[i]; return sum;}
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
    private static int[] genPrefixArr(int[] a) {int n = a.length; int[] pf = new int[n]; pf[0] = a[0]; for (int i=1; i<n; i++) pf[i] = pf[i-1] + a[i]; return pf; }

    private static int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b) {return (a*b)/gcd(a, b);}
    private static long pow(long b, long p, long m) {long res = 1; while (p > 0) {if ((p & 1) == 1) res = (res * b) % m; b = (b * b) % m; p = p >> 1;} return res;}
    private static long sqrt(long x) {long l = 0, h = (long) (3e9), ans = 0; while (l <= h) {long mid = l + (h - l) / 2; if (mid * mid <= x) {ans = mid; l = mid + 1;} else h = mid - 1;} return ans;}
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
    private static void prtYesNo(boolean c) {System.out.println(c ? "Yes" : "No");} // {System.out.println(c ? "YES" : "NO");}

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