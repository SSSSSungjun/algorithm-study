
import java.io.*;
import java.util.*;

class Node {
	int prev;
	int next;
	int cost;

	public Node(int prev, int next, int cost) {
		this.prev = prev;
		this.next = next;
		this.cost = cost;
	}

}

public class Main {

	private static int N, M;
	private static ArrayList<Node> field;
	private static long[] distance;
	private static final int MAXVALUE = 1000000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		field = new ArrayList<Node>();
		distance = new long[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			field.add(new Node(A, B, C));
		}

		if (Bellman_Ford()) {
			System.out.println(-1);
			return;
		} // 음수사이클있으면 true반환

		for (int i = 2; i < N + 1; i++) {
			System.out.println((distance[i] == MAXVALUE) ? -1 : distance[i]);
		}
	}

	private static boolean Bellman_Ford() {
		Arrays.fill(distance, MAXVALUE);
		distance[1] = 0;

		for (int i = 0; i < N; i++) {
			for (Node n : field) {
				int prev = n.prev;
				int next = n.next;
				int cost = n.cost;

				if (distance[prev] != MAXVALUE && distance[next] > distance[prev] + cost) {
					distance[next] = distance[prev] + cost;

					if (i == N - 1)
						return true;
				}
			}
		}

		return false;
	}

}
