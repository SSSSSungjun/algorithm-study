import java.util.*;

public class Main {
    public static int[] dx={0,1,0,-1};
    public static int[] dy={1,0,-1,0};
    public static int max_value=1;
    public static char[][] alpha;
    public static int R,C;
    public static int alpha_set_size=0;

    public static void DFS(int x,int y,int[] alpha_set){

        for(int d=0;d<4;d++){
            int nx=x+dx[d], ny=y+dy[d];

            if(nx<0 || ny<0 || nx>=R || ny>=C)continue;
            if(alpha_set[(int)alpha[nx][ny]-65]!=0)continue;

            alpha_set[(int)alpha[nx][ny]-65]++;
            alpha_set_size++;
            max_value=Math.max(alpha_set_size, max_value);
            DFS(nx,ny,alpha_set);
            alpha_set_size--;
            alpha_set[(int)alpha[nx][ny]-65]--;


        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        R=sc.nextInt();
        C= sc.nextInt();
        alpha= new char[R][C];
        for(int i=0;i<R;i++){
            alpha[i]=sc.next().toCharArray();
        }

        int alpha_set[]=new int[26];
        alpha_set[(int)alpha[0][0]-65]++;
        alpha_set_size++;

        DFS(0,0,alpha_set);
        System.out.println(max_value);



    }
}