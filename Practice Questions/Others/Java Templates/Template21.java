import java.util.*;
import java.io.*;
import java.math.*;
 
public
class Template21 {
    static PrintWriter out = new PrintWriter(System.out);
    static Scanner in;
    public static long MOD = 998244353;
    static int mod=(int)(1e9+7);
    static Set<String>set;
    static boolean prime[]=new boolean[100010];
    static int order[];
    //static long fact[];
    public static void main(String[] args) throws FileNotFoundException {
        in = new Scanner();
        int T = in.nextInt();

        while(T-->0) {
            solve();
        }
        out.close();
    }
    static void solve() {
        int n=in.nextInt();
        int a[]=new int[n];
        takeInput(a,n);
 
 
        List<List<Integer>>ind=new ArrayList<>();
        for(int i=0;i<101;i++){
            ind.add(new ArrayList<>());
        }
 
        for(int i=0;i<n;i++){
            ind.get(a[i]).add(i);
        }
        int max_frq_size=0;
        //int num=0;
        for(int i=0;i<101;i++){
            if(max_frq_size<ind.get(i).size()) {
 
                max_frq_size = ind.get(i).size();
            }
        }
        // System.out.println(max_frq_size);
 
        int b[]=new int[n];
        Arrays.fill(b,1);
        int k = 2;
        for (int x = 0; x <101; x++) {
            if ( ind.get(x).size() >= 2) {
                b[ind.get(x).get(0)] = k;
                k++;
                if (k > 3) {
                    break;
                }
            }
        }
        if (k <= 3) {
            out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                out.print(b[i] + " ");
            }
            out.println();
        }
    }
 
    //permutations
    static void string_Permutn(String str, String ans)
    {
 
        // If string is empty
        if (str.length() == 0) {
                set.add(new String(ans));
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
            // ith character of str
            char ch = str.charAt(i);
 
            // Rest of the string after excluding the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
 
            // Recursive call
            string_Permutn(ros, ans + ch);
        }
    }
 
    public static boolean next_Permutation_array(int[] data) {//generate next permutations  :  1423 -> 1432
        int i = data.length - 1;
        while (i > 0 && data[i] < data[i - 1]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        int j = data.length - 1;
        while (data[j] < data[i - 1]) {
            j--;
        }
        int temp = data[i - 1];
        data[i - 1] = data[j];
        data[j] = temp;
        Arrays.sort(data, i, data.length);
        return true;
    }
 
    //matrix difference
    static int matrix_diff(int[][] a, int[][] b, int[][] c, int[][] d) {
        int m = a.length, n = a[0].length;
        int cnt = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int cnt1 = a[i][j] + b[i][j] + c[i][j] + d[i][j];
                if (cnt1 == 1) cnt += 1;
                else if (cnt1 == 2) cnt += 2;
                else if (cnt1 == 3) cnt += 1;
            }
        }
        return cnt;
    }
 
 
 
    //palindrome
    public static boolean String_isPalindrome(String str){
        int start = 0, end = str.length()-1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    private static boolean array_Palindrome(int[] temp) {
        int l=0;
        int r=temp.length-1;
        while(l<=r){
            if(temp[l]!=temp[r])
                return false;
 
            l++;
            r--;
        }
        return true;
    }
 
    public static void generatePalindrome(ArrayList<Integer> list){
        int max = 1<<15;
        for(int i = 0; i < max; i++){
            String str = Integer.toString(i);
            if(String_isPalindrome(str)){
                list.add(i);
            }
        }
    }
 
    static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)return false;
        }
        return true;
    }
 
    //prime factors e.g  10 : (2, 5)
    private static Map<Integer,Integer> number_factor_freq(int x) {//used for frequency of prime factor calculation
        Map <Integer,Integer> ans = new HashMap<>();
        for (int i=2;i<=Math.sqrt(x);i++) {
            while (x%i==0) {
                if (ans.containsKey(i)) {
                    ans.put(i,ans.get(i)+1);
                }
                else {
                    ans.put(i,1);
                }
                x/=i;
            }
        }
        if (x!=1) {
            ans.put(x,1);
        }
        return ans;
    }
 
    public static void primeFactors(int n,ArrayList<Integer> al)
    {
        while (n%2==0)
        {
            al.add(2);
            n /= 2;
        }
 
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            while (n%i == 0)
            {
                al.add(i);
                n /= i;
            }
        }
        if (n > 2)
            al.add(n);
    }
 
    static class Pair{
        int first,sec;
        Pair(int first,int sec){
            this.first=first;
            this.sec=sec;
        }
    }
 
 
    //Binary Search
    private static int long_BS(long[] a, long smallTwo) {
        int l=0;
        int r=a.length-1;
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]<=smallTwo) {
                res = mid;
                l=mid+1;
            }
            else if(a[mid]>smallTwo)
                r=mid-1;
            else l=mid+1;
        }
        return res;
    }
    private static int BinarySearch(int[] a, int smallTwo) {
        int l=0;
        int r=a.length-1;
        int res=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(a[mid]<=smallTwo) {
                res = mid;
                l=mid+1;
            }
            else if(a[mid]>smallTwo)
                r=mid-1;
            else l=mid+1;
        }
        return res;
    }
 
    static boolean is_all_ele_equal(int a[]){
        int n=a.length;
        int s[]=new int[n];
        for(int i=0;i<n;i++){
            s[i]=a[i];
        }
        Arrays.sort(s);
        for(int i=0;i<a.length;i++){
            if(a[i]!=s[i])
                return false;
        }
        return true;
    }
 
    private static boolean isArraySorted(int[] arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }
 
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
 
    //to the power
    private static long pow(long a, long b, long m)
    {
        if(b == 0)
            return 1;
 
        long half = pow(a, b / 2, m);
        long prod = (half * half) % m;
 
        return b % 2 == 0 ? prod : (prod * a) % m;
    }
 
 
    //ncr
    private static long ncr(int n, int r, long m, long[] fact)
    {
        if(n < r)
            return 0;
 
        return (fact[n] * pow((fact[r] * fact[n - r]) % m, m - 2, m)) % m;
    }
    public static long power(long x, int y, int p)
    {
        // Initialize result
        long res = (long)1;
        // Update x if it is more than or equal to p
        x = x % p;
 
        while (y > 0) {
            // If y is odd, multiply x with result
            if (y % 2 == 1)
                res = (res * x) % p;
            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
    }
 
    // Returns n^(-1) mod p =  if we required 1/k (mod)   n!/ k! * (n-k)!
    public static long modInverse(long n, int p)  //important one
    {
        return power(n, p - 2, p);
    }
 
    // Returns nCr % p using Fermat's little theorem.
 
    public static long nCrModPFermat(long n, int r, int p)
    {
 
        if (n<r)
            return (long)0;
        // Base case
        if (r == 0)
            return (long)1;
 
        // Fill factorial array so that we can find all factorial of r, n and n-r
        long[] fac = new long[(int)n + 1];
        fac[0] = (long)1;
 
        for (int i = 1; i <= n; i++)
            fac[i] = fac[i - 1] *(long) i % p;
 
        return (fac[(int)n] * modInverse(fac[r], p) % p * modInverse(fac[(int)n - r], p) % p) % p;
    }
 
    static int[][] rotate_matrix_by_Left90(int[][] a) {
        int[][] b = new int[a[0].length][a.length];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[0].length; ++j) {
                b[a[0].length - 1 - j][i] = a[i][j];
            }
        }
        return b;
    }
 
    private static int[][] rotateMatrix(int[][] a, int n, int m) {
        int res[][]=new int[n][m];
        int new_r=0,new_c=0;
        for(int oldCol=n-1;oldCol>=0;oldCol--){
            new_c=0;
            for(int oldRow=0;oldRow<m;oldRow++){
                res[new_r][new_c]=a[oldRow][oldCol];
                new_c++;
            }
            new_r++;
        }
        return res;
    }
 
    static long sqrt(long v) {
        long st = (long) Math.sqrt(v);
        if (st * st < v) {
            st++;
        }
 
        return st;
    }
 
    //number of digit
    public static int num_digit(long n) {
        int result = 0;
        while (n > 0) {
            n /= 10;
            result++;
        }
        return result;
    }
