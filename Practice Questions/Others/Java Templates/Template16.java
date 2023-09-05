import java.io.*;
import java.lang.Math;
import java.lang.reflect.Array;
import java.util.*;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

public final class Template16 {

  static BufferedReader br = new BufferedReader(
    new InputStreamReader(System.in)
  );
  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );
  static StringTokenizer st;

  /*write your constructor and global variables here*/

  static class sortCond implements Comparator<Pair<Integer, Integer>> {

    @Override
    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
      if (p1.a <= p2.a) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  static class Rec {

    int a;
    int b;
    long c;

    Rec(int a, int b, long c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  static class Pair<f, s> {

    f a;
    s b;

    Pair(f a, s b) {
      this.a = a;
      this.b = b;
    }
  }

  interface modOperations {
    int mod(int a, int b, int mod);
  }

  static int findBinaryExponentian(int a, int pow, int mod) {
    if (pow == 1) {
      return a;
    } else if (pow == 0) {
      return 1;
    } else {
      int retVal = findBinaryExponentian(a, (int) pow / 2, mod);
      return modMul.mod(
        modMul.mod(retVal, retVal, mod),
        (pow % 2 == 0) ? 1 : a,
        mod
      );
    }
  }

  static int findPow(int a, int b, int mod) {
    if (b == 1) {
      return a % mod;
    } else if (b == 0) {
      return 1;
    } else {
      int res = findPow(a, (int) b / 2, mod);
      return modMul.mod(res, modMul.mod(res, (b % 2 == 1 ? a : 1), mod), mod);
    }
  }

  static int bleft(long ele, ArrayList<Long> sortedArr) {
    int l = 0;
    int h = sortedArr.size() - 1;
    int ans = -1;
    while (l <= h) {
      int mid = l + (int) (h - l) / 2;
      if (sortedArr.get(mid) < ele) {
        l = mid + 1;
      } else if (sortedArr.get(mid) >= ele) {
        ans = mid;
        h = mid - 1;
      }
    }
    return ans;
  }

  static long gcd(long a, long b) {
    long div = b;
    long rem = a % b;
    while (rem != 0) {
      long temp = rem;
      rem = div % rem;
      div = temp;
    }
    return div;
  }

  static int log(int no) {
    int i = 0;
    while ((1 << i) <= no) {
      i++;
    }
    if ((1 << (i - 1)) == no) {
      return i - 1;
    } else {
      return i;
    }
  }

  static modOperations modAdd = (int a, int b, int mod) -> {
    return (a % mod + b % mod) % mod;
  };
  static modOperations modSub = (int a, int b, int mod) -> {
    return (int) ((1l * a % mod - 1l * b % mod + 1l * mod) % mod);
  };
  static modOperations modMul = (int a, int b, int mod) -> {
    return (int) ((1l * (a % mod) * 1l * (b % mod)) % (1l * mod));
  };
  static modOperations modDiv = (int a, int b, int mod) -> {
    return modMul.mod(a, findBinaryExponentian(b, mod - 1, mod), mod);
  };

  static HashSet<Integer> primeList(int MAXI) {
    int[] prime = new int[MAXI + 1];
    HashSet<Integer> obj = new HashSet<>();
    for (int i = 2; i <= (int) Math.sqrt(MAXI) + 1; i++) {
      if (prime[i] == 0) {
        obj.add(i);
        for (int j = i * i; j <= MAXI; j += i) {
          prime[j] = 1;
        }
      }
    }
    for (int i = (int) Math.sqrt(MAXI) + 1; i <= MAXI; i++) {
      if (prime[i] == 0) {
        obj.add(i);
      }
    }
    return obj;
  }

  static int[] factorialList(int MAXI, int mod) {
    int[] factorial = new int[MAXI + 1];
    factorial[2] = 1;
    for (int i = 3; i < MAXI + 1; i++) {
      factorial[i] = modMul.mod(factorial[i - 1], i, mod);
    }
    return factorial;
  }

  static void put(HashMap<Integer, Integer> cnt, int key) {
    if (cnt.containsKey(key)) {
      cnt.replace(key, cnt.get(key) + 1);
    } else {
      cnt.put(key, 1);
    }
  }

  static long arrSum(ArrayList<Long> arr) {
    long tot = 0;
    for (int i = 0; i < arr.size(); i++) {
      tot += arr.get(i);
    }
    return tot;
  }

  static int ord(char b) {
    return (int) b - (int) 'a';
  }

  static int optimSearch(int[] cnt, int lower_bound, int pow, int n) {
    int l = lower_bound + 1;
    int h = n;
    int ans = 0;
    while (l <= h) {
      int mid = l + (h - l) / 2;
      if (cnt[mid] - cnt[lower_bound] == pow) {
        return mid;
      } else if (cnt[mid] - cnt[lower_bound] < pow) {
        ans = mid;
        l = mid + 1;
      } else {
        h = mid - 1;
      }
    }
    return ans;
  }

  static Pair<Long, Integer> ret_ans(ArrayList<Integer> ans) {
    int size = ans.size();
    int mini = 1000000000 + 1;
    long tit = 0l;
    for (int i = 0; i < size; i++) {
      tit += 1l * ans.get(i);
      mini = Math.min(mini, ans.get(i));
    }
    return new Pair<>(tit - mini, mini);
  }

  static int factorList(
    HashMap<Integer, Integer> maps,
    int no,
    int maxK,
    int req
  ) {
    int i = 1;
    while (i * i <= no) {
      if (no % i == 0) {
        if (i != no / i) {
          put(maps, no / i);
        }
        put(maps, i);
        if (maps.get(i) == req) {
          maxK = Math.max(maxK, i);
        }
        if (maps.get(no / i) == req) {
          maxK = Math.max(maxK, no / i);
        }
      }
      i++;
    }
    return maxK;
  }

  static ArrayList<Integer> getKeys(HashMap<Integer, Integer> maps) {
    ArrayList<Integer> vals = new ArrayList<>();
    for (Map.Entry<Integer, Integer> map : maps.entrySet()) {
      vals.add(map.getKey());
    }
    return vals;
  }

  static ArrayList<Integer> getValues(HashMap<Integer, Integer> maps) {
    ArrayList<Integer> vals = new ArrayList<>();
    for (Map.Entry<Integer, Integer> map : maps.entrySet()) {
      vals.add(map.getValue());
    }
    return vals;
  }

  /*write your  methods here*/
  static int getMax(ArrayList<Integer> arr) {
    int max = arr.get(0);
    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i) > max) {
        max = arr.get(i);
      }
    }
    return max;
  }

  static int getMin(ArrayList<Integer> arr) {
    int max = arr.get(0);
    for (int i = 1; i < arr.size(); i++) {
      if (arr.get(i) < max) {
        max = arr.get(i);
      }
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    int cases = Integer.parseInt(br.readLine()), n, i, j;
    while (cases-- != 0) {
      n = Integer.parseInt(br.readLine());
      String s = br.readLine();
      int op = 0;
      if (n == 1) {
        bw.write("0 1\n");
      } else {
        int p1 = 0;
        int start = 0;
        while (p1 < n) {
          char s1 = s.charAt(p1);
          char s2 = p1 + 1 < n ? s.charAt(p1 + 1) : '@';
          if (s2 == '@') {
            break;
          } else {
            if (s1 == '(') {
              p1 += 2;
              start += 2;
              op++;
            } else if (s1 == ')' && s2 == ')') {
              p1 += 2;
              start += 2;
              op++;
            } else {
              p1 += 1;
              while (p1 < n && s.charAt(p1) != ')') {
                p1++;
              }
              if (p1 != n) {
                op++;
                p1++;
                start = p1;
              }
            }
          }
        }
        bw.write(
          Integer.toString(op) + " " + Integer.toString(n - start) + "\n"
        );
      }
    }
    bw.flush();
  }
}
