
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	StringTokenizer st = new StringTokenizer(br.readLine());

	N = Integer.parseInt(st.nextToken());
	M = Integer.parseInt(st.nextToken());
	field = new int[N][M];
	visited = new boolean[N][M];

	for (int i = 0; i < N; i++) {
	    st = new StringTokenizer(br.readLine());
	    for (int k = 0; k < M; k++) {
		field[i][k] = Integer.parseInt(st.nextToken());
	    }
	}
	// 여기까지 init;

	int time = 0; // 결과값
	while (true) {

	    if (init())
		break;
	    BFS_verO2();
	    BFS_verCheeze();
	    //Debug();
	    time++;
	}

	System.out.println(time);

    }

    private static boolean init() { // 한번 시뮬 끝날때마다 세팅

	boolean isAllZero = true;
	for (int i = 0; i < N; i++) {
	    for (int k = 0; k < M; k++) {
		visited[i][k] = false;

		if (field[i][k] == 9)
		    field[i][k] = 0;
		if (field[i][k] != 0)
		    isAllZero = false;
	    }
	}

	return isAllZero;
    }

    private static void BFS_verO2() { // 공기를 BFS를 통하여 외부공기 내부공기 솎아낸다

	ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
	ArrayDeque<int[]> tmpQ = new ArrayDeque<int[]>(); // 내부공기가 판별되면 -1로 채워넣게

	for (int i = 0; i < N; i++) {
	    for (int k = 0; k < M; k++) {
		if (!visited[i][k] && field[i][k] == 0) {

		    queue.offerLast(new int[] { i, k });
		    tmpQ.offerLast(new int[] { i, k });
		    visited[i][k] = true;
		    boolean isOuterO2 = false;

		    while (!queue.isEmpty()) {
			int[] cur = queue.pollFirst();

			int curx = cur[0], cury = cur[1];

			for (int d = 0; d < 4; d++) {
			    int nx = curx + dx[d];
			    int ny = cury + dy[d];

			    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				isOuterO2 = true;
				continue;
			    }

			    if (field[nx][ny] == 1)
				continue;
			    if (visited[nx][ny])
				continue;

			    queue.offerLast(new int[] { nx, ny });
			    tmpQ.offerLast(new int[] { nx, ny });
			    visited[nx][ny] = true;
			}

		    } // 여기까지가 BFS작업

		    if (!isOuterO2) {
			while (!tmpQ.isEmpty()) {
			    int[] pop = tmpQ.pollFirst();

			    field[pop[0]][pop[1]] = 9;
			}
		    } // 내부공기 작업
		    tmpQ.clear();
		} // if
	    }
	}

    }

    private static void BFS_verCheeze() { // 치즈 녹이기 작업 치기.

	ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
	ArrayDeque<int[]> tmpQ = new ArrayDeque<int[]>(); // 녹을 놈들 한번에 하게. 바로바로 하면 다녹음

	for (int i = 0; i < N; i++) {
	    for (int k = 0; k < M; k++) {
		if (!visited[i][k] && field[i][k] == 1) {
		    queue.offerLast(new int[] { i, k });
		    visited[i][k] = true;

		    while (!queue.isEmpty()) {
			int[] cur = queue.pollFirst();

			int curx = cur[0], cury = cur[1];

			int outerO2cnt = 0; // 바깥공기 몇갠지 체크하게

			for (int d = 0; d < 4; d++) {
			    int nx = curx + dx[d];
			    int ny = cury + dy[d];

			    if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			    if (field[nx][ny] == 0) {
				outerO2cnt++;
				continue;
			    }

			    if (visited[nx][ny])
				continue;

			    queue.offerLast(new int[] { nx, ny });
			    visited[nx][ny] = true;
			}

			if (outerO2cnt >= 2) {
			    tmpQ.offerLast(new int[] { curx, cury });
			}
		    }

		    while (!tmpQ.isEmpty()) {
			int[] pop = tmpQ.pollFirst();
			field[pop[0]][pop[1]] = 0;
		    }

		}

	    }
	}

    }

//    private static void Debug() {
//	for (int i = 0; i < N; i++) {
//	    for (int k = 0; k < M; k++) {
//		System.out.print(field[i][k] + " ");
//	    }
//	    System.out.println();
//	}
//	System.out.println("------------------");
//
//    }
}
