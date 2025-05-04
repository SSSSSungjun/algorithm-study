
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[0] - b[0];
		});

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			pq.offer(new int[] { x, y });
		}

		int result = 0;

		if (pq.peek()[1] != 0)
			stack.offerLast(0);
		stack.offerLast(pq.poll()[1]);

		while (!pq.isEmpty()) {

			if (stack.peekLast() > pq.peek()[1]) {
				while (!stack.isEmpty() && stack.peekLast() >= pq.peek()[1]) {

					if (stack.peekLast() != pq.peek()[1])
						result++;
					stack.pollLast();

				}
			}

			stack.offerLast(pq.poll()[1]);

		}

		System.out.println(result + stack.size() - 1);

		// 구조를 오름차순이 될 수 있도록

	}
}
