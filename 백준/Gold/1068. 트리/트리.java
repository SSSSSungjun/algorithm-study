
import java.util.*;

class Node {
	int parent;
	ArrayList<Integer> children;

	public Node(int parent) {
		this.parent = parent;
		children = new ArrayList<Integer>();
	}

	public void addChild(int n) {
		children.add(n);
	}
}

public class Main {
	static int leaf;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Node[] tree = new Node[N];
		int rootNodeId = 0;

		int[] parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = sc.nextInt();
			tree[i] = new Node(parents[i]);
		}

		for (int i = 0; i < N; i++) {
			if (parents[i] == -1)
				rootNodeId = i;
			if (parents[i] != -1)
				tree[parents[i]].addChild(i);

		}

		int removeNodeId = sc.nextInt();

		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack.add(rootNodeId);

		while (!stack.isEmpty()) {
			int cur = stack.pollLast(); // id겠지?

			if (cur == removeNodeId)
				continue;

			for (int next : tree[cur].children) {
				if (next == removeNodeId) {

					if (tree[cur].children.size() == 1)
						leaf++;
					continue;
				}
				stack.offerLast(next);
			}

			if (tree[cur].children.size() == 0) {
				leaf++;
			}

		}

		System.out.println(leaf);
	}
}

//트리긴 한데 서열 정리를 확실하게 해야 풀 수 있을 듯
// root기준으로 서열을 매기고 단방향으로 자식에서 부모로 간다
// 한놈 지울 때 그냥 DFS안넘어가게끔
