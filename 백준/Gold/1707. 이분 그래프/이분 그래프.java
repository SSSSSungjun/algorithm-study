
import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> field;
    static int[] color; // 0: 방문 안 함, 1: 그룹 A, -1: 그룹 B
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            field = new ArrayList<>();
            for (int i = 0; i <= V; i++) 
                field.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                field.get(u).add(v);
                field.get(v).add(u);
            }

            color = new int[V + 1]; // 방문하지 않음(0)으로 초기화
            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (color[i] == 0) { // 방문하지 않은 노드에서 시작
                    if (!bfs(i)) {
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // 첫 번째 그룹(1)

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : field.get(node)) {
                if (color[neighbor] == 0) { // 방문하지 않은 경우
                    color[neighbor] = -color[node]; // 반대 그룹으로 배정
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) { 
                    // 이미 방문한 노드가 현재 노드와 같은 그룹이라면 이분 그래프가 아님
                    return false;
                }
            }
        }
        return true;
    }
}
