import java.util.*;

class Lupy {
	int cost;
	int x;
	int y;

	Lupy(int cost, int x, int y) {
		this.cost = cost;
		this.x = x;
		this.y = y;
	}
}

public class Main {

	private static int[][] field;
	private static boolean[][] visited;
	private static int[][] cost;
	private static int N;

	private static int[] dx = { 0, 1, 0, -1 };
	private static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = 1;
		while (true) {
			N = sc.nextInt();
			if (N == 0) break;

			field = new int[N][N];
			visited = new boolean[N][N];
			cost = new int[N][N];
			PriorityQueue<Lupy> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

			sc.nextLine();
			for (int i = 0; i < N; i++)
				field[i] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			pq.offer(new Lupy(field[0][0], 0, 0));
			visited[0][0] = true;
			cost[0][0] = field[0][0]; // initialize

			while (!pq.isEmpty()) {// BFS
				Lupy pop_v = pq.poll();

				int cur_cost = pop_v.cost;
				int cur_x = pop_v.x;
				int cur_y = pop_v.y;

				for (int d = 0; d < 4; d++) {
					int next_x = cur_x + dx[d];
					int next_y = cur_y + dy[d];

					if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;
					if (visited[next_x][next_y]) continue;

					visited[next_x][next_y] = true;
					cost[next_x][next_y] = cur_cost + field[next_x][next_y];
					pq.offer(new Lupy(cost[next_x][next_y], next_x, next_y));
				}

			}

			System.out.println("Problem " + (tc++) + ": " + cost[N - 1][N - 1]);

		}
	}
}