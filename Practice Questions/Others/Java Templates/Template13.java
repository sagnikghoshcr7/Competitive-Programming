import java.util.*;
import java.io.*;

// you can compare with output.txt and expected out
public class RoundEdu129E {
	public static MyPrintWriter out;
	public static MyScanner in;
	
	final static String IMPOSSIBLE = "IMPOSSIBLE";
	final static String POSSIBLE = "POSSIBLE";
	final static String YES = "YES";
	final static String NO = "NO";
    private static void preferFileIO(boolean isFileIO) {
        if (System.getProperty("ONLINE_JUDGE") == null && isFileIO) {
        	try{
	            in = new MyScanner(new FileInputStream("input.txt"));
	            out = new MyPrintWriter(new FileOutputStream("output.txt"));
        	}
        	catch(FileNotFoundException e){
        		e.printStackTrace();
        	}
        }
        else{
    		in = new MyScanner(System.in);
    	    out = new MyPrintWriter(new BufferedOutputStream(System.out));
        }
    }
	
	public static void main(String[] args){
//		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		boolean isDebug = false;
		boolean isFileIO = true;
		
		preferFileIO(isFileIO);
		
		RoundEdu129E sol = new RoundEdu129E();

    	int n = in.nextInt();
    	
    	int[] d1x = new int[n];
    	int[] d1y = new int[n];
    	int[] d2x = new int[n];
    	int[] d2y = new int[n];
    	for(int i=0; i<n-1; i++){
    		d1x[i] = in.nextInt()-1;
    		d1y[i] = in.nextInt()-1;
    		d2x[i] = in.nextInt()-1;
    		d2y[i] = in.nextInt()-1;
    	}
    	
    	sol.preprocess(d1x, d1y, d2x, d2y);
    	
    	int m = in.nextInt();
    	for(int j=0; j<m; j++){
    		int x1 = in.nextInt()-1;
    		int y1 = in.nextInt()-1;
    		int x2 = in.nextInt()-1;
    		int y2 = in.nextInt()-1;
    		
    		long ans = sol.query(x1, y1, x2, y2);
    		if(isDebug){
    			out.printf("%d %d %d %d\n", x1, y1, x2, y2);
    		}
        	out.println(ans);
    	}
    	
	    in.close();
	    out.close();
    }
	
	private long query(int x1, int y1, int x2, int y2) {
		int layer1 = Math.max(x1, y1);
		int layer2 = Math.max(x2, y2);
		
		if(layer1 == layer2)
			return dist(x1, y1, x2, y2);
		
		if(layer1 > layer2){
			int temp = x1;
			x1 = x2;
			x2 = temp;
			
			temp = y1;
			y1 = y2;
			y2 = temp;
			
			temp = layer1;
			layer1 = layer2;
			layer2 = temp;
		}
		
		// we don't need to enumerate all 2^log possibilities for doors
		// we can do something like recursion here
		// dist(<from, fromType>, <to, toType>) = min over all midType, dist(<from, fromType>, <mid, midType>) + dist(<mid, midType>, <to, toType>)
		
		// dist0: stopped at type 0 door previously
		// dist1: stopped at type 1 door previously
		long dist0 = dist(x1, y1, dx[0][layer1], dy[0][layer1]);
		long dist1 = dist(x1, y1, dx[1][layer1], dy[1][layer1]);
		
		int diff = layer2-1 - layer1;
		for(int pos = 0; (1<<pos) <= diff; pos++){
			if( (diff & (1<<pos)) > 0){
				long dist0_new = Math.min(dist0 + dp[layer1][pos][0][0], dist1 + dp[layer1][pos][1][0]);
				long dist1_new = Math.min(dist1 + dp[layer1][pos][1][1], dist0 + dp[layer1][pos][0][1]);
				dist0 = dist0_new;
				dist1 = dist1_new;
				layer1 += 1<<pos;
			}
		}
		
		// now layer1 = layer2-1
		// i-th top door = between (d0x[i], d0y[i]) and (d0x[i]+1, d0y[i])
		// i-th right door = between (d1x[i], d1y[i]) and (d1x[i], d1y[i]+1)
		dist0 += 1 + dist(dx[0][layer1]+1, dy[0][layer1], x2, y2);
		dist1 += 1 + dist(dx[1][layer1], dy[1][layer1]+1, x2, y2);
		
		return Math.min(dist0, dist1);
	}

	int[][] dx;
	int[][] dy;
	int n;
	
	long[][][][] dp;
	int depth;
	
