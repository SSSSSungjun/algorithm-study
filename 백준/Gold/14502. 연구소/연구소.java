import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int M;
	static int[][] area;
	static List<Position> virus;
	static int count;
	static int result;
	static int min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		area = new int[N][M];
		virus = new ArrayList<>();
		
		result = 0;
		min = N*M;
		
		int total = N*M;
		
		for(int i=0; i<N; i++) {
			input = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				area[i][j] = Integer.parseInt(input[j]);
				if(area[i][j] == 2) virus.add(new Position(j,i));
				else if(area[i][j] == 1) total--;
			}
		}
		
		combination(new ArrayList<>(), 0);
		
		System.out.println(total - min- 3);
	}
	
	static boolean[][] visited;
	static int[] d = {-1, 0, 1, 0};
	
	private static void combination(List<Position> blocks, int idx) {
		
		if (blocks.size() == 3) {
			visited = new boolean[N][M];
			count = 0;
			for(Position block : blocks) area[block.y][block.x] = 1;
			for(Position v : virus) dfs(v.x, v.y);
			for(Position block : blocks) area[block.y][block.x] = 0;
			
			if(min > count) min = count;
			return;
		}
		
		if(idx >= N*M) return;
	
		if(area[idx/M][idx%M] == 0) {
			Position newPos = new Position(idx%M, idx/M);
			blocks.add(newPos);
			combination(blocks, idx+1);
			blocks.remove(newPos);
		}
		combination(blocks, idx+1);
	}
	
	private static void dfs(int x, int y) {
		if(visited[y][x]) return;
		visited[y][x] = true;
		
		count++;
		
		for(int i=0; i<4; i++) {
			int xx = x + d[i];
			int yy = y + d[(i+1)%4];
					
			if(isPossible(xx, yy) && count < min) dfs(xx,yy);
		}
	}
	
	private static boolean isPossible(int x, int y) {
		if(x<0 || y<0 || x>=M || y>=N) return false;
		if(area[y][x] == 1) return false;
		return true;
	}

}



