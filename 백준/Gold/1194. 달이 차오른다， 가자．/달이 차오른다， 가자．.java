
import java.io.*;
import java.util.*;

class Minsik {
	int x, y, key, step;

	public Minsik(int x, int y, int key, int step) {
		this.x = x;
		this.y = y;
		this.key = key;
		this.step = step;
	}

}

public class Main {

	static int N, M;
	static char[][] field;
	static boolean visited[][][];
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		field = new char[N][M];
		visited = new boolean[N][M][64];

		ArrayDeque<Minsik> queue = new ArrayDeque<Minsik>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int k = 0; k < M; k++) {
				field[i][k] = input.charAt(k);
				if (field[i][k] == '0') {
					queue.offerLast(new Minsik(i, k, 0, 0));
				}
			}
		} // init

		while (!queue.isEmpty()) {
			Minsik cur = queue.pollFirst();
		
			if (field[cur.x][cur.y] == '1') {
				System.out.println(cur.step);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				int nkey = cur.key;

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if (field[nx][ny] == '#')
					continue;

				if (visited[nx][ny][nkey])
					continue;

				if (Character.isUpperCase(field[nx][ny]) && ((Mask(field[nx][ny]) & nkey) == 0))
					continue;

				if (Character.isLowerCase(field[nx][ny]))
					nkey |= Mask(field[nx][ny]);

				visited[nx][ny][nkey] = true;
				queue.offerLast(new Minsik(nx, ny, nkey, cur.step + 1));

			}
		}

		System.out.println(-1);

	}

	public static int Mask(char alpha) {
		return 1 << (Character.toLowerCase(alpha) - 'a');
	}

}
