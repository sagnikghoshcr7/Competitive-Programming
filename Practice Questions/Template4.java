/*
Lord, I thank you for sunshine, thank you for rain
thank you for joy, thank you for pain
*/

import java.io.*;
import java.util.*;
 class Template4 {


    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        outer: for (int tt = 0; tt < T; ++tt) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int[] pos = new int[n + 1];
            for(int i = 0; i< n; ++i){
                pos[a[i]] = i;
            }

            int l = n;
            int r = -1;
            int ans =0;
            for(int i = n; i > 1; --i){
                l = Math.min(l, pos[i]);
                r = Math.max(r, pos[i]);
                if(r - l + 1 == n - i + 1){

                    ans = r - l + 1;
                }
            }
            System.out.println(ans);

        }


    }

    static final Random random = new Random();
    static final int mod = 1_000_000_007;
    static final int MAXN = 1000001;
    static int spf[] = new int[MAXN];

    static void sieve() {
        spf[1] = 1;
        for (int i = 2; i < MAXN; i++) spf[i] = i;
        for (int i = 4; i < MAXN; i += 2) spf[i] = 2;

        for (int i = 3; i * i < MAXN; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < MAXN; j += i) if (spf[j] == j) spf[j] = i;
            }
        }
    }

    static ArrayList<Integer> getFactorization(int x) {
        ArrayList<Integer> set = new ArrayList<>();
        while (x != 1) {
            set.add(spf[x]);
            x = x / spf[x];
        }
        return set;
    }

    static long add(long a, long b) {
        return (a + b) % mod;
    }

    static long sub(long a, long b) {
        return ((a - b) % mod + mod) % mod;
    }

    static void ruffleSort(int[] a) {
        int n = a.length;//shuffle, then sort
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n), temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }

    static long mul(long a, long b) {
        return (a * b) % mod;
    }

    static long exp(long base, long exp) {
        if (exp == 0) return 1;
        long half = exp(base, exp / 2);
        if (exp % 2 == 0) return mul(half, half);
        return mul(half, mul(half, base));
    }

    static long[] factorials = new long[2_000_001];
    static long[] invFactorials = new long[2_000_001];

    static void precompFacts() {
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++) factorials[i] = mul(factorials[i - 1], i);
        invFactorials[factorials.length - 1] = exp(factorials[factorials.length - 1], mod - 2);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = mul(invFactorials[i + 1], i + 1);
    }

    static long nCk(int n, int k) {
        return mul(factorials[n], mul(invFactorials[k], invFactorials[n - k]));
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}