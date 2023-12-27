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

public class B_Pentagon {
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
        String s1 = fs.next(), s2 = fs.next();
        int dist1 = Math.abs(s1.charAt(0) - s1.charAt(1));
        int dist2 = Math.abs(s2.charAt(0) - s2.charAt(1));

        prtYesNo(dist1 == dist2 || dist1+dist2 == 5);
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
    private static long[] genPrefixArr(int[] a) {int n = a.length; long[] pf = new long[n]; pf[0] = a[0]; for (int i=1; i<n; i++) pf[i] = pf[i-1] + a[i]; return pf; }

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
    // private static char[][] set2dCharArray(int n, int m) {char[][] a = new char[n][m]; for (int i=0; i<n; i++) {String s = sc.next(); for (int j=0; j<m; j++) a[i][j] = s.charAt(j);} return a;}
    private static char[][] set2dCharArray(int n, int m) {char[][] a = new char[n][m]; for(int i=0; i<n; i++) {char[] c = sc.next().toCharArray(); a[i] = c;} return a;}

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

    class DSU {
        public int[] dsu;
        public int[] size;

        public DSU(int N) {
            dsu = new int[N + 1];
            size = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                dsu[i] = i; size[i] = 1;
            }
        }

        // with path compression, no find by rank
        public int find(int x) {
            return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
        }

        public void merge(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            dsu[fx] = fy;
        }

