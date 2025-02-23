import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N= sc.nextInt(),M=sc.nextInt(),K=sc.nextInt(),X=sc.nextInt();

        boolean[] visited=new boolean[N+1];

        ArrayList<ArrayList<Integer>> arr= new ArrayList<>();
        for(int i=0;i<N+1;i++)arr.add(new ArrayList<>());

        ArrayDeque<int[]> deque= new ArrayDeque<>();

        PriorityQueue<Integer> output_pq=new PriorityQueue<>();

        for(int i=0;i<M;i++){
            arr.get(sc.nextInt()).add(sc.nextInt());
        }

        visited[X]=true;
        deque.offerLast(new int[]{X,0});
        while(!deque.isEmpty()){
            int pop_value[]=deque.pollFirst();

            if(pop_value[1]>K)break;
            if(pop_value[1]==K)output_pq.offer(pop_value[0]);

            for(int v: arr.get(pop_value[0])){
                if(visited[v])continue;

                visited[v]=true;
                deque.offerLast(new int[]{v,pop_value[1]+1});
            }

        }
        if(output_pq.isEmpty())output_pq.offer(-1);
        while(!output_pq.isEmpty()) System.out.println(output_pq.poll());



    }
}