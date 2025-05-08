
import java.io.*;
import java.util.*;

class State{
	int x,y,cnt;
	
	State(int x, int y, int cnt){
		this.x=x;
		this.y=y;
		this.cnt=cnt; //불이면 -1 박게
	}
}

public class Main {
	
	static int R,C;
	static char[][] field;
	static int[][] visited; //불 visited 하고 지훈이 구분
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int result=Integer.MAX_VALUE;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		field=new char[R][C];
		visited=new int[R][C];
		
		ArrayDeque<State> queueJ=new ArrayDeque<>();
		ArrayDeque<State> queueF=new ArrayDeque<>();
		
		for(int i=0;i<R;i++) {
			String input=br.readLine();
			
				for(int k=0;k<C;k++){
				field[i][k]=input.charAt(k);
				if(field[i][k]=='J') {
					queueJ.offerLast(new State(i,k,1));
					visited[i][k]=-1;
				}
				
				if(field[i][k]=='F') {
					queueF.offerLast(new State (i,k,1));
					visited[i][k]=1;
				}
			}
		}
		
	
		int time=1;
		while(!queueJ.isEmpty()) {
			//불 부터
			
			while(!queueF.isEmpty() && queueF.peek().cnt==time) {
				State cur=queueF.pollFirst();
				
				for(int d=0;d<4;d++) {
					int nx=cur.x+dx[d];
					int ny=cur.y+dy[d];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C)continue;
					if(field[nx][ny]=='#' || visited[nx][ny]==1)continue;
					
					field[nx][ny]='F';
					visited[nx][ny]=1;
					queueF.offerLast(new State(nx,ny,cur.cnt+1));
				}
			}
			
			
			while(!queueJ.isEmpty() && queueJ.peek().cnt==time) {
				State cur=queueJ.pollFirst();	
				for(int d=0;d<4;d++) {
					int nx=cur.x+dx[d];
					int ny=cur.y+dy[d];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C) {
						result=Math.min(result, cur.cnt);
						break;
					}
					
					if(field[nx][ny]=='#' || visited[nx][ny]==-1)continue;
					if(field[nx][ny]=='F')continue;
					
					visited[nx][ny]=-1;
					queueJ.offerLast(new State(nx,ny,cur.cnt+1));
				}
			}
			
			time++;
			
				
		}
	
		
		System.out.println((result==Integer.MAX_VALUE) ? "IMPOSSIBLE" : result);
		
		
	}
}
