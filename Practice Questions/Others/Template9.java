import java.util.*;
import java.io.*;
class Template9 {
  public static void solve(Read br,Write out){
    //out.debug=true;
    long a = br.readL()*1000;
    long b = br.readL()*60*60;
    if(a>b){
      out.pl("KoD");
    }else if(a<b){
      out.pl("blackyuki");
    }else{
      out.pl("same");
    }
  }

  public static void main(String args[]){
    Read br = new Read();
    Write out = new Write();
    solve(br,out);
    out.flush();
  }

  public static int comp(long a,long b){
    return a>b ? 1 : a<b ? -1:0;
  }

  public static long fact(int i){
    if(i==1||i==0){
      return 1L;
    }
    return i*fact(i-1);
  }

  public static long gcd(long a,long b){
    if(a<b){return gcd(b,a);}
    long c=a%b;
    while(c!=0){
      a=b;b=c;
      c=a%b;
    }
    return b;
  }
  public static long lcm(long a,long b){
    return a/gcd(a,b)*b;
  }
  public static int gcd(int a,int b){
    if(a<b){return gcd(b,a);}
    int c=a%b;
    while(c!=0){
      a=b;b=c;
      c=a%b;
    }
    return b;
  }
  public static int lcm(int a,int b){
    return a/gcd(a,b)*b;
  }

  public static void sortA(int n[]){
    Arrays.sort(n);
  }
  public static void sortD(int n[]){
    Arrays.sort(n);
    rev(n);
  }
  public static void rev(int n[]){
    int l=n.length;
    for(int i=0;i<l/2;i++){
      int t=n[i];n[i]=n[l-i-1];n[l-i-1]=t;
    }
  }
  public static void sortA(ArrayList<Integer> n){
    Collections.sort(n);
  }
  public static void sortD(ArrayList<Integer> n){
    Collections.sort(n,Collections.reverseOrder());
  }
  public static void sortA(int n[][],int k){
    Arrays.sort(n,(a, b) -> Integer.compare(a[k], b[k]));
  }
  public static void sortD(int n[][],int k){
    Arrays.sort(n,(a, b) -> Integer.compare(b[k], a[k]));
  }
  public static void mysort(int n[][],int k){
    Arrays.sort(n, new Comparator<int[]>(){
      public int compare(int[] x,int[] y){
        if(x[k]==y[k]){
          return x[1]-y[1];
        }
        return x[k]-y[k];
      }
    });
  }

  static class ModFunc{
    int n;
    long mod;
    long fact[],invfact[];
    public ModFunc(int n,long mod){
      this.n=n;this.mod=mod;
      fact=new long[n+1];invfact=new long[n+1];
      modfact();modinvfact();
    }
    public static long modfact(int n,long mod){
      long k=1;
      for(int i=1;i<=n;i++){
        k = k*i % mod;
      }
      return k;
    }
    public static long modinvfact(int n,long mod){
      return modinv(modfact(n,mod),mod);
    }
    public static long modinv(long a,long mod){
      long x1=1,x2=0;
      long p=mod,q,t;
      while(a%p!=0){
        q = a/p;
        t = x1-q*x2;
        x1=x2; x2=t;
        t=a%p;
        a=p; p=t;
      }
      return x2<0 ? x2+mod : x2;
    }
    private void modfact(){
      fact[0]=1;
      for(int i=1;i<=n;i++){
        fact[i] = fact[i-1]*i % mod;
      }
    }
    private void modinvfact(){
      invfact[n]=modinv(fact[n],mod);
      for(int i=n-1;i>=0;i--){
        invfact[i] = invfact[i+1]*(i+1) % mod;
      }
    }
    public long modConv(int n,int k){
      return ((fact[n]*invfact[n-k])%mod)*invfact[k]%mod;
    }
    public static long modpow(long x,long n,long pow){
      long r = 1;
      while(n>=1){
        if(1==(n&1)){
          r = r*x % pow;
        }
        x = x*x % pow;
        n/=2;
      }
      return r;
    }
  }

