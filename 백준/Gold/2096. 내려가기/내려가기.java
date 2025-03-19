
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int N = Integer.parseInt(br.readLine());
	int[][] field = new int[N][3];

	for (int i = 0; i < N; i++) {
	    field[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	int[][] dp = new int[3][2]; // 0: max, 1: min
	int[][] prev = new int[3][2]; // 이전 줄 저장

	// 초기값 설정
	for (int i = 0; i < 3; i++) {
	    prev[i][0] = prev[i][1] = 0;
	}

	for (int i = 0; i < N; i++) {
	    // 최대값 갱신
	    dp[0][0] = Math.max(prev[0][0], prev[1][0]) + field[i][0];
	    dp[1][0] = Math.max(prev[0][0], Math.max(prev[1][0], prev[2][0])) + field[i][1];
	    dp[2][0] = Math.max(prev[1][0], prev[2][0]) + field[i][2];

	    // 최소값 갱신
	    dp[0][1] = Math.min(prev[0][1], prev[1][1]) + field[i][0];
	    dp[1][1] = Math.min(prev[0][1], Math.min(prev[1][1], prev[2][1])) + field[i][1];
	    dp[2][1] = Math.min(prev[1][1], prev[2][1]) + field[i][2];

	    // 이전 줄을 현재 줄로 업데이트
	    for (int j = 0; j < 3; j++) {
		prev[j][0] = dp[j][0];
		prev[j][1] = dp[j][1];
	    }
	}

	// 최종 결과 출력
	int maxResult = Math.max(dp[0][0], Math.max(dp[1][0], dp[2][0]));
	int minResult = Math.min(dp[0][1], Math.min(dp[1][1], dp[2][1]));

	System.out.println(maxResult + " " + minResult);
    }
}
