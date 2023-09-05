import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Template2 {
	public static void main(String[] args) {

		FastScanner sc = new FastScanner();
		var n = sc.nextInt();
		var input = sc.readStringArray(n);
		var ans = 0;
		for (int i = 0; i < n; i++) {
			if (Objects.equals(input[i], "For")) ans++;
		}
		System.out.println(ans > n / 2 ? "Yes" : "No");

	}

	/*---       ---*/
	/*--- util  ---*/
	/*---       ---*/
	public static String colToString(Collection<?> col) {
		return col.toString().replaceAll("[,\\[\\]]", "");
	}

	/*---       ---*/
	/*--- print ---*/
	/*---       ---*/
	public static void printYesNo(boolean b) {
		var ans = b ? "Yes" : "No";
		System.out.println(ans);
	}

	public static void print(Collection<?> c) {
		System.out.println(String.join(" ", c.stream().map(String::valueOf).collect(Collectors.toList())));
	}

	public static void println(Collection<?> c) {
		var sb = new StringBuilder();
		for (Object object : c) {
			sb.append(object).append("\r\n");
		}

		System.out.println(sb);
	}

	public static void print(String[] a) {
		var sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			if (i != 0) sb.append(" ");
			sb.append(a[i]);
		}
		System.out.println(sb);
	}

	public static void println(String[] a) {
		var sb = new StringBuilder();

		for (int i = 0; i < a.length; i++) {
			if (i != 0) sb.append("\r\n");
			sb.append(a[i]);
		}

		System.out.println(sb);
	}

	public static void print(int[] a) {
		var sb = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			if (i != 0) sb.append(" ");
			sb.append(a[i]);
		}
		System.out.println(sb);
	}

	public static void println(int[] a) {
		var sb = new StringBuilder();

		for (int i = 0; i < a.length; i++) {
			if (i != 0) sb.append("\r\n");
			sb.append(a[i]);
		}

		System.out.println(sb);
	}

	public static void printBooleanArray(boolean[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i] + " ");
		}
		System.out.println("");
	}

	public static void printBooleanTable(boolean[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.println(b[i][j] ? "o" : "x");
			}
			System.out.println("");
		}
	}

	public static void printIntTable(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.println(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

	/*---       ---*/
	/*--- debug ---*/
	/*---       ---*/
	public static void debug(int[] x) {
		out(Arrays.toString(x));
	}

	public static void debug(boolean[] x) {
		out(Arrays.toString(x));
	}

	public static void debug(long[] x) {
		out(Arrays.toString(x));
	}

	public static void debug(int[][] x) {
		out(Arrays.deepToString(x));
	}

	public static void debug(boolean[][] x) {
		out(Arrays.deepToString(x));
	}

	public static void debug(char[][] x) {
		out(Arrays.deepToString(x));
	}

	public static void debug(Object[] x) {
		out(Arrays.toString(x));
	}

	public static void debug(Object[][] x) {
		out(Arrays.deepToString(x));
	}

	public static void debug(String x) {
		out(x);
	}

	public static void debug(Object a) {
		System.err.println(a);
	}

	public static void out(String x) {
		System.err.println(x);
	}

}

class FastScanner {
	private final InputStream in = System.in;
	private final byte[] buffer = new byte[1024];
	private int ptr = 0;
	private int buflen = 0;

	private boolean hasNextByte() {
		if (ptr < buflen) {
			return true;
		} else {
			ptr = 0;
			try {
				buflen = in.read(buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (buflen <= 0) {
				return false;
			}
		}
		return true;
	}

	private int readByte() {
		if (hasNextByte())
			return buffer[ptr++];
		else
			return -1;
	}

	private static boolean isPrintableChar(int c) {
		return 33 <= c && c <= 126;
	}

	public boolean hasNext() {
		while (hasNextByte() && !isPrintableChar(buffer[ptr]))
			ptr++;
		return hasNextByte();
	}

	public String next() {
		if (!hasNext()) throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		int b = readByte();
		while (isPrintableChar(b)) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	public long nextLong() {
		if (!hasNext()) throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b) {
			throw new NumberFormatException();
		}
		while (true) {
			if ('0' <= b && b <= '9') {
				n *= 10;
				n += b - '0';
			} else if (b == -1 || !isPrintableChar(b)) {
				return minus ? -n : n;
			} else {
				throw new NumberFormatException();
			}
			b = readByte();
		}
	}

	public int nextInt() {
		long nl = nextLong();
		if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
		return (int) nl;
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	public int[] readIntArray(int size) {
		int[] intArray = new int[size];
		Arrays.setAll(intArray, i -> nextInt());
		return intArray;
	}

	public long[] readLongArray(int size) {
		long[] longArray = new long[size];
		Arrays.setAll(longArray, i -> nextLong());
		return longArray;
	}

	public String[] readStringArray(int size) {
		String[] stringArray = new String[size];
		Arrays.setAll(stringArray, i -> next());
		return stringArray;
	}

	public List<String> readStringList(int size) {
		var list = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			list.add(next());
		}
		return list;
	}

	public char[][] twoDimensionalCharArray(int h, int w) {
		char[][] array = new char[h][w];
		for (int i = 0; i < h; i++) {
			array[i] = next().toCharArray();
		}
		return array;
	}

	public int[][] twoDimensionalIntArray(int h, int w) {
		int[][] array = new int[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				array[i][j] = nextInt();
			}
		}
		return array;
	}

	public int[][] getIntArrayFromStr(int h, int w) {
		int[][] array = new int[h][w];

		for (int i = 0; i < h; i++) {
			var temp = next();
			for (int j = 0; j < w; j++) {
				array[i][j] = temp.charAt(j) - '0';
			}
		}

		return array;
	}

}
