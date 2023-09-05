import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        new Thread(null, () -> new Main().run(), "1", 1 << 23).start();
    }

    private void run() {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        Solution solve = new Solution();
        int t = scan.nextInt();
        //int t = 1;
        for (int qq = 0; qq < t; qq++) {
            solve.solve(scan, out);
//            out.println();
        }
        out.close();
    }
}

class Solution {
    /*
     * think and coding
     */
    double EPS = 0.000_0001;

    public void solve(FastReader scan, PrintWriter out) {
        int n = scan.nextInt(), k = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();
            set.add(t);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        map.forEach((integer, integer2) -> {
            if (integer2 >= k) list.add(integer);
        });
        Collections.sort(list);
        if (list.isEmpty()) {
            out.println(-1);
            return;
        }
        int cnt = 1, res = 1, r = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1) + 1) {
                cnt++;
            } else {
                if (res < cnt) {
                    res = cnt;
                    r = list.get(i - 1);
                }
                cnt = 1;
            }
        }
        if (res < cnt) {
            res = cnt;
            r = list.get(list.size() - 1);
        }
        out.println(r + 1 - res + " " + r);
    }

    public int upper(long[] arr, long x) {
        int l = -1, r = arr.length;
        while (r - l > 1) {
            int mid = (r + l) / 2;
            if (arr[mid] >= x) l = mid;
            else r = mid;
        }
        return l;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static class Pair implements Comparable<Pair> {
        int a, b, c;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Pair(Pair p) {
            this.a = p.a;
            this.b = p.b;
        }

        public Pair(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }


        @Override
        public int compareTo(Pair p) {
            return Integer.compare(a, p.a);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}

class MathForces {
    static int modI = (int) 1e9;
    static long modL = (long) 1e9;

    static BigInteger gcd(BigInteger a, BigInteger b) {
        if (a.compareTo(BigInteger.valueOf(0)) == 0)
            return b;
        return gcd(b.mod(a), a);
    }

    static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b).abs().divide(gcd(a, b));
    }

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }

    static long sumNum(String s) {
        char[] arr = s.toCharArray();
        long sum = 0;
        for (char c : arr) {
            sum += c - '0';
        }
        return sum;
    }

    static long fPow(long a, long n) {
        if (n == 0)
            return 1;
        if (n % 2 == 1)
            return fPow(a, n - 1) * a;
        else {
            long b = fPow(a, n / 2);
            return b * b;
        }
    }

    static long fPowMod(long a, long n, long MOD) {
        if (n == 0L) return 1L;
        if (n % 2 == 1) {
            return (a * fPowMod(a, n - 1, MOD)) % MOD;
        }
        long temp = fPowMod(a, n / 2, MOD);
        return (temp * temp) % MOD;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class Point {
    public int a, b, c;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Point(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return a == point.a &&
                b == point.b &&
                c == point.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return "Point{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class PointComp implements Comparator<Point> {
    public int compare(Point p1, Point p2) {
        if (p1.a > p2.a)
            return 1;
        else if (p1.a < p2.a)
            return -1;
        return 0;
    }
}

class Comp implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}

class FastReader {
    private final BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(new File(s)));
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