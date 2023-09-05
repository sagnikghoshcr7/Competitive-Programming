import java.lang.*;
import java.io.*;
import java.util.*;
import java.math.*;

public class Template6 implements Runnable {

    public void run() {
        int n = nextInt();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        List<Integer> zero=new ArrayList<>();
        while (n-- > 0) {
            int i=nextInt();
            if(i==0){
                zero.add(i);
            }
            else if(i>0){
                pos.add(i);
            }
            else {
                neg.add(i);
            }
        }
        if(neg.size()%2==0){
            int i=neg.get(neg.size()-1);
            neg.remove(neg.size()-1);
            zero.add(i);
        }
        if(pos.isEmpty()){
            int i=neg.get(neg.size()-1);
            neg.remove(neg.size()-1);
            int j=neg.get(neg.size()-1);
            neg.remove(neg.size()-1);
            pos.add(i);
            pos.add(j);
        }
        out.println(neg.size());
        for(int i :neg){
            out.println(i);
        }

        out.println(pos.size());
        for(int i :pos){
            out.println(i);
        }

        out.println(zero.size());
        for(int i :zero){
            out.println(i);
        }
        out.flush();
    }

    private static BufferedReader br = null;
    private static PrintWriter out = null;
    private static StringTokenizer stk = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        (new Thread(new Template6())).start();
    }

    private void loadLine() {
        try {
            stk = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String nextLine() {
        try {
            return br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Integer nextInt() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Integer.parseInt(stk.nextToken());
    }

    private Long nextLong() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Long.parseLong(stk.nextToken());
    }

    private String nextWord() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return (stk.nextToken());
    }

    private Double nextDouble() {
        while (stk==null||!stk.hasMoreTokens()) loadLine();
        return Double.parseDouble(stk.nextToken());
    }


}