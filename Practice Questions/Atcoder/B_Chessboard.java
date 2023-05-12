import java.util.*;
 
public class B_Chessboard {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String [] s = new String[8];
    String [] name = {"a", "b", "c", "d", "e", "f", "g", "h"};
    int n;
    
    for(int i = 0; i < 8; i++){
      s[i] = sc.nextLine();
      n = s[i].indexOf("*");
      if(n != -1){
        System.out.println(name[n] + (8 - i));
        break;
      }
    }
  }
}