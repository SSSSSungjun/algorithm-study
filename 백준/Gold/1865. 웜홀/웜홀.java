
import java.io.*;
import java.util.*;

class Node {
    int cur;
    int next;
    int cost;

    Node(int cur, int next, int cost) {
	this.cur = cur;
	this.next = next;
	this.cost = cost;
    }
}

public class Main {
    private static int N, M, W;
    private static ArrayList<Node> field;
    private static int[] distance;

    private static final int MAXVALUE = 100000000;

    public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	int TC = Integer.parseInt(br.readLine());

	for (int tc = 0; tc < TC; tc++) {
	    int[] NMW = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

	    N = NMW[0]; // 정점 수
	    M = NMW[1]; // 간선 수
	    W = NMW[2]; // 웜홀 수
	    field = new ArrayList<Node>();
	    distance = new int[N + 1];

	    for (int m = 0; m < M; m++) {
		int[] SET = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int edge1 = SET[0];
		int edge2 = SET[1];
		int cost = SET[2];
		field.add(new Node(edge1, edge2, cost));
		field.add(new Node(edge2, edge1, cost));

	    }

	    for (int w = 0; w < W; w++) {
		int[] SET = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int edge = SET[0];
		int next = SET[1];
		int cost = -SET[2]; // 웜홀 음수처리
		field.add(new Node(edge, next, cost));
	    }

	    boolean isTrue = false;

	    for (int i = 1; i <= N; i++) {
		field.add(new Node(0, i, 0)); // 가성의 0번쨰로 일단 모든 노드를 잇는다.
	    }

	    isTrue = Bellman_Ford(0);
	    System.out.println((isTrue) ? "YES" : "NO");
	}
    }

    private static boolean Bellman_Ford(int start) {

	Arrays.fill(distance, MAXVALUE);
	distance[start] = 0;
	for (int i = 0; i <= N; i++) {
	    for (Node node : field) {

		int curNode = node.cur;
		int nextNode = node.next;
		int cost = node.cost;

		if (distance[curNode] != MAXVALUE && distance[nextNode] > distance[curNode] + cost) {
		    distance[nextNode] = distance[curNode] + cost;

		    if (i == N)
			return true;
		}

	    }

	    //System.out.println(Arrays.toString(distance));
	}

	return false;

    }

}
