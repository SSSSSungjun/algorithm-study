
import java.util.Scanner;

public class Main {

	private static int result = -1;

	private static void 분할정복(int a, int b, int v, int len, int r, int c) {
		if (len == 1) { // 크기가 1이 되었을 때 정답 반환
			result = v;
			return;
		}

		int half = len / 2;
		int area = (len * len) / 4;

		// 1사분면
		if (r < half && c < half) {
			분할정복(a, b, v, half, r, c);
		}
		// 2사분면
		else if (r < half && c >= half) {
			분할정복(a, b + half, v + area, half, r, c - half);
		}
		// 3사분면
		else if (r >= half && c < half) {
			분할정복(a + half, b, v + 2 * area, half, r - half, c);
		}
		// 4사분면
		else {
			분할정복(a + half, b + half, v + 3 * area, half, r - half, c - half);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int L = 1 << N; // 2^N

		분할정복(0, 0, 0, L, r, c);
		System.out.println(result);
	}
}
