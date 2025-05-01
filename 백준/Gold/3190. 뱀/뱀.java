
import java.io.*;
import java.util.*;

public class Main {

	static final int APPLE = 9;
	static final int SNAKE = 6;
	static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int field[][] = new int[N][N];
		HashMap<Integer, Character> command = new HashMap<>();
		int cur_direction = 0;

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;

			field[x][y] = APPLE;
		}

		int L = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			char value = st.nextToken().charAt(0);
			command.put(key, value);
		}

		int time = 0;
		ArrayDeque<int[]> snake = new ArrayDeque<>();
		field[0][0] = SNAKE;
		snake.offerLast(new int[] { 0, 0 });

		while (true) {

			int nx = snake.peekFirst()[0] + direction[cur_direction][0];
			int ny = snake.peekFirst()[1] + direction[cur_direction][1];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
				time++;
				break;
			}
			if (field[nx][ny] == SNAKE) {
				time++;
				break;
			}

			if (field[nx][ny] != APPLE) {
				snake.offerFirst(new int[] { nx, ny });
				field[nx][ny] = SNAKE;

				int[] tail = snake.pollLast();
				int x = tail[0], y = tail[1];
				field[x][y] = 0;
			} else {
				snake.offerFirst(new int[] { nx, ny });
				field[nx][ny] = SNAKE;
			}

			time++;

			if (command.containsKey(time)) {
				cur_direction = ChangeDirection(cur_direction, command.get(time));
			}

		}

		System.out.println(time);

	}

	public static int ChangeDirection(int direction, char command) {
		int changeCommand = -1;

		switch (direction) {
		case 0:
			changeCommand = (command == 'L') ? 3 : 1;
			break;
		case 1:
			changeCommand = (command == 'L') ? 0 : 2;
			break;
		case 2:
			changeCommand = (command == 'L') ? 1 : 3;
			break;
		case 3:
			changeCommand = (command == 'L') ? 2 : 0;
			break;
		}

		return changeCommand;
	}

}
