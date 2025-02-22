import java.util.*;
import java.awt.*;

public class Main {

    private static char[][] 교실;
    private static final int 임도연파최대인원 =3;
    private static int result=0;

    private static final int[] dx={0,1,0,-1};
    private static final int[] dy={1,0,-1,0};

    public static void 조건맞는지_Search(int[] 칠공주후보){
        HashSet<Point> hashSet=new HashSet<>();
        boolean visited[] = new boolean[25];
        ArrayDeque<Point> deque= new ArrayDeque<>();

        int 임도연파=0;
        int 인접길이 =1;

        for(int v : 칠공주후보){
            int x좌표 = v/5;
            int y좌표 = v%5;

            hashSet.add(new Point(x좌표,y좌표));
            if(deque.size()==0) {
                deque.offerLast(new Point(x좌표,y좌표));
                visited[v]=true;
            }

            if(교실[x좌표][y좌표]=='Y')임도연파++;
        }

        if(임도연파>임도연파최대인원)return;

        while(!deque.isEmpty()){
            Point p=deque.pollFirst();
            int cur_x=p.x;
            int cur_y=p.y;

            for(int d=0;d<4;d++){
                int next_x=cur_x+dx[d];
                int next_y=cur_y+dy[d];

                if(next_y<0 || next_y>=5 || next_x<0 || next_x>=5)continue;
                if(visited[next_x*5+next_y])continue;

                if(hashSet.contains(new Point(next_x,next_y))){
                    deque.offerLast(new Point(next_x,next_y));
                    visited[next_x*5+next_y]=true;
                    인접길이++;
                }
            }
        }

        if(인접길이==7)result++;

    }

    public static void _25C7(int idx, int R,int[] 칠공주후보){

        if(idx>=7){
            조건맞는지_Search(칠공주후보);
            return;
        }

        for(int i=R;i<25;i++){
            칠공주후보[idx]=i;
            _25C7(idx+1,i+1,칠공주후보);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        교실 = new char[5][];

        for(int i=0;i<5;i++)교실[i]=sc.next().toCharArray();
        _25C7(0,0,new int[7]);
        System.out.println(result);
    }
}