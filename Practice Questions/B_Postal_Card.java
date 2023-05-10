import java.util.*;
public class B_Postal_Card {
    private static int arrMax(int[] arr) { return Arrays.stream(arr).max().getAsInt(); }
    private static int arrMin(int[] arr) { return Arrays.stream(arr).min().getAsInt(); }
    private static int arrSum(int[] arr) { return Arrays.stream(arr).sum(); }
    private static void swap(int[] A, int i, int j) { int temp = A[i]; A[i] = A[j]; A[j] = temp; }
    private static void reverse(int[] A) {int s=0,e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s) {int e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s, int e) {while(s<e){swap(A,s,e);s++;e--;}}

    private static int countSetBits(int number){int count=0; while(number>0){++count; number &= number-1;} return count;}

    private static boolean isEven (int i) { return (i & 1) == 0; }
    private static int gcd(int a, int b){if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b){return (a*b)/gcd(a, b);}
    private static int[] listToArr(List<Integer> x) {return x.stream().mapToInt(i -> i).toArray();}
    private static void prtArr(int[] A) {System.out.println(Arrays.toString(A));}

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) { solver(); }
    // public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) solver(); }

    private static void solver() {
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] aa = new String[N];
        String[] bb = new String[M];
        for (int i=0; i<N; i++) aa[i] = sc.next();
        for (int i=0; i<M; i++) bb[i] = sc.next();

        int count = 0;

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                String check = aa[i].substring(3, 6);
                if (check.equals(bb[j])) {count++;break;}
            }
        }
        System.out.println(count);
    }
}