//distance between two point
    public static double dist(long a, long b, long x, long y) {
        double val = (b - a) * (b - a) + (x - y) * (x - y);
        val = Math.sqrt(val);
        double other = x * x + a * a;
        other = Math.sqrt(other);
 
        return val + other;
    }
 
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
 
    public static long pow(long a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
 
        long val = pow(a, b / 2);
        if (b % 2 == 0) {
            return (val * val);
        } else {
            return (val * ((val * a)));
 
        }
    }
 
    //helper  functions
    static class MultiTreeSet<T> {
        //List<MultiTreeSet<Integer>> list1 = new ArrayList<>(n);
        TreeMap<T, Integer> map = new TreeMap<>();
        int size = 0;
 
        void add(T e) {
            map.put(e, map.getOrDefault(e, 0) + 1);
            size++;
        }
 
        void remove(T e) {
            if (e != null && map.containsKey(e)) {
                int val = map.get(e);
                if (val == 1) {
                    map.remove(e);
                } else {
                    map.put(e, val - 1);
                }
                size--;
            }
        }
 
        int sizeAll() {
            return size;
        }
 
        int sizeUnq() {
            return map.size();
        }
 
        boolean contains(T e) {
            return map.containsKey(e);
        }
 
        boolean isEmpty() {
            return size == 0;
        }
 
        T lower(T e) {
            return map.lowerKey(e);
        }
 
        T floor(T e) {
            return map.floorKey(e);
        }
 
        T higher(T e) {
            return map.higherKey(e);
        }
 
        T ceiling(T e) {
            return map.ceilingKey(e);
        }
 
        T first() {
            return map.firstKey();
        }
 
        T last() {
            return map.lastKey();
        }
 
        T pollFirst() {
            T e = map.firstKey();
            remove(e);
            return e;
        }
 
        T pollLast() {
            T e = map.lastKey();
            remove(e);
            return e;
        }
 
        List<T> toListUnq() {
            List<T> list = new ArrayList<>(map.size());
            list.addAll(map.keySet());
            return list;
        }
 
        List<T> toListAll() {
            List<T> list = new ArrayList<>(size);
            for (T e : map.keySet()) {
                int num = map.get(e);
                for (int i = 0; i < num; i++) {
                    list.add(e);
                }
            }
            return list;
        }
    }
 
    static Comparator<pair> cmpPair() {
        Comparator<pair> c = new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x < o2.x) {
                    return -1;
                } else {
                    if (o1.y > o2.y) {
                        return 1;
                    } else if (o1.y < o2.y) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        };
        return c;
 
    }
 
    static class pair {
        int x;int y;
        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
 
        @Override
        public String toString() {
            return x + " " + y;
        }
    }
 
    static void twoDInput(int a[][],int n,int m){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                a[i][j] = in.nextInt();
            }
        }
    }
    static void takeInput(int a[],int n){
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
    }
    static void longInput(long a[],int n){
        for(int i=0;i<n;i++){
            a[i]=in.nextLong();
        }
    }
 
    public static class Point {
        int x;
        int y;
        public Point(int start, int end) {
            this.x = start;
            this.y = end;
        }
        public String toString() {
            return x + " " + y;
        }
 
    }
 
    static class Scanner {
 
        static BufferedReader br;
        static StringTokenizer st;
 
        public Scanner() throws FileNotFoundException {
            // System.setOut(new PrintStream(new BufferedOutputStream(System.out), true));
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        }
 
        public String next() {
 
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public double nextDouble() {
            return Double.parseDouble(next());
        }
 
        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
 
        public boolean endLine() {
            try {
                String next = br.readLine();
                while (next != null && next.trim().isEmpty()) {
                    next = br.readLine();
                }
                if (next == null) {
                    return true;
                }
                st = new StringTokenizer(next);
                return st.hasMoreTokens();
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
 
}