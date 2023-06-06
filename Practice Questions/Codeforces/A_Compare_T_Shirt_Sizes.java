import java.util.*;
public class A_Compare_T_Shirt_Sizes {
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
    // public static void main(String[] args) { solver(); }
    public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) solver(); }

    private static void solver() {
        String one = sc.next();
        String two = sc.next();
        int x1 = one.length()-1;
        int x2 = two.length()-1;
        char l1 = one.charAt(one.length() - 1);
        char l2 = two.charAt(two.length() - 1);
        if(l1==l2) {
            if(x1==x2) System.out.println("=");
            else if((x1>x2 && l1=='S') || (x1<x2 && l1=='L')) System.out.println("<");
            else System.out.println(">");
        }
        else if(l1=='S' && l2!='S') System.out.println("<");
        else if(l1=='M' && l2=='L') System.out.println("<");
        else System.out.println(">");
    }
}