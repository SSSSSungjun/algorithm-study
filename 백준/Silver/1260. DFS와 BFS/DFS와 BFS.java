


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
	
	public static String DFS_fun(boolean[] visited,int[][] graph,int current_value,String result) {
		visited[current_value]=true;
		result+=current_value+" ";
		for( int i=1 ;i<graph.length;i++) {
			if(!visited[i] && graph[current_value][i] ==1 ) {
				result= DFS_fun(visited,graph,i,result);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int N=sc.nextInt(), M=sc.nextInt(), V=sc.nextInt();
		
		int[][] graph= new int[N+1][N+1];
		boolean[] visited=new boolean[N+1];
		
		for(int i=0;i<M;i++) {
			int v1=sc.nextInt(), v2=sc.nextInt();
			graph[v1][v2]=1;
			graph[v2][v1]=1;
		}
		
		visited[V]=true;
		System.out.println( DFS_fun(visited,graph,V,"")) ;
		
		
		StringBuilder BFS = new StringBuilder();
		visited=new boolean[N+1];
		
		Queue<Integer> queue =new LinkedList<>();
		queue.offer(V);
		visited[V]=true;
		
		while(!queue.isEmpty()) {
			int next=queue.poll();
			BFS.append(next).append(' ');
			for(int i =1; i<N+1;i++) {
				if(!visited[i] && graph[next][i]==1) {
					visited[i]=true;
					queue.offer(i);
				}
			}
			
		}
		System.out.println(BFS);
		
	}
}
