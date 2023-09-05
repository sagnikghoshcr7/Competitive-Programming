import java.util.*;
import java.io.*;

public class Template11 {
	public static long MOD = 998244353;
	
	public static void main(String[] args) {
		int A = sc.nextInt(), B = sc.nextInt(), N = sc.nextInt();
		int Nn = bits_10(N), Bn = bits_10(B);
		List<Long>[] nf = new List[Nn + 1];
		long[] pw = new long[15];
		int[] lens = new int[100001];
		pw[0] = 1;
		for(int i = 1; i < 15; i ++) {
			pw[i] = pw[i - 1] * 10;
		}
		for(int i = 1; i <= 100000; i ++) {
			lens[i] = bits_10(i);
		}
		for(int nn = 1; nn <= Nn; nn ++) {
			nf[nn] = getFac(pw[nn] - 1);
		}
		long cnt = 0;
		List<long[]> ans = new ArrayList();
		for(int nn = 1; nn <= Nn; nn ++) {
			for(int ri = 0, rlen = nf[nn].size(); ri < rlen; ri ++) {
				long k2 = nf[nn].get(ri), r = (pw[nn] - 1) / k2;
				for(int d = 1; d <= 100000; d ++) {
					for(int bn = lens[d]; bn <= Bn; bn ++) { 
						long dr = d * r, bx = pw[bn] - dr % pw[bn];
						long dd = d / gcd(bx, d);
						for(long g = ((pw[bn - 1] + bx - 1) / bx + dd - 1) / dd * dd, gmax = (pw[bn] - 1) / bx; g <= gmax; g += dd) {
							long b = bx * g;
							if(b >= B || gcd(b / d, r) != 1) {
								continue;
							}
							long ax = (bx + dr) / pw[bn], n = ax * b / d * k2, a = ax * g;
							if(a < A && n < N && gcd(ax, bx) == 1 && (n <= 100000 ? lens[(int)n] : lens[(int)(n / 100000)] + 5) == nn && a * b * pw[nn] + n * b == a * n * pw[bn] + a * b) {
								cnt ++;
								//ans.add(new long[] {a, b, n});
							}
						}
					}
				}
			}
		}
//		ans.sort((o1, o2) -> (o1[0] == o2[0] ? (o1[1] == o2[1] ? (int)(o1[2] - o2[2]) : (int)(o1[1] - o2[1])) : (int)(o1[0] - o2[0])));
//		for(int i = 0; i < ans.size(); i ++) {
//			System.out.println(Arrays.toString(ans.get(i)));
//		}
//		System.out.println(ans.size());
		prtln(cnt);
		prtAll();
		return;
	}
	//Tools
	public static long gcd(long x, long y) {
		long a = Math.max(x, y), b = Math.min(x, y);
		while(a % b != 0) {
			long t = b;
			b = a % b;
			a = t;
		}
		return b;
	}
	public static int bits_2(long x) {
		int cnt = 0;
		while(x > 0) {
			cnt ++;
			x >>= 1;
		}
		return cnt;
	}
	public static int bits_10(long x) {
		int cnt = 0;
		while(x > 0) {
			cnt ++;
			x /= 10;
		}
		return cnt;
	}
	public static long mod(long x) {
		//System.out.println(x);
		while(x < 0) {
			//System.out.println(x);
			x += MOD;
		}
		if(x >= MOD) {
			x %= MOD;
		}
		return x;
	}
	public static long pow(long x, long y) {
		long ret = 1;
		while(y > 0) {
			if((y & 1) == 1) {
				ret = mod(ret * x);
			}
			x = mod(x * x);
			y >>= 1;
		}
		return ret;
	}
	public static long inv(long x) {
		return pow(x, MOD - 2);
	}
	public static class Combination {
		long[] ftl, ftl_inv;
		Combination(int n) {
			ftl = new long[n + 1];
			ftl_inv = new long[n + 1];
			ftl[0] = 1;
			ftl_inv[0] = 1;
			for(int i = 1; i <= n; i ++) {
				ftl[i] = mod(ftl[i - 1] * (long)i);
				ftl_inv[i] = inv(ftl[i]);
				
			}
		}
		// pick m from n
		public long get(int n, int m) {
			if(m > n) {
				return 0;
			}
			return mod(mod(ftl[n] * ftl_inv[m]) * ftl_inv[n - m]);
		}
		
