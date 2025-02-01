
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		HashMap<Integer,Integer> hm=new HashMap<>();
		
		int N=sc.nextInt(),M=sc.nextInt();
		
		for(int i=0;i<(N+M);i++)hm.put(sc.nextInt(),sc.nextInt());
		int area[]=new int[101];
		int dice[]={1,2,3,4,5,6};
		Queue<Integer> q=new LinkedList<>();
		q.offer(1);
		
		while(area[100]==0) {
			int pre=q.poll();
			
			for(int v :dice) {
				if(v+pre>100)continue;
				if(area[v+pre]!=0)continue;
				if(hm.containsKey(pre+v)) {
					q.offer(hm.get(pre+v));
					if(area[hm.get(pre+v)]==0) area[hm.get(pre+v)]=area[pre]+1;
				}
				else q.offer(pre+v);
				area[v+pre]=area[pre]+1;
			}
		}
		//System.out.println(Arrays.toString(area));
		System.out.println(area[100]);
	
	}
}
