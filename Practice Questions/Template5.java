/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Template5 {
    static long sumall = 0;
    static int pos = -1;
    static int or = 0;
    static long mod = 1000000007;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    // static HashSet<Long> set = new HashSet<>();
    static BufferedWriter put = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws java.lang.Exception {
        FastReader get = new FastReader();

        int Tt = get.nextInt();
        // int Tt = 1;
        while (Tt-- > 0) {
            int n = get.nextInt();
            // int m = get.nextInt();
            // long k = get.nextLong();

            // int s = get.nextInt();

            // sumall = 0;

            // max = Long.MIN_VALUE;
            // min = Long.MAX_VALUE;
            int[] a = readArr(n, get);
            // // int[] b = readArr(n, get);

            // long[] a = readArr2(n, get);
            // long[] b = readArr2(m, get);

            ans(a, n, get);
            // set.clear();
            // ans(h,w,get);
            put.flush();
        }

        put.close();
    }

    static long countSubarray(int A[], int n, int k) {
        long res = 0, cur = 0;
        for (int j = 0, i = 0; j < A.length; ++j) {
            cur += A[j];
            while (cur * (j - i + 1) >= k)
                cur -= A[i++];
            res += j - i + 1;
        }
        return res;
    }

    static int countSubarray2(int arr[], int n, int k) {
        int start = 0, end = 0;
        int count = 0, sum = arr[0];

        while (start < n && end < n) {

            if (sum > k) {
                end++;

                if (end >= start)
                    count += end - start;

                if (end < n)
                    sum += arr[end];
            }

            else {
                sum -= arr[start];
                start++;
            }
        }

        return count;
    }

    public static void ans(int a[], int n, FastReader f) throws java.lang.Exception {
        // long p=countSubarray(a, n, 0);
        int pos[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[a[i]] = i;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(n);

        int l = n + 1, r = -1;
        l = r = pos[n];
        int ans = 0, max = n;

        for (int i = n - 1; i >= 1; i--) {
            int pre = max;
            while (!(l <= pos[i] && pos[i] <= r)) {
                if (pos[i] < l) {
                    l--;
                    set.add(a[l]);
                    max = Math.min(max, a[l]);
                }
                if (pos[i] > r) {
                    r++;
                    set.add(a[r]);
                    max = Math.min(max, a[r]);
                }
            }
            if ((n - max + 1) == set.size() && set.size() != n) {
                ans = Math.max(ans, set.size());
            }
        }
        System.out.println(Math.max(1, ans));
    }

    static long modInv(long p, long q) {
        long ex = mod - 2;
        while (ex > 0) {
            if ((ex & 1) != 0)
                p = p * q % mod;
            q = q * q % mod;

            ex >>= 1;
        }
        return p;
    }

    static int binarySearch(int a[][], int x, int l) {
        int r = a.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (a[m][0] == x)
                return m;

            // If x greater, ignore left half
            if (a[m][0] < x)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        return -1;
    }

    static int firstMissingPositive(int arr[], int n) {
        int ptr = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                ptr = 1;
                break;
            }
        }

        if (ptr == 0)
            return (1);

        for (int i = 0; i < n; i++)
            if (arr[i] <= 0 || arr[i] > n)
                arr[i] = 1;

        for (int i = 0; i < n; i++)
            arr[(arr[i] - 1) % n] += n;

        for (int i = 0; i < n; i++)
            if (arr[i] <= n)
                return (i + 1);

        return (n + 1);
    }

    public static void primeFactors(int n, int arr[]) {
        while (n % 2 == 0) {
            // System.out.print(2 + " ");
            // arr.add(2);
            arr[0]++;
            n /= 2;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                // System.out.print(i + " ");
                // arr.add(i);
                arr[0]++;
                n /= i;
            }
        }
        if (n > 2) {
            // System.out.print(n);
            // arr.add(n);
            arr[0]++;
        }

    }

    public static long power2(long x, long y) {
        // 0^0 = 1
        long res = 1L;
        x = x;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x);
            y >>= 1;
            x = (x * x);
        }
        return res;
    }

    static int upper_bound(ArrayList<Long> a, long key) { // gives idx of equal or just lower value
        if (a.size() == 0)
            return -1;
        if (key < a.get(0)) {
            return -1;
        }
        int mid, N = a.size();

        int low = 0;
        int high = N;

        while (low < high && low != N) {

            mid = low + (high - low) / 2;

            if (key >= a.get(mid)) {
                low = mid + 1;
            }

            else {
                high = mid;
            }
        }
        if (low < a.size() && a.get(low) > key) {
            low--;
        }

        if (low == N) {

            return N - 1;
        }

        return low;
    }

    static int lower_bound(long array[], long key) // gives idx of equal or just greater element
    {
        if (key > array[array.length - 1])
            return -1;
        int low = 0, high = array.length;
        int mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (key <= array[mid]) {
                high = mid;
            } else {

                low = mid + 1;
            }
        }
        if (low < array.length && array[low] < key) {
            low++;
        }
        return low;
    }

    public static long power(long x, long y, long p) {
        // 0^0 = 1
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long smallest_pos_missing(long a[]) {
        HashSet<Long> set = new HashSet<>();
        for (long i : a) {
            set.add(i);
        }
        long num = 0;
        for (long i = 0;; i++) {
            if (!set.contains(i)) {
                num = i;
                break;
            }
        }
        return num;
    }

    // static class Pair {
    // long aa;
    // long bb;

    // public Pair(long aa, long bb) {
    // this.aa = aa;
    // this.bb = bb;
    // }
    // }

    // static class Pair {
    // int aa;
    // int bb;

    // public Pair(int aa, int bb) {
    // this.aa = aa;
    // this.bb = bb;
    // }

    // }

    // function to count no of perfect cubes within a and b
    static long countCubes(long a, long b) {
        return (long) (Math.floor(Math.cbrt(b)) -
                Math.ceil(Math.cbrt(a)) + 1);
    }

    // function to count no of perfect squares within a and b
    static long countSquares(long a, long b) {
        return (long) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + 1);
    }

    static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    static void printLongArray(long a[]) {
        StringBuilder sb = new StringBuilder();
        for (long i : a) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static void printIntArray(int a[]) {
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static long fun(long n) {
        long st = 0, en = (long) 3e6;
        while (en - st > 1) {
            long mid = (st + en) / 2;
            if ((mid * mid * mid) > n)
                en = mid;
            else
                st = mid;
        }
        return st;
    }

    public static int[] readArr(int N, FastReader f) throws Exception {
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(f.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            // max = Math.max(arr[i], max);
            // min = Math.min(min, arr[i]);
        }

        return arr;
    }

    public static long[] readArr2(int N, FastReader f) throws Exception {
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(f.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            // max = Math.max(max, arr[i]);
            // min = Math.min(min, arr[i]);
        }

        return arr;
    }

    public static boolean isPrime(long n) {
        if (n < 2)
            return false;
        if (n == 2 || n == 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0)
                return false;
        }
        return true;
    }

    public static long totient(long n) {
        long result = n;
        for (int p = 2; p * p <= n; ++p)
            if (n % p == 0) {
                while (n % p == 0)
                    n /= p;
                result -= result / p;
            }
        if (n > 1)
            result -= result / n;

        return result;
    }

    public static ArrayList<Integer> findDiv(int N) {
        // gets all divisors of N
        ArrayList<Integer> ls1 = new ArrayList<Integer>();
        ArrayList<Integer> ls2 = new ArrayList<Integer>();
        for (int i = 1; i <= (int) (Math.sqrt(N) + 0.00000001); i++)
            if (N % i == 0) {
                ls1.add(i);
                ls2.add(N / i);
            }
        Collections.reverse(ls2);
        for (int b : ls2)
            if (b != ls1.get(ls1.size() - 1))
                ls1.add(b);
        return ls1;
    }

    public static void sort(int[] arr) {
        // because Arrays.sort() uses quicksort which is dumb
        // Collections.sort() uses merge sort

        ArrayList<Integer> ls = new ArrayList<Integer>();

        for (int x : arr)
            ls.add(x);

        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    int binary_search(int l, int h, int a[], int k) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (a[mid] == k) {
                return mid;
            }
            if (a[mid] > k) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // custom multiset (replace with HashMap if needed)
    public static void push(TreeMap<Integer, Integer> map, int k, int v) {
        // map[k] += v;
        if (!map.containsKey(k))
            map.put(k, v);
        else
            map.put(k, map.get(k) + v);
    }

    public static void pull(TreeMap<Integer, Integer> map, int k, int v) {
        // assumes map[k] >= v
        // map[k] -= v
        int lol = map.get(k);

        if (lol == v)
            map.remove(k);
        else
            map.put(k, lol - v);
    }

    public static HashMap<Integer, Integer> freqArr(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int x : arr)
            if (!map.containsKey(x))
                map.put(x, map.get(x) + 1);
            else
                map.put(x, 1);

        return map;
    }

    public static long[][] multiply(long[][] left, long[][] right) {
        long MOD = 1000000007L;
        int N = left.length;
        int M = right[0].length;
        long[][] res = new long[N][M];
        for (int a = 0; a < N; a++)
            for (int b = 0; b < M; b++)
                for (int c = 0; c < left[0].length; c++) {
                    res[a][b] += (left[a][c] * right[c][b]) % MOD;
                    if (res[a][b] >= MOD)
                        res[a][b] -= MOD;
                }
        return res;
    }

    public static long[][] power(long[][] grid, long pow) {
        long[][] res = new long[grid.length][grid[0].length];
        for (int i = 0; i < res.length; i++)
            res[i][i] = 1L;
        long[][] curr = grid.clone();
        while (pow > 0) {
            if ((pow & 1L) == 1L)
                res = multiply(curr, res);
            pow >>= 1;
            curr = multiply(curr, curr);
        }
        return res;
    }
}

