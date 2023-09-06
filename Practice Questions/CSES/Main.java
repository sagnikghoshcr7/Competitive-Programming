// JAI SHREE RAM
/*

░██████╗░█████╗░░██████╗░███╗░░██╗██╗██╗░░██╗░██████╗░██╗░░██╗░█████╗░░██████╗██╗░░██╗░█████╗░██████╗░███████╗
██╔════╝██╔══██╗██╔════╝░████╗░██║██║██║░██╔╝██╔════╝░██║░░██║██╔══██╗██╔════╝██║░░██║██╔══██╗██╔══██╗╚════██║
╚█████╗░███████║██║░░██╗░██╔██╗██║██║█████═╝░██║░░██╗░███████║██║░░██║╚█████╗░███████║██║░░╚═╝██████╔╝░░░░██╔╝
░╚═══██╗██╔══██║██║░░╚██╗██║╚████║██║██╔═██╗░██║░░╚██╗██╔══██║██║░░██║░╚═══██╗██╔══██║██║░░██╗██╔══██╗░░░██╔╝░
██████╔╝██║░░██║╚██████╔╝██║░╚███║██║██║░╚██╗╚██████╔╝██║░░██║╚█████╔╝██████╔╝██║░░██║╚█████╔╝██║░░██║░░██╔╝░░
╚═════╝░╚═╝░░╚═╝░╚═════╝░╚═╝░░╚══╝╚═╝╚═╝░░╚═╝░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═════╝░╚═╝░░╚═╝░╚════╝░╚═╝░░╚═╝░░╚═╝░░░

*/

import java.io.*;
import java.util.*;
 
public class Main {
	
	static int mod = 1000000007;
	static class Pair implements Comparable<Pair>{
		int first;
		int second;
	
		public Pair(int first_value, int second_value) {
			first = first_value;
			second = second_value;
		}
 
		public int compareTo(Pair y){
			return Integer.compare(first, y.first);
		}	
	}
 
	static class Edge implements Comparable<Edge>{
		int a, b, w;
 
		public Edge(int a, int b, int w){
			this.a = a;
			this.b = b;
			this.w = w;
		}
 
