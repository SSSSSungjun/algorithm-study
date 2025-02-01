


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static int[] dx= {0,1,0,-1};
	public static int[] dy= {1,0,-1,0};
	
	
 	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(),M=sc.nextInt();
		int field[][]=new int[N][M];
		boolean visited[][]=new boolean[N][M];
	
		for(int i=0;i<N;i++)field[i]=Arrays.stream(sc.next().split("")).mapToInt(Integer::parseInt).toArray();
		
		Queue<int[]> q=new LinkedList<>();
		visited[0][0]=true;
		q.offer(new int[]{0,0});
		
		while(!q.isEmpty()) {
			int[] crt=q.poll();
			
			for(int d=0;d<4;d++) {
				int n_x=crt[0]+dx[d],n_y=crt[1]+dy[d];
				if(n_x<0 || n_y<0 ||n_x>=N || n_y>=M)continue;
				if(visited[n_x][n_y])continue;
				if(field[n_x][n_y]==0)continue;
				q.offer(new int[] {n_x,n_y});
				visited[n_x][n_y]=true;
				field[n_x][n_y]=field[crt[0]][crt[1]]+1;
			}
		}
	
		System.out.println(field[N-1][M-1]);
	}
}
