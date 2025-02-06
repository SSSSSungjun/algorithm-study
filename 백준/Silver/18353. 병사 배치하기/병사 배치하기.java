
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] arr = Arrays.stream(("0 " + sc.nextLine()).split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] dp = new int[N + 1];

		dp[1] = 1;
		int max_len=1;
		for(int i=2;i<N+1;i++) {
			dp[i]=1;
			for(int k=1;k<i;k++) {
				if(arr[k]>arr[i]) {
					dp[i]=Math.max(dp[k]+1, dp[i]);
				}
			}
			max_len=Math.max(dp[i],max_len);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(N - max_len);
	}
}