		public long getRev(int n, int m) {
			if(m > n) {
				return 1;
			}
			return mod(mod(ftl_inv[n] * ftl[m]) * ftl[n - m]);
		}
	}
	public static void getFac_dfs(long cur, int i, List<long[]> fs, List<Long> ans) {
		if(i == fs.size()) {
			ans.add(cur);
			return;
		}
		long x = x = fs.get(i)[0];
		for(int j = 0, len = (int)fs.get(i)[1]; j <= len; j ++) {
			getFac_dfs(cur, i + 1, fs, ans);
			cur *= x;
		}
	}
	public static List<Long> getFac(long x) {
		List<long[]> fs = new ArrayList();
		for(int i = 2; i <= Math.sqrt(x); i ++) {
			int cnt = 0;
			while(x % i == 0) {
				x /= i;
				cnt ++;
			}
			if(cnt > 0) fs.add(new long[] {i, cnt});
		}
		if(x > 1) fs.add(new long[] {x, 1});
		List<Long> ans = new ArrayList();
		getFac_dfs(1, 0, fs, ans);
		return ans;
	}

	public static class SegmentTree{
		int size;
		long[] st;
		long def;
		public static interface STF {
			long f(long x, long y, int len);
		}
		STF stf;
		
		SegmentTree(int n, STF s, long d) {
			size = n + 1;
			def = d;
			st = new long[n << 2];
			Arrays.fill(st, d);
			stf = s;
		}
		public void upd(int t, long v) {
			s_upd(1, 0, size, t, v);
		}
		private void s_upd(int cur, int l, int r, int t, long v) {
			while(true) {
				st[cur] = stf.f(st[cur], v, 1);
				if(l == r) {
					return;
				}
				int mid = (l + r) >> 1;
				cur <<= 1;
				if(t <= mid) {
					r = mid;
				} else {
					l = mid + 1;
					cur |= 1;
				}
			}
		}
		public long get(int tl, int tr) {
			return s_get(1, 0, size, tl, tr);
		}
		private long s_get(int cur, int l, int r, int tl, int tr) {
			if(l >= tl && r <= tr) {
				return st[cur];
			}
			int mid = (l + r) >> 1;
			long ret = def;
			if(tl <= mid) {
				ret = stf.f(ret, s_get(cur << 1, l, mid, tl, tr), 1);
			}
			if(tr > mid) {
				ret = stf.f(ret, s_get((cur << 1) | 1, mid + 1, r, tl, tr), 1);
			}
			return ret;
		}
	}
	//IOs
	public static int prt2_bits = 32;
	public static void prt2(long x) {
		StringBuilder sb = new StringBuilder();
		while(x > 0) {
			sb.insert(0, (x % 2));
			x >>= 1;
		}
		while(sb.length() < prt2_bits) {
			sb.insert(0, 0);
		}
		for(int i = (sb.length() / 4) * 4; i > 0; i -= 4) {
			sb.insert(i, " ");
		}
		System.out.println(sb.toString());
	}
	public static InputReader sc = new InputReader(System.in);
	public static void readArr(long[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = sc.nextLong();
		}       
	}
	public static void readArr(int[] arr) {
		for(int i = 0; i < arr.length; i ++) {
			arr[i] = sc.nextInt();
		}       
	}
	public static StringBuilder out = new StringBuilder();
	public static void prt(int x) {
		out.append(x);
	}
	public static void prt(long x) {
		out.append(x);
	}
	public static void prt(double x) {
		out.append(x);
	}
	public static void prt(String x) {
		out.append(x);
	}
	public static void prt(List<? extends Object> list) {
		for(Object x : list) {
			if(x instanceof Integer) {
				out.append((int)x);
			} else if(x instanceof Long) {
				out.append((long)x);
			}
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
	}
	public static void prt(int[] list) {
		for(int x : list) {
			out.append(x);
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
	}
	public static void prt(long[] list) {
		for(long x : list) {
			out.append(x);
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
	}
	public static void prtln(int x) {
		out.append(x);
		out.append('\n');
	}
	public static void prtln(long x) {
		out.append(x);
		out.append('\n');
	}
	public static void prtln(double x) {
		out.append(x);
		out.append('\n');
	}
	public static void prtln(String x) {
		out.append(x);
		out.append('\n');
	}
	public static void prtln(List<? extends Object> list) {
		for(Object x : list) {
			if(x instanceof Integer) {
				out.append((int)x);
			} else if(x instanceof Long) {
				out.append((long)x);
			}
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
		out.append('\n');
	}
	public static void prtln(int[] list) {
		for(int x : list) {
			out.append(x);
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
		out.append('\n');
	}
	public static void prtln(long[] list) {
		for(long x : list) {
			out.append(x);
			out.append(' ');
		}
		out.deleteCharAt(out.length() - 1);
		out.append('\n');
	}
	public static void prtAll() {
		if(out.length() == 0) {
			return;
		}
		if(out.charAt(out.length() - 1) == '\n') {
			out.deleteCharAt(out.length() - 1);
		}
		System.out.println(out.toString());
	}	
}

class InputReader {
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

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
	        sgn = -1;
	        c = read();
	    }
	    int res = 0;
	    do {
	        if (c < '0' || c > '9') {
	            throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}

	public long nextLong() {
	    int c = read();
	    while (isSpaceChar(c))
	        c = read();
	    int sgn = 1;
	    if (c == '-') {
	        sgn = -1;
	        c = read();
	    }
	    long res = 0;
	    do {
	        if (c < '0' || c > '9') {
	            throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	    } while (!isSpaceChar(c));
	    return res * sgn;
	}

	public String nextString() {
	    int c = read();
	    while (isSpaceChar(c))
	        c = read();
	    StringBuilder res = new StringBuilder();
	    do {
	        if (Character.isValidCodePoint(c)) {
	            res.appendCodePoint(c);
	        }
	        c = read();
	    } while (!isSpaceChar(c));
	    return res.toString();
	}

	public String next() {
	    return nextString();
	}
	
	public static String[] readStringArray(InputReader in, int size) {
	    String[] array = new String[size];
	    for (int i = 0; i < size; i++)
	        array[i] = in.nextString();
	    return array;
	}

	public static String[][] readStringTable(InputReader in, int rowCount, int columnCount) {
	    String[][] table = new String[rowCount][];
	    for (int i = 0; i < rowCount; i++)
	        table[i] = readStringArray(in, columnCount);
	    return table;
	}
	
	public char nextChar() {
	    int c = read();
	    while (isSpaceChar(c))
	        c = read();
	    return (char) c;
	}

	public String nextLine() {
	    int c = read();
	    while (isSpaceChar2(c))
	        c = read();
	    StringBuilder res = new StringBuilder();
	    do {
	        if (Character.isValidCodePoint(c)) {
	            res.appendCodePoint(c);
	        }
	        c = read();
	    } while (!isSpaceChar2(c));
	    return res.toString();
	}

	public double readDouble() {
	    int c = read();
	    while (isSpaceChar(c))
	        c = read();
	    int sgn = 1;
	    if (c == '-') {
	        sgn = -1;
	        c = read();
	    }
	    double res = 0;
	    while (!isSpaceChar(c) && c != '.') {
	        if (c == 'e' || c == 'E') {
	            return res * Math.pow(10, nextInt());
	        }
	        if (c < '0' || c > '9') {
	            throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	    }
	    if (c == '.') {
	        c = read();
	        double m = 1;
	        while (!isSpaceChar(c)) {
	            if (c == 'e' || c == 'E') {
	                return res * Math.pow(10, nextInt());
	            }
	            if (c < '0' || c > '9') {
	                throw new InputMismatchException();
	            }
	            m /= 10;
	            res += (c - '0') * m;
	            c = read();
	        }
	    }
	    return res * sgn;
	}

	public boolean isSpaceChar(int c) {
	    if (filter != null) {
	        return filter.isSpaceChar(c);
	    }
	    return isWhitespace(c);
	}

	public boolean isSpaceChar2(int c) {
	    if (filter != null) {
	        return filter.isSpaceChar2(c);
	    }
	    return isWhitespace2(c);
	}
	
	public static boolean isWhitespace2(int c) {
	    return c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public static boolean isWhitespace(int c) {
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);

        public boolean isSpaceChar2(int ch);
    }
}