  static class Permu{
    int n;
    public int a[];
    boolean flg;
    public Permu(int n){
      this.n=n;flg=true;
      a=new int[n];
      for(int i=0;i<n;i++){
        a[i]=i;
      }
    }
    public Permu(int k[]){
      this.n=k.length;flg=true;
      a=new int[n];
      for(int i=0;i<n;i++){
        a[i]=k[i];
      }
    }
    public boolean next(){
      for (int i=n-2;i>=0;i--){
        if (a[i]<a[i+1]){
          for (int j=n-1;;j--){
            if (a[i] < a[j]){
              int temp=a[i]; a[i]=a[j]; a[j] = temp;
              i++;
              for (j=n-1;i<j;i++,j--){
                temp=a[i]; a[i] = a[j]; a[j] = temp;
              }
              return true;
            }
      }}}
      flg=false;
      return false;
    }
    public boolean before(){
      for (int i=n-2;i>=0;i--){
        if (a[i]>a[i+1]){
          for (int j=n-1;;j--){
            if (a[i] > a[j]){
              int temp=a[i]; a[i]=a[j]; a[j] = temp;
              i++;
              for (j=n-1;i<j;i++,j--){
                temp=a[i]; a[i] = a[j]; a[j] = temp;
              }
              return true;
            }
      }}}
      flg=false;
      return false;
    }
  }

  static class Compress{
    ArrayList<Integer> a;
    HashMap<Integer,Integer> map;

    public Compress(int[]b){
      HashSet<Integer> temp = new HashSet<>();
      for(int i:b){
        temp.add(i);
      }
      a=new ArrayList<Integer>(temp);
      setup();
    }
    public Compress(ArrayList<Integer>b){
      a=new ArrayList<Integer>(new HashSet<Integer>(b));
      setup();
    }

    private void setup(){
      map = new HashMap<>();
      sortA(a);
      for(int i=0;i<a.size();i++){
        map.put(a.get(i),i);
      }
    }

    public int get(int i){
      return map.get(i);
    }
  }

  static class UnionFindTree{
    int parent[];
    int size;
    int vol[];

    public UnionFindTree(int s){
      size = s;
      parent = new int[size]; vol = new int[size];
      for(int i=0;i<size;i++){parent[i]=i;vol[i]=1;}
    }

    public int root(int n){
      if(parent[n]==n){
        return n;
      }
      parent[n]=root(parent[n]);
      return parent[n];
    }

    public void unite(int a,int b){
      int ra = root(a),rb = root(b);
      if(ra==rb){return;}
      if(vol[ra]<vol[rb]){
        a=ra;ra=rb;rb=a;
      }
      parent[rb]=ra;
      vol[ra]+=vol[rb];
    }

    public boolean same(int a,int b){
      return root(a)==root(b);
    }
  }

  static class WeightUnionFindTree{
    int parent[];
    int size;
    int vol[];
    int diff[];

    public WeightUnionFindTree(int s){
      size = s;
      parent = new int[size]; vol = new int[size]; diff = new int[size];
      for(int i=0;i<size;i++){parent[i]=i;vol[i]=1;diff[i]=0;}
    }

    public int root(int n){
      if(parent[n]==n){
        return n;
      }
      int r = root(parent[n]);
      diff[n] += diff[parent[n]];
      parent[n]=r;
      return parent[n];
    }

    public int weight(int n){
      root(n);
      return diff[n];
    }

    public void unite(int a,int b,int w){
      int ra = root(a),rb = root(b);
      if(ra==rb){return;}
      w+=weight(a);w-=weight(b);
      if(vol[ra]<vol[rb]){
        a=ra;ra=rb;rb=a;w=-w;
      }
      parent[rb]=ra;
      vol[ra]+=vol[rb];
      diff[rb]=w;
    }

    public int differ(int a,int b){
      return weight(a)-weight(b);
    }

    public boolean same(int a,int b){
      return root(a)==root(b);
    }
  }