class DSU {
    public int[] dsu;
    public int[] size;

    public DSU(int N) {
        dsu = new int[N + 1];
        size = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dsu[i] = i;
            size[i] = 1;
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
        for (l = 0; (1 << l) < length; l++)
            ;
        val = new int[1 << (l + 1)];
        this.length = 1 << l;
    }

    public void update(int index, int delta) {
        // replaces value
        int node = index - treeFrom + length;
        val[node] = delta;
        for (node >>= 1; node > 0; node >>= 1)
            val[node] = comb(val[node << 1], val[(node << 1) + 1]);
    }

    public int query(int from, int to) {
        // inclusive bounds
        if (to < from)
            return 0; // 0 or 1?
        from += length - treeFrom;
        to += length - treeFrom + 1;
        // 0 or 1?
        int res = 0;
        for (; from + (from & -from) <= to; from += from & -from)
            res = comb(res, val[from / (from & -from)]);
        for (; to - (to & -to) >= from; to -= to & -to)
            res = comb(res, val[(to - (to & -to)) / (to & -to)]);
        return res;
    }

    public int comb(int a, int b) {
        // change this
        return Math.max(a, b);
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
        for (b = 0; (1 << b) < length; b++)
            ;
        tree = new int[1 << (b + 1)];
        lazy = new int[1 << (b + 1)];
    }

