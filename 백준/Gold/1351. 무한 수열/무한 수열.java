
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static long P,Q;
	
	public static long Search(long a,HashMap<Long,Long> hm) {
		if(a==0)return 1;
		if(hm.containsKey(a))
			return hm.get(a);
		
		long n_P=a/P,n_Q=a/Q;
		long value=Search(n_P,hm)+Search(n_Q,hm);
		hm.put(a,value);
		
		return value;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		long N=sc.nextLong();
		P=sc.nextLong();
		Q=sc.nextLong();
		
		HashMap<Long,Long> hm=new HashMap<>();
		
		System.out.println(Search(N,hm));
	}
}
