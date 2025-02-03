

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
  public int a;
  public int b;

  Pair(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public int getA() {
    return a;
  }

  public int getB() {
    return b;
  }
}


public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    ArrayList<Pair> p = new ArrayList<>();
    int N = sc.nextInt();

    for (int i = 0; i < N; i++)
      p.add(new Pair(sc.nextInt(), sc.nextInt()));
    p.sort(Comparator.comparing(Pair::getB).thenComparing(Pair::getA));

    int pre = -1, result = 0;

    for (Pair v : p) {
      if (pre <= v.getA()) {
        result++;
        pre = v.getB();
      }
    }
    System.out.println(result);
  }

}
