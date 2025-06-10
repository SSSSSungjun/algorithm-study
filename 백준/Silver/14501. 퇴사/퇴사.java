
import java.io.*;
import java.util.*;

public class Main {

	static int[] dp;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];

		int result = 0;

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(st.nextToken()) + i - 1;
			int cost = Integer.parseInt(st.nextToken());

			if (end > N)
				continue;

			int prev_max_cost = 0;

			for (int k = 0; k < i; k++) {
				prev_max_cost = Math.max(prev_max_cost, dp[k]);
			}

			dp[end] = Math.max(prev_max_cost + cost, dp[end]);
			result = Math.max(result, dp[end]);
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(result);

	}

}
