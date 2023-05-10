import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;
 
public class Template3 {
    static private final String INPUT = "input.txt";
    static private final String OUTPUT = "output.txt";
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PrintWriter out = new PrintWriter(System.out);
    static DecimalFormat df = new DecimalFormat("0.00000");
    final static int mod = (int) (1e9 + 7);
    final static int MAX = Integer.MAX_VALUE;
    final static int MIN = Integer.MIN_VALUE;
    final static long INF = Long.MAX_VALUE;
    final static long NEG_INF = Long.MIN_VALUE;
    static Random rand = new Random();
 
    // ======================= MAIN ==================================
 
    public static void main(String[] args) throws IOException {
        long time = System.currentTimeMillis();
        boolean oj = System.getProperty("ONLINE_JUDGE") != null;
 
        // ==== start ====
 
        input();
        preprocess();
        int t = 1;
        // t = readInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
 
        // ==== end ====
 
        if (!oj)
            System.out.println(Arrays.deepToString(new Object[] { System.currentTimeMillis() - time + " ms" }));
    }
 
    private static void solve() throws IOException {
        int n = readInt();
        int m = readInt();
        String ans ="";
        if(n==m){
            while(n-->0){
                ans+="GB";
            }
        }else if(n>m){
            while(n-->0){
                if(m>0){
                    ans+="BG";
                    m--;
                }else{
                    ans+="B";
                }
            }
        }else{
            while(m-->0){
                if(n>0){
                    ans+="GB";n--;
                }else{
                    ans+="G";
                }
            }
        }
        System.out.println(ans);
    }
 
    private static void preprocess() throws IOException {
 
    }
 
    // cd C:\Users\Sanskar Agarwal\Visual Studio Code\Competitive Programming\CodeForces
    // javac CodeForces.java
    // java CodeForces
    // javac CodeForces.java && java CodeForces
 
    // ==================== CUSTOM CLASSES ================================
 
    static class Pair {
        int first, second;
 
        Pair(int f, int s) {
            first = f;
            second = s;
        }
 
