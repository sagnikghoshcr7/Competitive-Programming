import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;

public class C_Gap_Existence {
    private static void sagnik() throws IOException {
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] a = fs.setArray(n);

        Arrays.sort(a);
        for (int i=0; i<n; i++) {
            int temp = Arrays.binarySearch(a, a[i]-x);
            if (temp >= 0) {System.out.println("Yes"); return;}
        }
        System.out.println("No");
    }

    public static void main(String[] args) throws IOException { int t = 1; while(t-->0) sagnik(); }  // Make t = 1 baby

    static final Random random = new Random();
    static final int mod = 1_000_000_007;
    static final int MAXN = 1000001;
    static int _sieve[] = new int[MAXN];

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
    private static boolean isPrime(int x) {if(x==1) return false; for(int i=2; i*i<=x; i++){if(x%i==0) return false;} return true;}
    private static void genSieve() {_sieve[1] = 1; for (int i = 2; i < MAXN; i++) _sieve[i] = i; for (int i = 4; i < MAXN; i += 2) _sieve[i] = 2; for (int i = 3; i * i < MAXN; i++) if (_sieve[i] == i) for (int j = i * i; j < MAXN; j += i) if(_sieve[j] == j) _sieve[j] = i;}

    private static int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b) {return (a*b)/gcd(a, b);}
    private static int[] listToArr(List<Integer> x) {return x.stream().mapToInt(i -> i).toArray();}

    private static int[] setArray(int n) {int A[]=new int[n]; for(int i=0;i<n;i++) A[i]=sc.nextInt(); return A;}
    private static long[] lsetArray(int n) {long A[]=new long[n]; for(int i=0;i<n;i++) A[i]=sc.nextLong(); return A;}

    private static void prtList(List<Integer> x) {for(int i : x) {System.out.print(i+" ");}}
    private static void prtArr(int[] A) {System.out.println(Arrays.toString(A));}
    private static void prtArrWithSpce(int[] A) {for(int i=0;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtArrWithSpce(int[] A, int s) {for(int i=s;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtArrWithSpce(int[] A, int s, int e) {for(int i=s;i<=e;i++)System.out.print(A[i]+" ");}

    // DecimalFormat df = new DecimalFormat("#.###");
    // DecimalFormat df = new DecimalFormat(); df.setMaximumFractionDigits(12);
    // System.out.println(df.format(input_Decimal_Here));

    public static class FastScanner {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static StringTokenizer st = new StringTokenizer("");

        private static String next() throws IOException {while(!st.hasMoreTokens()) try {st=new StringTokenizer(br.readLine());} catch (IOException e) {e.printStackTrace();} return st.nextToken();}

        private static int[] setArray(int n) throws IOException {int[] a = new int[n]; for (int i=0; i<n; i++) a[i] = nextInt(); return a;}
        private static long[] lsetArray(int n) throws IOException {long a[] = new long[n]; for(int i=0; i<n; i++) a[i] = nextLong(); return a;}

        private static int nextInt() throws IOException {return Integer.parseInt(next());}
        private static Long nextLong() throws IOException {return Long.parseLong(next());}
        private static double nextDouble() throws IOException {return Double.parseDouble(next());}
        private static char nextChar() throws IOException {return next().toCharArray()[0];}
        private static String nextString() throws IOException {return next();}
        private static String nextLine() throws IOException {return br.readLine();}
    }

    static Scanner sc = new Scanner(System.in);
    static FastScanner fs = new FastScanner();
    static PrintWriter out = new PrintWriter(System.out);
}