  static abstract class SegmentTree{
    private int n,leafN;
    private int ar[];
    private int temp;
    public SegmentTree(int x,int temp){
      n=x;this.temp=temp;
      leafN = twon(n);
      ar = new int[leafN*2-1];
      for(int i=0;i<leafN*2-1;i++){ar[i]=temp;}
    }

    public abstract int func(int a,int b);

    public void update(int i,int x){
      int now = i+leafN-1;
      ar[now] = x;
      while(now>0){
        now = (now-1)/2;
        ar[now] = func(ar[now*2+1],ar[now*2+2]);
      }
    }

    public void add(int i,int x){
      update(i,ar[i+leafN-1]+x);
    }

    public int get(int i){
      return ar[i+leafN-1];
    }

    public int query(int a,int b){
      return query(a,b,0,0,leafN);
    }

    public int query(int a,int b,int k,int l,int r){
      if(r<=a||b<=l){
        return temp;
      }else if(a<=l&&r<=b){
        return ar[k];
      }
      int t1=query(a,b,k*2+1,l,(l+r)/2),t2=query(a,b,k*2+2,(l+r)/2,r);
      return func(t1,t2);
    }

    private int twon(int x){
      int i=1;
      while(i<x){
        i*=2;
      }
      return i;
    }
  }
  static class SegmentTreeE extends SegmentTree{
    public SegmentTreeE(int x){
      super(x,0);
    }

    public int func(int a,int b){
      return a^b;
    }
  }
  static class SegmentTreeMin extends SegmentTree{
    public SegmentTreeMin(int x){
      super(x,Integer.MAX_VALUE);
    }

    public int func(int a,int b){
      return Math.min(a,b);
    }
  }
  static class SegmentTreeS extends SegmentTree{
    public SegmentTreeS(int x){
      super(x,0);
    }

    public int func(int a,int b){
      return a+b;
    }
  }

  static class BIT{
    int n;
    int ar[];
    public BIT(int x){
      n=x+1;
      ar = new int[n];
      for(int i=0;i<n;i++){ar[i]=0;}
    }

    public void update(int i,int x){
      i++;
      for(int ii=i;ii<n;ii+=(ii&-ii)){
        ar[ii]+=x;
      }
    }

    public int sum(int i){
      int k=0;
      for(int ii=i;ii>0;ii-=(ii&-ii)){
        k+=ar[ii];
      }
      return k;
    }

    private int twon(int x){
      int i=1;
      while(i<x){
        i*=2;
      }
      return i;
    }
  }

  static class Graph{
    int n;
    ArrayList<ArrayList<Edge>> g;
    public Graph(int nn){
      n=nn;
      g=new ArrayList<ArrayList<Edge>>();
      for(int i=0;i<n;i++){
        g.add(new ArrayList<Edge>());
      }
    }
    public void add(int a,int b,int d){
      g.get(a).add(new Edge(b,d));
      g.get(b).add(new Edge(a,d));
    }
    public void addY(int a,int b,int d){
      g.get(a).add(new Edge(b,d));
    }
    public void add(int a,int b){
      g.get(a).add(new Edge(b,1));
      g.get(b).add(new Edge(a,1));
    }
    public void addY(int a,int b){
      g.get(a).add(new Edge(b,1));
    }

    public int len(int a){
      return g.get(a).size();
    }

    public int[] dijkstra(int s){
      int dist[]=new int[n];
      for(int i=0;i<n;i++){dist[i]=Integer.MAX_VALUE;}
      dist[s]=0;
      PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>(){
        public int compare(int[] a, int[] b) {
          return a[1]-b[1];
        }
      });
      q.add(new int[]{s,0});
      while(q.size()>0){
        int[] p = q.poll();
        if(dist[p[0]]!=p[1]){continue;}
        for(Edge e:g.get(p[0])){
          if(dist[e.v]>dist[p[0]]+e.d){
            dist[e.v]=dist[p[0]]+e.d;
            q.add(new int[]{e.v,dist[e.v]});
          }
        }
      }
      return dist;
    }