        public int compareTo(Pair o) {
            if (this.first == o.first)
                return this.second - o.second;
            return this.first - o.first;
        }
 
        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj == null)
                return false;
            if (this.getClass() != obj.getClass())
                return false;
            Pair other = (Pair) (obj);
            if (this.first != other.first)
                return false;
            if (this.second != other.second)
                return false;
            return true;
 
        }
 
        @Override
        public int hashCode() {
            return this.first ^ this.second;
        }
 
        @Override
        public String toString() {
            return this.first + " " + this.second;
        }
    }
 
    static class DequeNode {
        DequeNode prev, next;
        int val;
 
        DequeNode(int val) {
            this.val = val;
        }
 
        DequeNode(int val, DequeNode prev, DequeNode next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
 
    // ======================= FOR INPUT ==================================
 
    private static void input() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
            System.err.println("Error Occurred.");
        }
 
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }
 
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(readLine());
        return st.nextToken();
    }
 
    static long readLong() throws IOException {
        return Long.parseLong(next());
    }
 
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }
 
    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }
 
    static char readCharacter() throws IOException {
        return next().charAt(0);
    }
 
    static String readString() throws IOException {
        return next();
    }
 
    static String readLine() throws IOException {
        return br.readLine().trim();
    }
 
    static int[] readIntArray(int n) throws IOException {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = readInt();
        return arr;
    }
 
    static int[][] read2DIntArray(int n, int m) throws IOException {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++)
            arr[i] = readIntArray(m);
        return arr;
    }
 
    static List<Integer> readIntList(int n) throws IOException {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(readInt());
        return list;
    }
 
    static long[] readLongArray(int n) throws IOException {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = readLong();
        return arr;
    }
 
    static long[][] read2DLongArray(int n, int m) throws IOException {
        long[][] arr = new long[n][m];
        for (int i = 0; i < n; i++)
            arr[i] = readLongArray(m);
        return arr;
    }
 
    static List<Long> readLongList(int n) throws IOException {
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(readLong());
        return list;
    }
 
    static char[] readCharArray(int n) throws IOException {
        return readString().toCharArray();
    }
 
    static char[][] readMatrix(int n, int m) throws IOException {
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++)
            mat[i] = readCharArray(m);
        return mat;
    }
 
    // ========================= FOR OUTPUT ==================================
 
    private static void printIList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }
 
    private static void printLList(List<Long> list) {
        for (int i = 0; i < list.size(); i++)
            out.print(list.get(i) + " ");
        out.println(" ");
    }
 
    private static void printIArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }
 
    private static void print2DIArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printIArray(arr[i]);
    }
 
    private static void printLArray(long[] arr) {
        for (int i = 0; i < arr.length; i++)
            out.print(arr[i] + " ");
        out.println(" ");
    }
 
    private static void print2DLArray(long[][] arr) {
        for (int i = 0; i < arr.length; i++)
            printLArray(arr[i]);
    }
 
    private static void yes() {
        out.println("YES");
    }
 
    private static void no() {
        out.println("NO");
    }
 
    // ====================== TO CHECK IF STRING IS NUMBER ========================
 
    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
 
    private static boolean isLong(String s) {
        try {
            Long.parseLong(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
 
    // ==================== FASTER SORT ================================
 
    private static void sort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
 
    private static void reverseSort(int[] arr) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
 
    private static void sort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list);
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
 
    private static void reverseSort(long[] arr) {
        int n = arr.length;
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(arr[i]);
        Collections.sort(list, Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            arr[i] = list.get(i);
    }
 
    // ==================== MATHEMATICAL FUNCTIONS ===========================
    private static void swap(int[] x, int i, int j) {
                        final int t = x[i];
                        x[i] = x[j];
                       x[j] = t;
                   }
 
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
 
    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
 
    private static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
 
    private static int mod_pow(long a, long b, int mod) {
        if (b == 0)
            return 1;
        int temp = mod_pow(a, b >> 1, mod);
        temp %= mod;
        temp = (int) ((1L * temp * temp) % mod);
        if ((b & 1) == 1)
            temp = (int) ((1L * temp * a) % mod);
        return temp;
    }
 
    private static int multiply(int a, int b) {
        return (int) ((((1L * a) % mod) * ((1L * b) % mod)) % mod);
    }
 
    private static int divide(int a, int b) {
        return multiply(a, mod_pow(b, mod - 2, mod));
    }
 
    private static boolean isPrime(long n) {
        for (long i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
 
    private static long nCr(long n, long r) {
        if (n - r > r)
            r = n - r;
        long ans = 1L;
        for (long i = r + 1; i <= n; i++)
            ans *= i;
        for (long i = 2; i <= n - r; i++)
            ans /= i;
        return ans;
    }
 
    private static List<Integer> factors(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; 1L * i * i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i);
            }
        return list;
    }
 
    private static List<Long> factors(long n) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++)
            if (n % i == 0) {
                list.add(i);
                if (i != n / i)
                    list.add(n / i);
            }
        return list;
    }
 
    // ==================== Primes using Seive =====================
 
    private static List<Integer> getPrimes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int i = 2; 1L * i * i <= n; i++)
            if (prime[i])
                for (int j = i * i; j <= n; j += i)
                    prime[j] = false;
        // return prime;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (prime[i])
                list.add(i);
        return list;
    }
 
    private static int[] SeivePrime(int n) {
        int[] primes = new int[n];
        for (int i = 0; i < n; i++)
            primes[i] = i;
        for (int i = 2; 1L * i * i < n; i++) {
            if (primes[i] != i)
                continue;
            for (int j = i * i; j < n; j += i)
                if (primes[j] == j)
                    primes[j] = i;
        }
        return primes;
    }
 
    // ==================== STRING FUNCTIONS ================================
 
    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j)
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        return true;
    }
 
    // check if a is subsequence of b
    private static boolean isSubsequence(String a, String b) {
        int idx = 0;
        for (int i = 0; i < b.length() && idx < a.length(); i++)
            if (a.charAt(idx) == b.charAt(i))
                idx++;
        return idx == a.length();
    }
 
    private static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
 
    private static String sortString(String str) {
        int[] arr = new int[256];
        for (char ch : str.toCharArray())
            arr[ch]++;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            while (arr[i]-- > 0)
                sb.append((char) i);
        return sb.toString();
    }
 
    // ==================== LIS & LNDS ================================
 
    private static int LIS(int arr[], int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = find1(list, arr[i]);
            if (idx < list.size())
                list.set(idx, arr[i]);
            else
                list.add(arr[i]);
        }
        return list.size();
    }
 
    private static int find1(List<Integer> list, int val) {
        int ret = list.size(), i = 0, j = list.size() - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (list.get(mid) >= val) {
                ret = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ret;
    }
 
    private static int LNDS(int[] arr, int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int idx = find2(list, arr[i]);
            if (idx < list.size())
                list.set(idx, arr[i]);
            else
                list.add(arr[i]);
        }
        return list.size();
    }
 
    private static int find2(List<Integer> list, int val) {
        int ret = list.size(), i = 0, j = list.size() - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (list.get(mid) <= val) {
                i = mid + 1;
            } else {
                ret = mid;
                j = mid - 1;
            }
        }
        return ret;
    }
 
    // =============== Lower Bound & Upper Bound ===========
 
    // less than or equal
    private static int upper_bound(List<Integer> list, int val) {
        int ans = -1, lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= val) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
 
    private static int upper_bound(List<Long> list, long val) {
        int ans = -1, lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) <= val) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
 
    private static int upper_bound(int[] arr, int val) {
        int ans = -1, lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= val) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
 
    private static int upper_bound(long[] arr, long val) {
        int ans = -1, lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] <= val) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
 
    // greater than or equal
    private static int lower_bound(List<Integer> list, int val) {
        int ans = list.size(), lo = 0, hi = ans - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= val) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
 
    private static int lower_bound(List<Long> list, long val) {
        int ans = list.size(), lo = 0, hi = ans - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) >= val) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
 
    private static int lower_bound(int[] arr, int val) {
        int ans = arr.length, lo = 0, hi = ans - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= val) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
 
    private static int lower_bound(long[] arr, long val) {
        int ans = arr.length, lo = 0, hi = ans - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= val) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}