    public int query(int left, int right) {
        // left and right are 0-indexed
        return get(1, 0, length - 1, left, right);
    }

    private int get(int v, int currL, int currR, int L, int R) {
        if (L > R)
            return NULL;
        if (L <= currL && currR <= R)
            return tree[v];
        propagate(v);
        int mid = (currL + currR) / 2;
        return comb(get(v * 2, currL, mid, L, Math.min(R, mid)),
                get(v * 2 + 1, mid + 1, currR, Math.max(L, mid + 1), R));
    }

    public void update(int left, int right, int delta) {
        add(1, 0, length - 1, left, right, delta);
    }

    private void add(int v, int currL, int currR, int L, int R, int delta) {
        if (L > R)
            return;
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
        if (lazy[v] == 0)
            return;
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
        if (to < from)
            return 0;
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
        for (int i = 2; i <= N + 1; i++)
            log[i] = log[i / 2] + 1;
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
        L--;
        R--;
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
            if (next != par)
                dfs(next, curr, time);
        exit[curr] = ++time[0];
    }

    public int lca(int x, int y) {
        if (isAnc(x, y))
            return x;
        if (isAnc(y, x))
            return y;
        int curr = x;
        for (int b = LOG - 1; b >= 0; b--) {
            int temp = dp[curr][b];
            if (!isAnc(temp, y))
                curr = temp;
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
        if (N % CONS == 0)
            sets = new long[N / CONS];
        else
            sets = new long[N / CONS + 1];
    }

    public void add(int i) {
        int dex = i / CONS;
        int thing = i % CONS;
        sets[dex] |= (1L << thing);
    }

    public int and(BitSet oth) {
        int boof = Math.min(sets.length, oth.sets.length);
        int res = 0;
        for (int i = 0; i < boof; i++)
            res += Long.bitCount(sets[i] & oth.sets[i]);
        return res;
    }

    public int xor(BitSet oth) {
        int boof = Math.min(sets.length, oth.sets.length);
        int res = 0;
        for (int i = 0; i < boof; i++)
            res += Long.bitCount(sets[i] ^ oth.sets[i]);
        return res;
    }
}

class MaxFlow {
    // Dinic with optimizations (see magic array in dfs function)
    public int N, source, sink;
    public ArrayList<Edge>[] edges;
    private int[] depth;