        public void merge(int x, int y, boolean sized) {
            int fx = find(x);
            int fy = find(y);
            size[fy] += size[fx];
            dsu[fx] = fy;
        }
    }

    class FenwickTree {
        // Binary Indexed Tree
        // 1 indexed
        public int[] tree;
        public int size;

        public FenwickTree(int size) {
            this.size = size;
            tree = new int[size + 5];
        }

        public void add(int i, int v) {
            while (i <= size) {
                tree[i] += v;
                i += i & -i;
            }
        }

        public int find(int i) {
            int res = 0;
            while (i >= 1) {
                res += tree[i];
                i -= i & -i;
            }
            return res;
        }

        public int find(int l, int r) {
            return find(r) - find(l - 1);
        }
    }

    class SegmentTree {
        // Tlatoani's segment tree
        // iterative implementation = low constant runtime factor
        // range query, non lazy
        final int[] val;
        final int treeFrom;
        final int length;

        public SegmentTree(int treeFrom, int treeTo) {
            this.treeFrom = treeFrom;
            int length = treeTo - treeFrom + 1;
            int l;
            for (l = 0; (1 << l) < length; l++);
            val = new int[1 << (l + 1)];
            this.length = 1 << l;
        }

        public void update(int index, int delta) {
            // replaces value
            int node = index - treeFrom + length;
            val[node] = delta;
            for (node >>= 1; node > 0; node >>= 1) val[node] = comb(val[node << 1], val[(node << 1) + 1]);
        }

        public int query(int from, int to) {
            // inclusive bounds
            if (to < from) return 0; // 0 or 1?
            from += length - treeFrom;
            to += length - treeFrom + 1;
            // 0 or 1?
            int res = 0;
            for (; from + (from & -from) <= to; from += from & -from) res = comb(res, val[from / (from & -from)]);
            for (; to - (to & -to) >= from; to -= to & -to) res = comb(res, val[(to - (to & -to)) / (to & -to)]);
            return res;
        }

        public int comb(int a, int b) {
            return Math.max(a, b); // change this
        }
    }

    class LazySegTree {
        // definitions
        private int NULL = -1;
        private int[] tree;
        private int[] lazy;
        private int length;

        public LazySegTree(int N) {
            length = N;
            int b;
            for (b = 0; (1 << b) < length; b++);
            tree = new int[1 << (b + 1)];
            lazy = new int[1 << (b + 1)];
        }

        public int query(int left, int right) {
            return get(1, 0, length - 1, left, right); // left and right are 0-indexed
        }

        private int get(int v, int currL, int currR, int L, int R) {
            if (L > R) return NULL;
            if (L <= currL && currR <= R) return tree[v];
            propagate(v);
            int mid = (currL + currR) / 2;
            return comb(get(v * 2, currL, mid, L, Math.min(R, mid)), get(v * 2 + 1, mid + 1, currR, Math.max(L, mid + 1), R));
        }

        public void update(int left, int right, int delta) {
            add(1, 0, length - 1, left, right, delta);
        }

        private void add(int v, int currL, int currR, int L, int R, int delta) {
            if (L > R) return;
            if (currL == L && currR == R) {
                // exact covering
                tree[v] += delta;
                lazy[v] += delta;
                return;
            }
            propagate(v);
            int mid = (currL + currR) / 2;
            add(v * 2, currL, mid, L, Math.min(R, mid), delta);
            add(v * 2 + 1, mid + 1, currR, Math.max(L, mid + 1), R, delta);
            tree[v] = comb(tree[v * 2], tree[v * 2 + 1]);
        }

        private void propagate(int v) {
            // tree[v] already has lazy[v]
            if (lazy[v] == 0) return;
            tree[v * 2] += lazy[v];
            lazy[v * 2] += lazy[v];
            tree[v * 2 + 1] += lazy[v];
            lazy[v * 2 + 1] += lazy[v];
            lazy[v] = 0;
        }

        private int comb(int a, int b) {
            return Math.max(a, b);
        }
    }

    class RangeBit {
        // FenwickTree and RangeBit are faster than LazySegTree by constant factor
        final int[] value;
        final int[] weightedVal;

        public RangeBit(int treeTo) {
            value = new int[treeTo + 2];
            weightedVal = new int[treeTo + 2];
        }

        private void updateHelper(int index, int delta) {
            int weightedDelta = index * delta;
            for (int j = index; j < value.length; j += j & -j) {
                value[j] += delta;
                weightedVal[j] += weightedDelta;
            }
        }

        public void update(int from, int to, int delta) {
            updateHelper(from, delta);
            updateHelper(to + 1, -delta);
        }

        private int query(int to) {
            int res = 0;
            int weightedRes = 0;
            for (int j = to; j > 0; j -= j & -j) {
                res += value[j];
                weightedRes += weightedVal[j];
            }
            return ((to + 1) * res) - weightedRes;
        }

        public int query(int from, int to) {
            if (to < from) return 0;
            return query(to) - query(from - 1);
        }
    }

    class SparseTable {
        public int[] log;
        public int[][] table;
        public int N;
        public int K;

        public SparseTable(int N) {
            this.N = N;
            log = new int[N + 2];
            K = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
            table = new int[N][K + 1];
            sparsywarsy();
        }

        private void sparsywarsy() {
            log[1] = 0;
            for (int i = 2; i <= N + 1; i++) log[i] = log[i / 2] + 1;
        }

        public void lift(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n; i++)
                table[i][0] = arr[i];
            for (int j = 1; j <= K; j++)
                for (int i = 0; i + (1 << j) <= n; i++)
                    table[i][j] = Math.min(table[i][j - 1], table[i + (1 << (j - 1))][j - 1]);
        }

        public int query(int L, int R) {
            // inclusive, 1 indexed
            L--; R--;
            int mexico = log[R - L + 1];
            return Math.min(table[L][mexico], table[R - (1 << mexico) + 1][mexico]);
        }
    }

    class LCA {
        public int N, root;
        public ArrayDeque<Integer>[] edges;
        private int[] enter;
        private int[] exit;
        private int LOG = 17; // change this
        private int[][] dp;

        public LCA(int n, ArrayDeque<Integer>[] edges, int r) {
            N = n;
            root = r;
            enter = new int[N + 1];
            exit = new int[N + 1];
            dp = new int[N + 1][LOG];
            this.edges = edges;
            int[] time = new int[1];
            // change to iterative dfs if N is large
            dfs(root, 0, time);
            dp[root][0] = 1;
            for (int b = 1; b < LOG; b++)
                for (int v = 1; v <= N; v++)
                    dp[v][b] = dp[dp[v][b - 1]][b - 1];
        }

        private void dfs(int curr, int par, int[] time) {
            dp[curr][0] = par;
            enter[curr] = ++time[0];
            for (int next : edges[curr])
                if (next != par) dfs(next, curr, time);
            exit[curr] = ++time[0];
        }

        public int lca(int x, int y) {
            if (isAnc(x, y)) return x;
            if (isAnc(y, x)) return y;
            int curr = x;
            for (int b = LOG - 1; b >= 0; b--) {
                int temp = dp[curr][b];
                if (!isAnc(temp, y)) curr = temp;
            }
            return dp[curr][0];
        }

        private boolean isAnc(int anc, int curr) {
            return enter[anc] <= enter[curr] && exit[anc] >= exit[curr];
        }
    }

    class BitSet {
        private int CONS = 62; // safe
        public long[] sets;
        public int size;

        public BitSet(int N) {
            size = N;
            if (N % CONS == 0) sets = new long[N / CONS];
            else sets = new long[N / CONS + 1];
        }

        public void add(int i) {
            int dex = i / CONS;
            int thing = i % CONS;
            sets[dex] |= (1L << thing);
        }

        public int and(BitSet oth) {
            int boof = Math.min(sets.length, oth.sets.length);
            int res = 0;
            for (int i = 0; i < boof; i++) res += Long.bitCount(sets[i] & oth.sets[i]);
            return res;
        }

        public int xor(BitSet oth) {
            int boof = Math.min(sets.length, oth.sets.length);
            int res = 0;
            for (int i = 0; i < boof; i++) res += Long.bitCount(sets[i] ^ oth.sets[i]);
            return res;
        }
    }
}