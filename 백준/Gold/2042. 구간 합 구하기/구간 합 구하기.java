import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    //N 수개수 M 수의 변경 횟수 K구간의 합
    static long[] num;
    static long[] tree;
    static long[][] command; //명령값들 미리 저장

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new long[N];
        tree = new long[N * 4];
        command = new long[M + K][3];


        for (int i = 0; i < N; i++) num[i] = Long.parseLong(br.readLine());
        for (int i = 0; i < M + K; i++) {
            command[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        }

        initTree(0, N - 1, 0);

        for (long[] v : command) {

            long command = v[0];

            if (command == 1) {
                int idx = (int) v[1] - 1;
                long value = v[2];
                long prevValue = num[idx];
                long addValue = value - prevValue;
                num[idx] = value;
                updateTree(0, N - 1, idx, 0, addValue);

            }//b번째 수를 c로 바꾼다

            if (command == 2) {
                int idx1 = (int) v[1] - 1;
                int idx2 = (int) v[2] - 1;
                System.out.println(printTree(0, N - 1, idx1, idx2, 0));
            }//b부터 c까지 출력

        }

    }

    //범위는 start<=N<=end
    private static long initTree(int start, int end, int treeIdx) {
        int middle = (start + end) / 2;
        if (start == end) {
            return tree[treeIdx] = num[end];
        }
        return tree[treeIdx] = initTree(start, middle, treeIdx * 2 + 1) + initTree(middle + 1, end, treeIdx * 2 + 2);
    }

    private static void updateTree(int start, int end, int numIdx, int treeIdx, long addValue) {

        tree[treeIdx] += addValue;
        int middle = (start + end) / 2;
        if (start == end) {
            return;
        }
        if (numIdx <= middle) updateTree(start, middle, numIdx, treeIdx * 2 + 1, addValue);
        if (numIdx > middle) updateTree(middle + 1, end, numIdx, treeIdx * 2 + 2, addValue);
    }

    private static long printTree(int start, int end, int range1, int range2, int treeIdx) {
        int middle = (start + end) / 2;

        if (range1 == start && range2 == end) {
            return tree[treeIdx];
        }

        if (range2 <= middle) {
            return printTree(start, middle, range1, range2, treeIdx * 2 + 1);
        }

        if (range1 > middle) {
            return printTree(middle + 1, end, range1, range2, treeIdx * 2 + 2);
        }

        return printTree(start, middle, range1, middle, treeIdx * 2 + 1) + printTree(middle + 1, end, middle + 1, range2, treeIdx * 2 + 2);
    }


}
