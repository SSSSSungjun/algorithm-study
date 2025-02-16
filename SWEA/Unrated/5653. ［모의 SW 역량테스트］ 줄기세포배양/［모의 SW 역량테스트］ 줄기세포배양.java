import java.util.*;
import java.awt.*;
public class Solution {

    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int TC=sc.nextInt();

        for(int tc=1;tc<=TC;tc++){
            Set<Point> _set=new HashSet<>();
            PriorityQueue<int[]> active_q=new PriorityQueue<>((a, b) -> a[0] - b[0]);
            Queue<int[]> inactive_q=new LinkedList<>();
            int N=sc.nextInt(),M=sc.nextInt(),K=sc.nextInt();
            //비활,시간,좌표 ,좌표y
            for(int n=0;n<N;n++) {
                for (int m = 0; m < M; m++) {
                    int value = sc.nextInt();
                    if (value != 0) {
                        inactive_q.offer(new int[]{value, value, n, m});
                        _set.add(new Point(n, m));
                    }
                }
            }

            for(int asd=0;asd<=K;asd++){
                //10번 돌린다.
                Queue<int[]> temp_q=new LinkedList<>();
                int active_q_size=active_q.size();
                for(int i=0;i<active_q_size;i++){

                    int[] pop_value=active_q.poll();
                    if(pop_value[1]!=1)
                        temp_q.offer(new int[]{pop_value[0],pop_value[1]-1,pop_value[2],pop_value[3]});
                    //System.out.println(Arrays.toString(pop_value));
                    for(int d=0;d<4;d++){
                        int n_x=pop_value[2]+dx[d],n_y=pop_value[3]+dy[d];
                        if(_set.contains(new Point(n_x,n_y)))continue;
                        _set.add(new Point(n_x,n_y));
                        inactive_q.offer(new int[]{-pop_value[0],-pop_value[0],n_x,n_y});
                    }

                }
                while(!temp_q.isEmpty())active_q.offer(temp_q.poll());

                int inactive_q_size=inactive_q.size();
                for(int i=0;i<inactive_q_size;i++){
                    int[] pop_value=inactive_q.poll();
                    if(pop_value[1]==0){
                        pop_value[1]=pop_value[0];
                        pop_value[0]= -pop_value[0];
                        active_q.offer(pop_value);
                    }
                    else {
                        pop_value[1]--;
                        inactive_q.offer(pop_value);
                    }
                }

                //System.out.println(asd );
                //System.out.println("@@"+asd+" "+inactive_q.size()+" "+active_q.size());
                //time
            }

            System.out.println("#"+tc+" "+(inactive_q.size()+active_q.size()));


        }



    }
}
