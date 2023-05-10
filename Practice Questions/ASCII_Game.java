import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
import java.lang.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.io.*;

public class ASCII_Game {
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

    // DecimalFormat df = new DecimalFormat("#.###");
    // DecimalFormat df = new DecimalFormat(); df.setMaximumFractionDigits(12);
    // System.out.println(df.format(input_Decimal_Here));

    static Scanner sc = new Scanner(System.in);
    // public static void main(String[] args) { solver(); }
    public static void main(String[] args) { int t = sc.nextInt(); while(t-->0) solver(); }

    private static void solver() {
        int res[] = new int[26];
        String N = sc.next();

        for (int i = 0; i < N.length() - 1; i++) {
            for (int j = i + 1; j < N.length(); j++) {
                String x = N.charAt(i) + "";
                String y = N.charAt(j) + "";
                int a = Integer.parseInt(x.concat(y));
                int b = Integer.parseInt(y.concat(x));
                if (a - 65 >= 0 && a - 65 <= 25)
                    res[a - 65] = 1;
                if (b - 65 >= 0 && b - 65 <= 25)
                    res[b - 65] = 1;
            }
        }

        String str = "";
        for (int i = 0; i < 26; i++) {
            if (res[i] == 1)
                str += (char) (65 + i);
        }
        System.out.println(str);
    }
}