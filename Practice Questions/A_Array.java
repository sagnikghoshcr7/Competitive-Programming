import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;

public class A_Array {
    private static int arrMax(int[] A) {return Arrays.stream(A).max().getAsInt();}
    private static int arrMin(int[] A) {return Arrays.stream(A).min().getAsInt();}
    private static int arrSum(int[] A) {return Arrays.stream(A).sum();}
    private static int countNumInArr(int[] A, int n) {return (int) Arrays.stream(A).filter(x -> x == n).count();}
    private static void swap(int[] A, int i, int j) { int temp = A[i]; A[i] = A[j]; A[j] = temp; }
    private static void reverse(int[] A) {int s=0,e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s) {int e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s, int e) {while(s<e){swap(A,s,e);s++;e--;}}

    private static int countSetBits(int number){int count=0; while(number>0){++count; number &= number-1;} return count;}

    private static boolean isEven (int i) { return (i & 1) == 0; }
    private static int gcd(int a, int b) {if (b == 0) return a; return gcd(b, a % b);}
    private static int lcm(int a, int b) {return (a*b)/gcd(a, b);}
    private static int[] listToArr(List<Integer> x) {return x.stream().mapToInt(i -> i).toArray();}
    private static void prtArr(int[] A) {System.out.println(Arrays.toString(A));}
    private static void prtArrWithSpce(int[] A) {for(int i=0;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtArrWithSpce(int[] A, int s) {for(int i=s;i<A.length;i++)System.out.print(A[i]+" ");}
    private static void prtArrWithSpce(int[] A, int s, int e) {for(int i=s;i<=e;i++)System.out.print(A[i]+" ");}

    // DecimalFormat df = new DecimalFormat("#.###");
    // DecimalFormat df = new DecimalFormat(); df.setMaximumFractionDigits(12);
    // System.out.println(df.format(input_Decimal_Here));

    static Scanner sc = new Scanner(System.in);
    // public static void main(String[] args) { solver(); }
    public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) solver(); }

    private static void solver() {
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);
        System.out.println("1 " + a[0]);
        if (a[n - 1] > 0) {
            System.out.println("1 " + a[n - 1]);
            System.out.print(n - 2 + " ");
            for (int i = 1; i < n - 1; i++) {
                System.out.print(a[i] + " ");
            }
        } else {
            System.out.println("2 " + a[1] + " " + a[2]);
            System.out.print(n - 3 + " ");
            for (int i = 3; i < n; i++) {
                System.out.print(a[i] + " ");
            }
        }
    }
}