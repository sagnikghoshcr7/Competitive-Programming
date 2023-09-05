import java.io.*;
import java.util.*;

public class Template14 {

    static StringBuilder sb = new StringBuilder();
    static boolean outputFile = false;
    static long[] f = new long[40];

    public static void main(String[] args) throws Exception {
        Reader r = new Reader();
        int t = 1;
        t = r.nextInt();
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < 40; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        while (t-- > 0) {
            solve(r);
        }

        if (!outputFile) {
            if (sb.length() > 0) System.out.println(sb.deleteCharAt(sb.length() - 1));
        } else {
            FileOutputStream fos = new FileOutputStream("src\\cmp\\out.txt");
            fos.write(sb.toString().getBytes());
            fos.close();
        }
    }


    private static void solve(Reader sc) {
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] nums = new long[n + 2];
        for (int i = 0; i < n; i++) {
            nums[i + 1] = sc.nextLong();
        }
        if (nums[1] != 1) {
            println(1);
            return;
        }
        nums[n + 1] = (long) 1e18;
        long cnt = 1;
        ArrayList<Long> ans = new ArrayList<>();
        long d = 1;
        for (int i = 2; i <= n + 1; i++) {
            while (cnt + d < nums[i]) {
                cnt += d;
                ans.add(cnt);
                if (ans.size() > k) {
                    println(ans.get((int) k - 1));
                    return;
                }
            }
            d = i;
        }
    }


    static class Multiset<T> extends java.util.TreeMap<T, Long> {
        public Multiset() {
            super();
        }

        public Multiset(Comparator<? super T> comparator) {
            super(comparator);
        }

        public Multiset(java.util.List<T> list) {
            super();
            for (T e : list) this.addOne(e);
        }

        public long count(Object elm) {
            return getOrDefault(elm, 0L);
        }

        public void add(T elm, long amount) {
            if (!this.containsKey(elm)) put(elm, amount);
            else replace(elm, get(elm) + amount);
            if (this.count(elm) == 0) this.remove(elm);
        }

        public void addOne(T elm) {
            this.add(elm, 1);
        }

        public void removeOne(T elm) {
            this.add(elm, -1);
        }

        public void removeAll(T elm) {
            this.add(elm, -this.count(elm));
        }

        public static <T> Multiset<T> merge(Multiset<T> a, Multiset<T> b) {
            Multiset<T> c = new Multiset<>();
            for (T x : a.keySet()) c.add(x, a.count(x));
            for (T y : b.keySet()) c.add(y, b.count(y));
            return c;
        }
    }

    static class Reader {
        BufferedReader buf;
        StringTokenizer tok;

        Reader() {
            buf = new BufferedReader(new InputStreamReader(System.in));
        }

        Reader(InputStream in) {
            buf = new BufferedReader(new InputStreamReader(in));
        }

        boolean hasNext() {
            while (tok == null || !tok.hasMoreElements()) {
                try {
                    tok = new StringTokenizer(buf.readLine());
                } catch (Exception e) {
                    return false;
                }
            }
            return true;
        }

        String nextLine() {
            try {
                return buf.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        String next() {
            if (hasNext()) return tok.nextToken();
            return null;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] nextIntArrForSizeIndexOfOne(int size) {
            int[] nums = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                nums[i] = nextInt();
            }
            return nums;
        }

        int[] nextIntArrForSizeIndexOfZero(int size) {
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = nextInt();
            }
            return nums;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

    }

    private static void print(Object t) {
        sb.append(t);
    }

    private static void printf(Object t) {
        sb.append(t).append(" ");
    }

    private static void printf(Object... t) {
        for (Object s : t) {
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    private static void printf(String end, Object... t) {
        for (Object s : t) {
            sb.append(s).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(end);
    }

    private static void println(Object t) {
        sb.append(t).append("\n");
    }

    private static void println() {
        sb.append("\n");
    }

    private static <T> void printArr(long[] arr) {
        for (Object o : arr) {
            sb.append(o).append(" ");
        }
    }

    private static <T> void printArr(int[] arr) {
        for (Object o : arr) {
            sb.append(o).append(" ");
        }
    }

}



