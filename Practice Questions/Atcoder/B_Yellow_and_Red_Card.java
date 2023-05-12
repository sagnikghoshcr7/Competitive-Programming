import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;

public class B_Yellow_and_Red_Card {
    private static int arrMax(int[] A) {return Arrays.stream(A).max().getAsInt();}
    private static int arrMin(int[] A) {return Arrays.stream(A).min().getAsInt();}
    private static int arrSum(int[] A) {return Arrays.stream(A).sum();}
    private static int countNumInArr(int[] A, int n) {return (int) Arrays.stream(A).filter(x -> x == n).count();}
    private static void swap(int[] A, int i, int j) { int temp = A[i]; A[i] = A[j]; A[j] = temp; }
    private static void reverse(int[] A) {int s=0,e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s) {int e=A.length-1;while(s<e){swap(A,s,e);s++;e--;}}
    private static void reverse(int[] A, int s, int e) {while(s<e){swap(A,s,e);s++;e--;}}

    private static int countSetBits(int number){int count=0; while(number>0){++count; number &= number-1;} return count;}

    private static boolean isEven(int i) { return (i & 1) == 0; }
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
    public static void main(String[] args) { sagnik(); }
    // public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) sagnik(); }

    private static void sagnik() {
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[][] Q = new int[q][2];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2; j++) {
                Q[i][j] = sc.nextInt();
            }
        }
        
        int[] A = new int[n+1];

        for (int i=0; i<q; i++) {
            if (Q[i][0] == 1) A[Q[i][1]]++;
            if (Q[i][0] == 2) A[Q[i][1]] += 2;
            if (Q[i][0] == 3) System.out.println(A[Q[i][1]] >= 2 ? "Yes" : "No");
        }
    }
}