	private void preprocess(int[] d0x, int[] d0y, int[] d1x, int[] d1y) {
		n = d0x.length;
		dx = new int[2][];
		dy = new int[2][];
		dx[0] = d0x;
		dx[1] = d1x;
		dy[0] = d0y;
		dy[1] = d1y;
		
		// i-th top door = between (d0x[i], d0y[i]) and (d0x[i]+1, d0y[i])
		// i-th right door = between (d1x[i], d1y[i]) and (d1x[i], d1y[i]+1)
		// yeah... x, y are weirdly set.. ik
		
		// stright dp will give n^2, can't.
		
		// dp[layer][step size][fromType][toType]
		// = dist from fromType door at layer to toType door at layer + 2^step size
		depth = 0;
		while((1<<depth) < n)
			depth++;
		dp = new long[n][depth][2][2];
		
		// to = from+1
		for(int from = 0; from + 1 < n; from++){
			dp[from][0][0][0] = 1+dist(dx[0][from]+1, dy[0][from], dx[0][from+1], dy[0][from+1]);
			dp[from][0][1][1] = 1+dist(dx[1][from], dy[1][from]+1, dx[1][from+1], dy[1][from+1]);
			dp[from][0][0][1] = Math.min(1+dist(dx[0][from]+1, dy[0][from], dx[1][from+1], dy[1][from+1]),
					dist(dx[0][from], dy[0][from], dx[1][from], dy[1][from]) + 1 + dist(dx[1][from], dy[1][from]+1, dx[1][from+1], dy[1][from+1]));
			dp[from][0][1][0] = Math.min(1+dist(dx[1][from], dy[1][from]+1, dx[0][from+1], dy[0][from+1]),
					dist(dx[1][from], dy[1][from], dx[0][from], dy[0][from]) + 1 + dist(dx[0][from]+1, dy[0][from], dx[0][from+1], dy[0][from+1]));
		}
		
		
		// from + 2^(h-1) + 2^(h-1) = from + 2^h
		for(int h = 1; h < depth; h++){
			for(int from = 0; from + (1 << h) < n; from++){
				for(int fromType = 0; fromType <=1; fromType++){
					for(int toType = 0; toType <=1; toType++){
						dp[from][h][fromType][toType] = Math.min(
								dp[from][h-1][fromType][0] + dp[from + (1<<(h-1))][h-1][0][toType],
								dp[from][h-1][fromType][1] + dp[from + (1<<(h-1))][h-1][1][toType]);
//						int a = dp[from][h][fromType][toType];
//						int b = dp[from][h-1][fromType][0];
//						int c = dp[from + (1<<(h-1))][h-1][0][toType];
//						int d = dp[from][h-1][fromType][1];
//						int e = dp[from + (1<<(h-1))][h-1][1][toType];
//						int f = 0;
					}
				}
			}
		}
	}
	
	private int dist(int x1, int y1, int x2, int y2){
		// assert: (y1, x1) and (y2, x2) are in the same layer
		
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	
	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		// 32768?
		public MyScanner(InputStream is, int bufferSize) {
			br = new BufferedReader(new InputStreamReader(is), bufferSize);
		}
		
		public MyScanner(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			// br = new BufferedReader(new InputStreamReader(System.in));
			// br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		}

		public void close() {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

		String nextLine(){
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		int[][] nextGraphEdges() {
			int m = nextInt();
			int[][] e = new int[m][2];
			for(int i=0; i<m; i++){
				e[i][0] = nextInt();
				e[i][1] = nextInt();
			}
			return e;
		}
		
		int[] nextIntArray(int len){
	    	int[] a = new int[len];
			for(int j=0; j<len; j++)
	    		a[j] = in.nextInt();
	    	return a;
		}
	}
	
	public static class MyPrintWriter extends PrintWriter{
		public MyPrintWriter(OutputStream os) {
			super(os);
		}
		
		public void print(long[] arr){
			if(arr != null){
				print(arr[0]);
				for(int i=1; i<arr.length; i++){
					print(" ");
					print(arr[i]);
				}
			}
		}
		public void println(long[] arr){
			print(arr);
			println();
		}

		public void print(int[] arr){
			if(arr != null){
				print(arr[0]);
				for(int i=1; i<arr.length; i++){
					print(" ");
					print(arr[i]);
				}
			}
		}
		public void println(int[] arr){
			print(arr);
			println();
		}
		
		public <T> void print(ArrayList<T> arr){
			if(arr != null){
				print(arr.get(0));
				for(int i=1; i<arr.size(); i++){
					print(" ");
					print(arr.get(i));
				}
			}
		}
		public <T> void println(ArrayList<T> arr){
			print(arr);
			println();
		}
		
		public void println(int[] arr, int split){
			if(arr != null){
				for(int i=0; i<arr.length; i+=split){
					print(arr[i]);
					for(int j=i+1; j<i+split; j++){
						print(" ");
						print(arr[j]);
					}
					println();
				}
			}
		}
		
		public <T> void println(ArrayList<T> arr, int split){
			if(arr != null && !arr.isEmpty()){
				for(int i=0; i<arr.size(); i+=split){
					print(arr.get(i));
					for(int j=i+1; j<i+split; j++){
						print(" ");
						print(arr.get(j));
					}
					println();
				}
			}
		}
	}
	
	private void makeDotUndirected(int[][] e) {
		MyPrintWriter out2 = null;
		 try {
			out2 = new MyPrintWriter(new FileOutputStream("graph.dot"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out2.println("strict graph {");
		for(int i=0; i<e.length; i++){
			out2.println(e[i][0] + "--" + e[i][1] + ";");
		}
		out2.println("}");
		out2.close();
	}
	
	private void makeDotDirected(int[][] e) {
		MyPrintWriter out2 = null;
		 try {
			out2 = new MyPrintWriter(new FileOutputStream("graph.dot"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out2.println("strict digraph {");
		for(int i=0; i<e.length; i++){
			out2.println(e[i][0] + "->" + e[i][1] + ";");
		}
		out2.println("}");
		out2.close();
	}
	
}
