import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int M=sc.nextInt(), N=sc.nextInt();
		sc.nextLine();
		int arr[] = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int max_value=Arrays.stream(arr).max().getAsInt();	
		int idx_min=0, idx_max=max_value;
		int max_len_snack=0;
		int idx_middle=idx_max;
		
		while(idx_min<=idx_max && idx_middle>0) {
			
			int cnt=0;
			for(int i=0;i<arr.length;i++) 
				cnt+=arr[i]/idx_middle;
			
			if(cnt<M)idx_max=idx_middle-1;
			else{
				max_len_snack=Math.max(idx_middle, max_len_snack);
				idx_min=idx_middle+1;
			}
			
			if(cnt>=M)max_len_snack=Math.max(idx_middle, max_len_snack);
			idx_middle=(idx_max+idx_min)/2;		
		}
	
		System.out.println(max_len_snack);
	}
}
