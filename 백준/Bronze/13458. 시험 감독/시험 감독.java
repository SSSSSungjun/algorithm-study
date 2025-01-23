
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		sc.nextLine();
		int[] A= Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int B=sc.nextInt(),C=sc.nextInt();
		
		long result=A.length;
		for(int i=0;i<N;i++) {
			A[i]-=B;
			int remind=(A[i]%C==0)?0:1;
			if(A[i]>0)result+=A[i]/C+remind;
		}
		
		System.out.println(result);
	}
	
	
}
