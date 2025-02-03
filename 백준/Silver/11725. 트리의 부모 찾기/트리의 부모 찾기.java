
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N=sc.nextInt();
		List<List<Integer>> field=new ArrayList<>();
		for(int i=0;i<N+1;i++)field.add(new ArrayList<Integer>());
		for(int i=0;i<N-1;i++) {
			int a=sc.nextInt(),b=sc.nextInt();
			field.get(a).add(b);
			field.get(b).add(a);
		}
		int visited[]=new int[N+1];
		Queue<Integer> q=new LinkedList<>(); 
		q.offer(1);
		visited[1]=1;
		
		while(!q.isEmpty()) {
			int v=q.poll();
			
			
			for(int i : field.get(v)) {
				if(visited[i]!=0)continue;
				visited[i]=v;
				q.offer(i);
			}
			
		}
		
		for(int i=2;i<N+1;i++)System.out.println(visited[i]);
	}
}
