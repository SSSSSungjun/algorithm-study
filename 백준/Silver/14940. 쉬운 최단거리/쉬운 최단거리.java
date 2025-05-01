
import java.io.*;
import java.util.*;

class State {
	int x, y, cnt;

	State(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {

	static int[][][] field;
	static int N,M;
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		field = new int[N][M][2];
		boolean[][] visited = new boolean[N][M];

		ArrayDeque<State> queue = new ArrayDeque<State>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				field[i][k][0] = Integer.parseInt(st.nextToken());
				if (field[i][k][0] == 2) {
					queue.offerLast(new State(i, k, 0));
					visited[i][k] = true;
					
				}
			}
		}
		
		initFieldOne();
		
		while (!queue.isEmpty()) {
			State cur =queue.pollFirst();
			
			for(int d=0;d<4;d++) {
				int nx=cur.x+dx[d];
				int ny=cur.y+dy[d];
				
				if(nx<0 ||ny<0 ||nx >=N ||ny>=M)continue;
				if(visited[nx][ny])continue;
				if(field[nx][ny][0]==0)continue;
				
				visited[nx][ny]=true;
				field[nx][ny][1]=Math.max(field[nx][ny][1], cur.cnt+1);
				queue.offerLast(new State(nx,ny,cur.cnt+1));
			}
		}
		
		print();
		
	}

	public static void initFieldOne() {
		
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				field[i][k][1]=-1;
				if(field[i][k][0]==0 ||field[i][k][0]==2 ) {
					field[i][k][1]=0;
				}
			
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int k=0;k<M;k++) {
				System.out.print(field[i][k][1]+" ");
			}
			System.out.println();
		}
	}
}
