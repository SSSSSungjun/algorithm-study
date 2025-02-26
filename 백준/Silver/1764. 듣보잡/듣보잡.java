import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(), M = sc.nextInt();

		HashSet<String> hashSet = new HashSet<>();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < N + M; i++) {
			if (i < N) {
				hashSet.add(sc.next());
			} else {
				String input = sc.next();
				if (hashSet.contains(input))
					pq.offer(input);
			}
		}

		System.out.println(pq.size());
		while (!pq.isEmpty())
			System.out.println(pq.poll());
	}
}