    public MaxFlow(int n, int x, int y) {
        N = n;
        source = x;
        sink = y;
        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            edges[i] = new ArrayList<Edge>();
        depth = new int[N + 1];
    }

    public void addEdge(int from, int to, long cap) {
        Edge forward = new Edge(from, to, cap);
        Edge backward = new Edge(to, from, 0L);
        forward.residual = backward;
        backward.residual = forward;
        edges[from].add(forward);
        edges[to].add(backward);
    }

    public long mfmc() {
        long res = 0L;
        int[] magic = new int[N + 1];
        while (assignDepths()) {
            long flow = dfs(source, Long.MAX_VALUE / 2, magic);
            while (flow > 0) {
                res += flow;
                flow = dfs(source, Long.MAX_VALUE / 2, magic);
            }
            magic = new int[N + 1];
        }
        return res;
    }

    private boolean assignDepths() {
        Arrays.fill(depth, -69);
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(source);
        depth[source] = 0;
        while (q.size() > 0) {
            int curr = q.poll();
            for (Edge e : edges[curr])
                if (e.capacityLeft() > 0 && depth[e.to] == -69) {
                    depth[e.to] = depth[curr] + 1;
                    q.add(e.to);
                }
        }
        return depth[sink] != -69;
    }

    private long dfs(int curr, long bottleneck, int[] magic) {
        if (curr == sink)
            return bottleneck;
        for (; magic[curr] < edges[curr].size(); magic[curr]++) {
            Edge e = edges[curr].get(magic[curr]);
            if (e.capacityLeft() > 0 && depth[e.to] - depth[curr] == 1) {
                long val = dfs(e.to, Math.min(bottleneck, e.capacityLeft()), magic);
                if (val > 0) {
                    e.augment(val);
                    return val;
                }
            }
        }
        return 0L; // no flow
    }

    private class Edge {
        public int from, to;
        public long flow, capacity;
        public Edge residual;

        public Edge(int f, int t, long cap) {
            from = f;
            to = t;
            capacity = cap;
        }

        public long capacityLeft() {
            return capacity - flow;
        }

        public void augment(long val) {
            flow += val;
            residual.flow -= val;
        }
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
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
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}