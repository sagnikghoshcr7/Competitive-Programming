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

public class C_2_Dual_Hard_Version {
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
        int n = fs.nextInt();
        int[] arr = fs.setArray(n);
        int[] arr2 = Arrays.copyOf(arr, n);
        Arrays.sort(arr2);

        int min = arr2[0];
        int max = arr2[n-1];
        int neg = 0;
        int pos = 0;

        for(int i=0; i<n; i++) {
            if(arr[i]<0) neg++;
            else if(arr[i]>0) pos++;
        }

        StringBuilder sb = new StringBuilder();
        int counter = 0;

        int cmpneg = (int) (neg + Math.log(Math.abs(min))/Math.log(2));
        int cmppos = (int) (pos + Math.log(Math.abs(max))/Math.log(2));

        if(min >= 0 || max <= 0) {
            if(min >= 0) {
                for(int i=0; i<n-1; i++) {
                    int first = arr[i];
                    int second = arr[i+1];
                    if(second < first) {
                        arr[i+1] += arr[i];
                        counter++;
                        sb.append(i+2).append(" ").append(i+1).append("\n");
                    }
                }
            } else {
                for(int i=n-1; i>0; i--) {
                    int first = arr[i];
                    int second = arr[i-1];
                    if(second > first) {
                        arr[i-1] += arr[i];
                        counter++;
                        sb.append(i).append(" ").append(i+1).append("\n");
                    }
                }
            }
        } else if(cmpneg < cmppos) {
            int ptr = 0;
            while(arr[ptr]!=max) ptr++;
            while(arr[ptr]<Math.abs(min)) {
                counter++;
                arr[ptr]*=2;
                sb.append(ptr+1).append(" ").append(ptr+1).append("\n");
            }

            for(int i=0; i<n; i++) {
                if(arr[i]<0) {
                    int p = 0;
                    int ref = Integer.MAX_VALUE;

                    for(int u=0; u<n; u++) {
                        if(arr[u] >= -arr[i] && arr[u]<ref) {
                            ref = arr[u];
                            p = u;
                        }
                    }

                    arr[i] += arr[p];
                    counter++;
                    sb.append(i+1).append(" ").append(p+1).append("\n");
                }
            }

            for(int i=0; i<n-1; i++) {
                int first = arr[i];
                int second = arr[i+1];
                if(second < first) {
                    int dif = first-second;
                    int p = 0;
                    int ref = Integer.MAX_VALUE;

                    for(int u=0; u<n; u++) {
                        if(arr[u]>=dif && arr[u]<ref) {
                            ref = arr[u];
                            p = u;
                        }
                    }
                    arr[i+1] += arr[p];
                    counter++;
                    sb.append(i+2).append(" ").append(p+1).append("\n");
                }
            }

        } else {
            int ptr = 0;
            while(arr[ptr]!=min) ptr++;
            while(Math.abs(arr[ptr])<max) {
                counter++;
                arr[ptr] += arr[ptr];
                sb.append(ptr+1).append(" ").append(ptr+1).append("\n");
            }
            for(int i=0; i<n; i++) {
                if(arr[i]>0) {
                    int p = 0;
                    int ref = Integer.MIN_VALUE;

                    for(int u=0; u<n; u++) {
                        if(arr[u]<=-arr[i] && arr[u]>ref) {
                            ref = arr[u];
                            p = u;
                        }
                    }

                    arr[i] += arr[p];
                    counter++;
                    sb.append(i+1).append(" ").append(p+1).append("\n");
                }
            }

            for(int i=n-1; i>0; i--) {
                int first = arr[i];
                int second = arr[i-1];
                if(second > first) {
                    int dif = first-second;
                    int p = 0;
                    int ref = Integer.MIN_VALUE;

                    for(int u=0; u<n; u++) {
                        if(arr[u]<=dif && arr[u]>ref) {
                            ref = arr[u];
                            p = u;
                        }
                    }

                    arr[i-1] += arr[p];
                    counter++;
                    sb.append(i).append(" ").append(p+1).append("\n");
                }
            }
        }
        out.println(counter);
        out.println(sb);        
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

    private static void prtList(List<Integer> x) {for(int i : x) {System.out.print(i+" ");}}
    private static void prtArr(int[] A) {for(int i=0;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtYesNo(boolean c) {System.out.println(c ? "Yes" : "No");}

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