		public int compareTo(Edge e){
			return Integer.compare(this.w, e.w);
		}
	}
 
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] dist;
	static int[] count;
 
	static char[][] grid;
	static boolean[][] gridVisited;
 
	static int maxDistance;
	static int maxNode;
 
	public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
		// BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
 
		int[] w = new int[n];
		int[] v = new int[n];
 
		for(int i=0;i<n;i++){
			w[i] = sc.nextInt();
		}
 
		for(int i=0;i<n;i++){
			v[i] = sc.nextInt();
		}
 
		int[][] dp = new int[n+1][x+1];
 
		for(int i=1;i<=n;i++){
			for(int j=1;j<=x;j++){
				if(j-w[i-1]>=0){
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]]+v[i-1]);
				}
				else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
 
		System.out.println(dp[n][x]);
    }
 
	static long pow(long a, long b){
		if(b==0) return 1;
		
		long res = pow(a,b/2);
 
		if(b%2==0){
			return (res%mod*res%mod)%mod;
		}
		else{
			return (res%mod*res%mod*a%mod)%mod;
		}
	}
 
	static ArrayList<Integer> factors(int n){
		ArrayList<Integer> factors = new ArrayList<>();
 
		for(int i=2;i*i<=n;i++){
			while(n%i==0){
				factors.add(i);
				n/=i;
			}
		}
 
		if(n>1) factors.add(n);
 
		return factors;
	}
 
	static void dfs(int node, int distance){
		visited[node] = true;
 
		if(distance>maxDistance){
			maxDistance = distance;
			maxNode = node;
		}
 
		for(int next : adj[node]){
			if(!visited[next]){
				dfs(next, distance+1);	
			}
		}
	}
 
	static void dfs(int node, ArrayList<Integer>[] graph){
		visited[node] = true;
		for(int next : graph[node]){
			if(!visited[next]){
				dfs(next, graph);	
			}
		}
	}
 
	static void bfs(int node){
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<>();
 
		dist[node] = 0;
		q.add(node);
 
		while(!q.isEmpty()){
			int v = q.poll();
 
			for(int next: adj[v]){
				if(dist[next]==-1){
					dist[next] = dist[v]+1;
					q.add(next);
				}
			}
		}
	}
 
	static void floodfill(int r, int c, char clr){
		if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) return;
		if(gridVisited[r][c]) return;
		if(grid[r][c] != clr) return;
 
		gridVisited[r][c] = true;
 
		floodfill(r, c+1, clr);
		floodfill(r, c-1, clr);
		floodfill(r+1, c, clr);
		floodfill(r-1, c, clr);
	}
 
	public static int firstTrue(int lo, int hi){
		lo--;
		while(lo<hi){
			int mid = lo + (hi-lo)/2;
			if(true){
				lo = mid+1;
			}
			else{
				hi = mid;
			}
		}
		return lo;
	}
 
	public static int lastTrue(int lo, int hi){
		lo--;
		while(lo<hi){
			int mid = lo + (hi-lo+1)/2;
			if(true){
				lo = mid;
			}
			else{
				hi = mid-1;
			}
		}
 
		return lo;
	}
 
	static long[] prefixSum(int[] a){
		int n = a.length;
		long[] prefixSum = new long[n+1];
		for(int i=0;i<n;i++){
			prefixSum[i+1] = prefixSum[i] + a[i];
		}
 
		return prefixSum;
	}
	
	public static class multiset{
		public TreeMap<Long,Integer> map;
		public int size=0;
 
		public multiset(){
			map=new TreeMap<>();
		}
 
		public multiset(long[] a){
			map=new TreeMap<>();
			size=a.length;
			for(int i=0;i<a.length;i++){
				map.put(a[i], map.getOrDefault(a[i], 0)+1);
			}
		}
 
		void add(long a){
			size++;
			map.put(a, map.getOrDefault(a, 0)+1);
		}
 
		void remove(long a){
			size--;
			int val=map.get(a);
			map.put(a, val-1);
			if(val==1)map.remove(a);
		}
 
		void removeAll(long a){
			if(map.containsKey(a))
			{
				size-=map.get(a);
				map.remove(a);
			}
		}
 
		long ceiling(long a){
			if (map.ceilingKey(a) != null) {
				long find = map.ceilingKey(a);
				return find;
			}else return Integer.MIN_VALUE;
		}
 
		long floor(long a){
			if (map.floorKey(a) != null) {
				long find = map.floorKey(a);
				return find;
			}else return Integer.MAX_VALUE;
		}
 
		long lower(long a){
			if (map.lowerKey(a) != null) {
				long find = map.lowerKey(a);
				return find;
			}
			else 
				return Integer.MAX_VALUE;
		}
 
		long higher(long a){
			if (map.higherKey(a) != null) {
				long find = map.higherKey(a);
				return find;
			}
			else return Integer.MIN_VALUE;
		}
 
		long first(){
			return map.firstKey();
		}
 
		long last(){
			return map.lastKey();
		}
		
		boolean contains(long a){
			if(map.containsKey(a))return true;
			return false;
		}
 
		int size(){
			return size;
		}
 
		void clear(){
			map.clear();
		}
 
		long poll(){
			if(map.size()==0){
				return Integer.MAX_VALUE;
			}
			size--;
			long first=map.firstKey();
			if(map.get(first)==1){
				map.pollFirstEntry();
			}
			else 
				map.put(first, map.get(first)-1);
			return first;
		}
		
		long polllast(){
			if(map.size()==0){
				return Integer.MAX_VALUE;
			}
			size--;
			long last=map.lastKey();
			if(map.get(last)==1){
				map.pollLastEntry();
			}else map.put(last, map.get(last)-1);
			return last;
		}
	}
 
	// UnionFind.class
	static class UnionFind {
		private int[] root;
		// Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
		private int[] rank;
		private int[] sz;
		private int comp;
 
		public UnionFind(int size) {
			root = new int[size];
			rank = new int[size];
			sz = new int[size];
			comp = size;
			for (int i = 0; i < size; i++) {
				root[i] = i;
				rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is
				sz[i] = 1;			// a standalone vertex with no connection to other vertices.
			}
		}
 
		// The find function here is the same as that in the disjoint set with path compression.
		public int find(int x) {
			if (x == root[x]) {
				return x;
			}
			return root[x] = find(root[x]);
		}
 
		// The union function with union by rank
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				if (rank[rootX] > rank[rootY]) {
					sz[rootX] += sz[rootY];
					root[rootY] = rootX;
				} else if (rank[rootX] < rank[rootY]) {
					sz[rootY] += sz[rootX];
					root[rootX] = rootY;
				} else {
					sz[rootX] += sz[rootY];
					root[rootY] = rootX;
					rank[rootX] += 1;
				}
				comp--;
			}
		}
 
		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
 
		public int size(int x){
			return sz[find(x)];
		}
 
		public int NoOfSets(){
			return comp;
		}
	}
 
 
	static class segTree{
		int size;
		ArrayList<Pair> values;
		segTree(int n){
			size=1;
			while(size<n){
				size*=2;
			}
			values=new ArrayList<>(2*size);
			for(int i=0;i<2*size;i++){
				values.add(new Pair(Integer.MAX_VALUE,0));
			}
		}
		private void build(ArrayList<Pair> a,int x,int lx,int rx){
			if(rx-lx==1){
				if(lx<a.size()){
					values.set(x, new Pair(a.get(lx).first,a.get(lx).second));
				}
				return;
			}
			int m = (lx+rx)/2;
			build(a, 2*x+1, lx, m);
			build(a, 2*x+2, m, rx);
			if(values.get(2*x+1).first<values.get(2*x+2).first)
				values.set(x,new Pair(values.get(2*x+1).first,values.get(2*x+1).second));
			else if(values.get(2*x+1).first>values.get(2*x+2).first)
				values.set(x,new Pair(values.get(2*x+2).first,values.get(2*x+2).second));
			else
				values.set(x,new Pair(values.get(2*x+2).first,values.get(2*x+2).second+values.get(2*x+1).second));
		}
		void build(ArrayList<Pair> a){
			build(a, 0, 0, size);
			for(int i=0;i<2*size;i++){
				System.out.println(values.get(i).first+" "+values.get(i).second);
			}
		}
		private void set(int i,int second,int x,int lx,int rx){
			if(rx-lx==1){
				values.set(x,new Pair(second, 1));
				return;
			}
			int m = (lx+rx)/2;
			if(i<m){
				set(i, second, 2*x+1, lx, m);
			}
			else{
				set(i, second, 2*x+2, m, rx);
			}
			if(values.get(2*x+1).first<values.get(2*x+2).first)
				values.set(x,new Pair(values.get(2*x+1).first,values.get(2*x+1).second));
			else if(values.get(2*x+1).first>values.get(2*x+2).first)
				values.set(x,new Pair(values.get(2*x+2).first,values.get(2*x+2).second));
			else
				values.set(x,new Pair(values.get(2*x+2).first,values.get(2*x+2).second+values.get(2*x+1).second));
		}
		void set(int i,int second){
			set(i, second, 0, 0, size);
		}
		private Pair calc(int l,int r,int x,int lx,int rx){
			if(lx>=r || l>=rx) 
				return new Pair(Integer.MAX_VALUE,0);
			if(lx>=l && rx<=r)
				return values.get(x);
			int m =(lx+rx)/2;
			Pair s1 = calc(l, r, 2*x+1, lx, m);
			Pair s2 = calc(l, r, 2*x+2, m, rx);
			if(s1.first<s2.second){
				return s1;
			}
			else{
				return s2;
			}
		}
		Pair calc(int l,int r){
			return  calc(l, r,0,0,size);
		}
	}
    static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 
 
		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 
 
		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 
 
		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 
 
		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 
 
		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 
 
		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 
 
    static int gcd(Integer a,Integer b)
    {
        if(b==0)
            return a;
        else
            return gcd(b,a%b);
    }
 
	static int gcd(int[] a){
		int result = a[0];
		for(int i=0;i<a.length;i++){
			result = gcd(result, a[i]);
			if(result == 1) return 1;
		}
		return result;
	}
 
    static boolean isPrime(long n)
    {
 
        // Check if number is less than
        // equal to 1
        if (n <= 1)
            return false;
 
        // Check if number is 2
        else if (n == 2)
            return true;
 
        // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;
 
		// If not, then just check the odds
		double l = Math.sqrt(n);
        for (int i = 3; i <= l; i += 2) 
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
	
}