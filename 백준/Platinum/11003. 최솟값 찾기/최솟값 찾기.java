import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            
            while (!deque.isEmpty() && deque.peekLast()[0] > input) {
                deque.pollLast();
            }
            
            deque.offerLast(new int[]{input, i});
            
            if (deque.peekFirst()[1] <= i - L) {
                deque.pollFirst();
            }
            sb.append(deque.peekFirst()[0]).append(" ");
        }
        System.out.println(sb);
    }
}
// Scanner로는 안풀리고 BufferedReader로는 풀리면 좀 화날거같다
// 일단 해본다