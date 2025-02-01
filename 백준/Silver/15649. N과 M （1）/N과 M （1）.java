
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static void back_tracking(boolean[] visited,int R,int idx,ArrayList<Integer >list) {
		if (R<=0) {
			for(int v : list)System.out.print(v+" ");
			System.out.println();
			return;
		}
		
		for(int i=0; i<visited.length;i++) {
			if(!visited[i]) {
				visited[i]=true;
				ArrayList<Integer> n_list= new ArrayList<>();
				n_list.addAll(list);
				n_list.add(i+1);
				back_tracking(visited,R-1,i,n_list);
				visited[i]=false;
			}
			
		}
		return;
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int N=sc.nextInt(), M=sc.nextInt();
		boolean[] visited=new boolean[N];
		back_tracking(visited,M,0,new ArrayList<Integer>());
		
	}

	
}