    public void dfs(int v){dfs(v,new boolean[n]);}

    private void dfs(int v,boolean flg[]){
      flg[v]=true;
      for(Edge e:g.get(v)){
        if(!flg[e.v]){
          dfs(e.v,flg);
        }
      }
    }

    public void bfs(int s){
      boolean flg[]=new boolean[n];
      Queue<Integer> q = new ArrayDeque<Integer>();
      q.add(s);
      while(q.size()>0){
        int v = q.poll();
        flg[v]=true;
        for(Edge e:g.get(v)){
          if(!flg[e.v]){
            q.add(e.v);
            flg[e.v]=true;
      }}}
    }

    public int minspantree(){
      PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comparator<Edge>(){
        public int compare(Edge a, Edge b) {
          return a.d-b.d;
        }
      });
      boolean flg[]=new boolean[n];
      int c=1,sum=0;
      for(Edge e:g.get(0)){
        q.add(e);
      }
      flg[0]=true;
      while(c<n){
        Edge e = q.poll();
        if(flg[e.v]){continue;}
        flg[e.v]=true;
        sum+=e.d;
        c++;
        for(Edge i:g.get(e.v)){
          if(!flg[i.v]){
            q.add(i);
          }
        }
      }
      return sum;
    }

    public int[] scc(){
      Graph g2 = new Graph(n);
      for(int i=0;i<n;i++){
        for(Edge e:g.get(i)){
          g2.addY(e.v,i);
        }
      }
      ArrayList<Integer> list = new ArrayList<Integer>();
      boolean flg[]=new boolean[n];
      for(int i=0;i<n;i++){
        if(!flg[i]){
          dfs_scc(i,flg,list);
        }
      }
      return g2.scc2(list);
    }

    public int[] scc2(ArrayList<Integer>list){
      boolean flg[]=new boolean[n];
      int ren[]=new int[n];
      int num=0;
      for(int i=n-1;i>=0;i--){
        int now = list.get(i);
        if(!flg[now]){
          dfs_scc2(now,flg,ren,num);
          num++;
        }
      }
      return ren;
    }

    private void dfs_scc(int v,boolean flg[],ArrayList<Integer>list){
      flg[v]=true;
      for(Edge e:g.get(v)){
        if(!flg[e.v]){
          dfs_scc(e.v,flg,list);
        }
      }
      list.add(v);
    }

    private void dfs_scc2(int v,boolean flg[],int num[],int now){
      flg[v]=true;
      num[v]=now;
      for(Edge e:g.get(v)){
        if(!flg[e.v]){
          dfs_scc2(e.v,flg,num,now);
        }
      }
    }

    static class Edge{
      int v,d;
      public Edge(int v,int d){
        this.v=v;this.d=d;
      }
    }
  }

  static class Read{
    BufferedReader br;
    public Read(){
      br = new BufferedReader(new InputStreamReader(System.in));
    }
    private boolean canprint(int a){
      return 33<=a&&a<=126;
    }
    private int skipread(){
      int a=readC();
      while(a!=-1&&!canprint(a)){
        a=readC();
      }
      return a;
    }
    public char readC(){
      try{
        return (char)br.read();
      }catch(IOException e){
        e.printStackTrace();
        return (char)-1;
      }
    }
    public String readLine(){
      try{
        return br.readLine();
      }catch(IOException e){
        e.printStackTrace();
        return "";
      }
    }
    public String readS(){
      StringBuilder sb = new StringBuilder();
      int k = skipread();
      while(true){
        if(!canprint(k)){break;}
        sb.append((char)k);
        k = readC();
      }
      return sb.toString();
    }
    public int readI(){
      int r = 0;
      int k = skipread();
      int flg = 1;
      if(k=='-'){
        flg=-1;
        k=readC();
      }
      while(true){
        if(!canprint(k)){break;}
        r = r*10+(k-'0');
        k = readC();
      }
      return flg*r;
    }
    public long readL(){
      long r = 0;
      int k = skipread();
      int flg = 1;
      if(k=='-'){
        flg=-1;
        k=readC();
      }
      while(true){
        if(!canprint(k)){break;}
        r = r*10+(k-'0');
        k = readC();
      }
      return flg*r;
    }
    public String[] readSs(int n){
      String[]a = new String[n];
      for(int i=0;i<n;i++){a[i]=readS();}
      return a;
    }
    public int[] readIs(int n){
      int[]a = new int[n];
      for(int i=0;i<n;i++){a[i]=readI();}
      return a;
    }
    public long[] readLs(int n){
      long[]a = new long[n];
      for(int i=0;i<n;i++){a[i]=readL();}
      return a;
    }
  }

  static class Write{
    PrintWriter out;
    boolean debug;
    public Write(){
      out = new PrintWriter(System.out);
      debug = false;
    }
    public <T>void pr(T str){
      out.print(str);
    }
    public <T>void pl(T str){
      out.println(str);
    }
    public void pr(int[]a){
      int t=a.length;
      if(t>0){pr(a[0]);}
      for(int i=1;i<t;i++){
        pr(" "+a[i]);
      }
      pl("");
    }
    public void pr(int[][]a){
      for(int i[]:a){
        pr(i);
      }
    }
    public void pr(long[]a){
      int t=a.length;
      if(t>0){pr(a[0]);}
      for(int i=1;i<t;i++){
        pr(" "+a[i]);
      }
      pl("");
    }
    public void pr(long[][]a){
      for(long i[]:a){
        pr(i);
      }
    }
    public void pr(String[]a){
      int t=a.length;
      if(t>0){pr(a[0]);}
      for(int i=1;i<t;i++){
        pr(" "+a[i]);
      }
      pl("");
    }
    public void pr(String[][]a){
      for(String i[]:a){
        pr(i);
      }
    }
    public void flush(){
      out.flush();
    }
    public static <T>void prA(T str){
      System.out.print(str);
    }
    public static <T>void plA(T str){
      System.out.println(str);
    }
    public static void prA(int[]a){
      int t=a.length;
      if(t>0){prA(a[0]);}
      for(int i=1;i<t;i++){
        prA(" "+a[i]);
      }
      plA("");
    }
    public static void prA(int[][]a){
      for(int i[]:a){
        prA(i);
      }
    }
    public static void prA(long[]a){
      int t=a.length;
      if(t>0){prA(a[0]);}
      for(int i=1;i<t;i++){
        prA(" "+a[i]);
      }
      plA("");
    }
    public static void prA(long[][]a){
      for(long i[]:a){
        prA(i);
      }
    }
    public static void prA(String[]a){
      int t=a.length;
      if(t>0){prA(a[0]);}
      for(int i=1;i<t;i++){
        prA(" "+a[i]);
      }
      plA("");
    }
    public static void prA(String[][]a){
      for(String i[]:a){
        prA(i);
      }
    }
    public <T>void debugP(T str){
      if(debug){
        pl(str);
      }
    }
  }
  public static long stol(String s){
    return Long.parseLong(s);
  }
  public static int stoi(String s){
    return Integer.parseInt(s);
  }
  public static int[] stoi(String s[]){
    int a[]=new int[s.length];
    for(int i=0;i<s.length;i++){
      a[i]=stoi(s[i]);
    }
    return a;
  }
  public static String itos(int i){
    return String.valueOf(i);
  }
  public static String[] itos(int[] a){
    String s[]=new String[a.length];
    for(int i=0;i<a.length;i++){
      s[i]=itos(a[i]);
    }
    return s;
  }
  public static String ctos(char c){
    return String.valueOf(c);
  }
  public static String cstos(char[] c){
    return new String(c);
  }
  public static char stoc(String s){
    return s.charAt(0);
  }
  public static char stoc(String s,int i){
    return s.charAt(i);
  }
  public static char[] stocs(String s){
    return s.toCharArray();
  }
}
