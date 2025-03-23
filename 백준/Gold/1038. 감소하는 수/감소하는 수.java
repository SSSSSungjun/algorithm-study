
import java.util.*;

public class Main {

	static int N;
	static ArrayDeque<Long> queue;
	static int cnt = 0;
	static final long MAXCNT = 9876543210L;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		queue = new ArrayDeque<Long>();

		for (int i = 0; i < 10; i++) {
			if (i == N) {
				System.out.println(i);
				return;
			}
			queue.offerLast((long) i);
			cnt++;
		} // 초기 세팅

		while (true) {

			long popvalue = queue.pollFirst();

			if (popvalue == MAXCNT) {
				System.out.println(-1);
				return;
			}

			int base = (int) (popvalue % 10);

			for (int i = 0; i < base; i++) {
				long nextValue = popvalue * 10 + i;

				queue.offerLast(nextValue);

				if (cnt == N) {
					System.out.println(nextValue);
					return;
				}

				cnt++;
			}
		}

	}

}

//0-9

//10 
//20 21 
//30 31 32 
//40 41 42 43 
//50 51 52 53 54