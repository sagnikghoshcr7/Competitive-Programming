import java.util.*;
public class A_Add_Plus_Minus_Sign {
    private static int arrMax(int[] arr) { return Arrays.stream(arr).max().getAsInt(); }
    private static int arrMin(int[] arr) { return Arrays.stream(arr).min().getAsInt(); }
    private static int arrSum(int[] arr) { return Arrays.stream(arr).sum(); }
    private static void swap(int[] A, int i, int j) { int temp = A[i]; A[i] = A[j]; A[j] = temp; }
    public static void reverse(int[] A) {int s=0,e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    public static void reverse(int[] A, int s) {int e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    public static void reverse(int[] A, int s, int e) {while(s<e){swap(A,s,e);s++;e--;}}

    public static int countSetBits(int number){int count=0; while(number>0){++count; number &= number-1;} return count;}

    private static boolean isEven (int i) { return (i & 1) == 0; }
    private static int gcd(int a, int b){if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b){return (a*b)/gcd(a, b);}
    private static int[] listToArr(List<Integer> x) {return x.stream().mapToInt(i -> i).toArray();}
    private static void prtArr(int[] A) {System.out.println(Arrays.toString(A));}

    static Scanner sc = new Scanner(System.in);
    // public static void main(String[] args) { solver(); }
    public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) solver(); }

    private static void solver() {
      int n = sc.nextInt();
      String s = sc.next();
      int[] A = new int[n];
      for (int i = 0; i < n; i++) A[i] = s.charAt(i) - '0';

      int ans = A[0];
      StringBuilder sb = new StringBuilder();
      for (int i=1; i<n; i++) {
        if (ans == 1 && A[i] == 1) {
          ans--; sb.append("-");
        } else if (ans == 0 && A[i] == 1) {
          ans++; sb.append("+");
        } else {
          sb.append("+");
        }
      }
      System.out.println(sb.toString());
    }
}