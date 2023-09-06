import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Map.Entry;

import javax.security.auth.kerberos.KerberosCredMessage;

public class Template20 {
    static long mod = 1000000007;
    static final Random random = new Random();

    static long[] factorials;
    static long[] invFactorials;

    /* Name of the class has to be "Main" only if the class is public. */
    public static void main(String[] args) throws IOException {
        // File in = new File("input.txt");
        // File output = new File("output.txt");
        // InputStream inputStream = new FileInputStream(in);
        // OutputStream outputStream = new FileOutputStream(output);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Question solver = new Question();

        // precompFacts();

        int testCount = Integer.parseInt(sc.next());
        for (int i = 1; i <= testCount; i++) {
            // out.print("CASE #" + i + ": ");
            solver.solve(i, sc, out);
        }
        // solver.solve(1, sc, out);
        out.close();
    }

    static class Question {

        long dp[][];

        public void solve(int testNumber, InputReader sc, OutputWriter out) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = sc.nextIntArray(n);
            SortedSet<Integer> map = new TreeSet<>();
            map.add(0);
            map.add(m);
            SortedSet<Integer> map2 = new TreeSet<>();
            map2.add(m);
            HashMap<Integer, Integer> freq = new HashMap<>();
            freq.put(m, 1);

            for (int i = 0; i < n; i++) {
                int x = map.headSet(arr[i]).last();
                int y = map.tailSet(arr[i]).first();
                freq.put(y - x, freq.getOrDefault(y - x, 0) - 1);
                if (freq.get(y - x) == 0) {
                    map2.remove(y - x);
                }
                map2.add(arr[i] - x);
                map2.add(y - arr[i]);
                freq.put(arr[i] - x, freq.getOrDefault(arr[i] - x, 0) + 1);
                freq.put(y - arr[i], freq.getOrDefault(y - arr[i], 0) + 1);
                map.add(arr[i]);
                out.print(map2.last() + " ");
            }
            out.println();

        }

    }

    static class Pair implements Comparable<Pair> {
        long i;
        int j;
        long cost;

        public Pair(long i, int j, long cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;

        }

        public Pair(long x, int y) {
            this.i = x;
            this.j = y;
        }

        public int compareTo(Pair o) {

            int x = Long.compare(i, o.i);

            return x;

        }

        // @Override
        // public boolean equals(Object obj) {
        // if (this == obj)
        // return true;
        // if (obj == null)
        // return false;
        // if (getClass() != obj.getClass())
        // return false;
        // Pair other = (Pair) obj;
        // if (i != other.i)
        // return false;
        // if (j != other.j)
        // return false;
        // return true;
        // }

        // @Override
        // public int hashCode() {
        // final int prime = 31;
        // int result = 1;
        // result = prime * result + i;
        // result = prime * result + j;
        // return result;
        // }

    }

    static long power(long x, long y, long p) {
        long res = 1;

        x = x % p;

        if (x == 0)
            return 0;

        while (y > 0) {

            if ((y & 1) != 0)
                res = (res * x) % p;

            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    static long modInverse(long b, long m) {

        return (long) power(b, m - 2, m);

    }

    static int arraySortedOrNot(int arr[], int n) {

        if (n == 1 || n == 0)
            return 1;

        if (arr[n - 1] >= arr[n - 2])
            return 0;

        return arraySortedOrNot(arr, n - 1);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        if (a.compareTo(b) >= 0) {
            return a;
        } else {
            return b;
        }
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        if (a.compareTo(b) < 0) {
            return a;
        } else {
            return b;
        }
    }

    static class DisjointSet {
        int[] s;

        public DisjointSet(int n) {
            Arrays.fill(s = new int[n], -1);
        }

        public int find(int i) {
            return s[i] < 0 ? i : (s[i] = find(s[i]));
        }

        public boolean union(int a, int b) {
            if ((a = find(a)) == (b = find(b)))
                return false;
            if (s[a] == s[b])
                s[a]--;
            if (s[a] <= s[b])
                s[b] = a;
            else
                s[a] = b;
            return true;
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static boolean isPrime(long n) {
        for (long i = 2; i <= n / 2; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static class SegmentTree {
        long[] seg, lazy;

        SegmentTree(int n) {
            seg = new long[4 * n];
            lazy = new long[4 * n];
        }

        void build(int low, int high, int ind, long[] arr) {
            if (low == high) {
                seg[ind] = arr[low];
                return;
            }

            int mid = low + ((high - low) >> 1);

            build(low, mid, 2 * ind + 1, arr);
            build(mid + 1, high, 2 * ind + 2, arr);

            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }

        void rangeUpdate(int l, int r, int low, int high, int ind, long val) {
            if (lazy[ind] != 0) {
                seg[ind] += (high - low + 1) * lazy[ind];
                if (low != high) {
                    lazy[2 * ind + 1] += lazy[ind];
                    lazy[2 * ind + 2] += lazy[ind];
                }
                lazy[ind] = 0;
            }

            if (l > high || r < low)
                return;

            if (l <= low && high <= r) {
                seg[ind] += (long) (high - low + 1) * val;

                if (low != high) {
                    lazy[2 * ind + 1] += val;
                    lazy[2 * ind + 2] += val;
                }
                return;
            }

            int mid = low + ((high - low) >> 1);

            rangeUpdate(l, r, low, mid, 2 * ind + 1, val);
            rangeUpdate(l, r, mid + 1, high, 2 * ind + 2, val);

            seg[ind] = seg[2 * ind + 1] + seg[2 * ind + 2];
        }

        long query(int l, int r, int low, int high, int ind) {
            if (lazy[ind] != 0) {
                seg[ind] += (high - low + 1) * lazy[ind];

                if (low != high) {
                    lazy[2 * ind + 1] += lazy[ind];
                    lazy[2 * ind + 2] += lazy[ind];
                }
                lazy[ind] = 0;
            }

            if (r < low || l > high)
                return 0;

            if (l <= low && high <= r) {
                return seg[ind];
            }

            int mid = low + ((high - low) >> 1);
            long left = query(l, r, low, mid, 2 * ind + 1);
            long right = query(l, r, mid + 1, high, 2 * ind + 2);

            return left + right;
        }
    }

    static public ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factorials = new ArrayList<>();
        long limit = (long) Math.sqrt(n);
        while (n % 2 == 0) {
            factorials.add((long) 2);
            n /= 2;
        }
        for (long i = 3; i <= limit; i += 2) {
            while (n % i == 0) {
                factorials.add(i);
                n /= i;
            }
        }
        if (n > 2)
            factorials.add(n);
        return factorials;
    }

    public int max(int[] elementData) {

        int max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    public static int min(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    public long max(long[] elementData) {

        long max = elementData[0];
        for (int i = 1; i < elementData.length; i++) {
            if (elementData[i] > max) {
                max = elementData[i];
            }
        }
        return max;
    }

    public static long min(long[] array) {
        long min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    static void precompFacts() {
        factorials = new long[2_000_001];
        invFactorials = new long[2_000_001];
        factorials[0] = invFactorials[0] = 1;
        for (int i = 1; i < factorials.length; i++)
            factorials[i] = modularMultiplication(factorials[i - 1], i, mod);
        invFactorials[factorials.length - 1] = modularExponentiation(factorials[factorials.length - 1], mod - 2,
                mod);
        for (int i = invFactorials.length - 2; i >= 0; i--)
            invFactorials[i] = modularMultiplication(invFactorials[i + 1], i + 1, mod);
    }

    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a)
            l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++)
            a[i] = l.get(i);
    }

    static void ruffleSort(long[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int oi = random.nextInt(n);
            long temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }

    public int modularAddition(int a, int b, int MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    public long modularAddition(long a, long b, long MOD) {
        return (a % MOD + b % MOD) % MOD;
    }

    public int modularMultiplication(int a, int b, int MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static long modularMultiplication(long a, long b, long MOD) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public int modularSubtraction(int a, int b, int MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    public long modularSubtraction(long a, long b, long MOD) {
        return (a % MOD - b % MOD + MOD) % MOD;
    }

    public static int binaryExponentiation(int x, int n) {
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return binaryExponentiation(x * x, n / 2);
        else
            return x * binaryExponentiation(x * x, (n - 1) / 2);
    }

    public static long binaryExponentiation(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result *= x;
            x = x * x;
            n /= 2;
        }
        return result;
    }

    public int modularExponentiation(int x, int n, int MOD) {
        if (n == 0)
            return 1 % MOD;
        else if (n % 2 == 0)
            return modularExponentiation(modularMultiplication(x, x, MOD), n / 2, MOD);
        else
            return modularMultiplication(x,
                    modularExponentiation(modularMultiplication(x, x, MOD), (n - 1) / 2, MOD),
                    MOD);
    }

    public static long modularExponentiation(long x, long n, long MOD) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1)
                result = modularMultiplication(result, x, MOD);
            x = modularMultiplication(x, x, MOD);
            n /= 2;
        }
        return result;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int peek() {
            if (numChars == -1) {
                return -1;
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long sum = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return sum * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder sum = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    sum.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return sum.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') {
                    buf.appendCodePoint(c);
                }
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) {
                s = readLine0();
            }
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if (ignoreEmptyLines) {
                return readLine();
            } else {
                return readLine0();
            }
        }

        public String nextLine() {
            return readLine();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char nextCharacter() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            return (char) c;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double sum = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return sum * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                sum *= 10;
                sum += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return sum * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    sum += (c - '0') * m;
                    c = read();
                }
            }
            return sum * sgn;
        }

        public boolean isExhausted() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1) {
                read();
            }
            return value == -1;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextInt();
            return array;
        }

        public int[] nextSortedIntArray(int n) {
            int array[] = nextIntArray(n);
            Arrays.sort(array);
            return array;
        }

        public int[] nextSumIntArray(int n) {
            int[] array = new int[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; ++i)
                array[i] = nextLong();
            return array;
        }

        public long[] nextSumLongArray(int n) {
            long[] array = new long[n];
            array[0] = nextInt();
            for (int i = 1; i < n; ++i)
                array[i] = array[i - 1] + nextInt();
            return array;
        }

        public long[] nextSortedLongArray(int n) {
            long array[] = nextLongArray(n);
            Arrays.sort(array);
            return array;
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void println() {
            writer.println();
        }

        public void print(int[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(int[] array) {
            print(array);
            writer.println();
        }

        public void print(long[] array) {
            for (int i = 0; i < array.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array[i]);
            }
        }

        public void println(long[] array) {
            print(array);
            writer.println();
        }

        public <T> void print(List<T> array) {
            for (int i = 0; i < array.size(); i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(array.get(i));
            }
        }

        public <T> void println(List<T> array) {
            print(array);
            writer.println();
        }

        public void separateLines(int[] array) {
            for (int i : array) {
                println(i);
            }
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }

}