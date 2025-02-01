
import java.util.Scanner;

public class Main {
	
	public static int result=0;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		if(N==1) {
			System.out.println(1);
			return;
		}
		
		int[][] nqueen=new int [N][N];
		boolean[] visited=new boolean[N];
		for(int i=0;i<N;i++) {
			visited[i]=true;
			nqueen[0][i]=1;
			search_queen(nqueen,visited,1);
			nqueen[0][i]=0;
			visited[i]=false;
			
		}
		System.out.println(result);
	}

	private static void search_queen(int[][] nqueen, boolean[] visited, int n) {
		if (n==visited.length) {
			result++;
			return ;
		}
		
		for(int i=0;i<visited.length;i++) {
			if(visited[i])continue;
			boolean tri=true;
			int idx1=i+1,idx2=i-1;
			for(int k=n-1;k>=0;k--) {
				if(idx1<visited.length && nqueen[k][idx1++]==1)tri=false;
				if(idx2>=0 && nqueen[k][idx2--]==1)tri=false;
			}
			if(!tri)continue;
			nqueen[n][i]=1;
			visited[i]=true;
			search_queen(nqueen,visited,n+1);
			visited[i]=false;
			nqueen[n][i]=0;
		}
		
	}
}
