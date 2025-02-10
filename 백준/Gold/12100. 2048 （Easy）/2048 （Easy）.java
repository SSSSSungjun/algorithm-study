import java.util.*;

public class Main {
    public static int max_value=-1;
    public static int[][] arr;
    public static int[][] Select_direction_v(int value, int[][] board){
        int st=(value<3)?0:board.length-1;
        int end=(value<3)?board.length:-1;
        int op=(value<3)?1:-1;

        for(int i=st;i!=end;i+=op){
            Queue<Integer> q=new LinkedList<>();
            int pre=-1;
            for(int k=st;k!=end;k+=op){
                if(board[k][i]==0)continue;
                if(pre==board[k][i]){
                    q.offer(pre*2);
                    max_value=Math.max(max_value,pre*2);
                    pre=-1;
                }else{
                    if(pre>0)q.offer(pre);
                    pre=board[k][i];
                }
            }
            if(pre>0)q.offer(pre);

            for(int k=st;k!=end;k+=op){
                board[k][i]=(!q.isEmpty())?q.poll():0;
            }
        }
        return board;
    }

    public static int[][] Select_direction_h(int value, int[][] board){
        int st=(value<2)?0:board.length-1;
        int end=(value<2)?board.length:-1;
        int op=(value<2)?1:-1;

        for(int i=st;i!=end;i+=op){
            Queue<Integer> q=new LinkedList<>();
            int pre=-1;
            for(int k=st;k!=end;k+=op){
                if(board[i][k]==0)continue;
                if(pre==board[i][k]){
                    q.offer(pre*2);
                    max_value=Math.max(max_value,pre*2);
                    pre=-1;
                }else{
                    if(pre>0)q.offer(pre);
                    pre=board[i][k];
                }
            }
            if(pre>0)q.offer(pre);

            for(int k=st;k!=end;k+=op){
                board[i][k]=(!q.isEmpty())?q.poll():0;
            }
            //System.out.println(Arrays.toString(board[i]));
        }
        return board;
    }

    public static void Search_Case(int idx,int[]_case){

        if(idx>=_case.length){
            int [][] board=new int[arr.length][arr.length];
            for(int i=0;i< arr.length;i++)
                board[i]=arr[i].clone();

            for(int v:_case) {
                if ((v % 2 == 1))board=Select_direction_h(v, board);
                else board=Select_direction_v(v, board);
            }
            return;
        }


        for(int i=0;i<4;i++){
            _case[idx]=i+1;
            Search_Case(idx+1,_case);
            _case[idx]=0;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        arr=new int[N][N];
        int[] _case= new int[5];
        for(int i=0;i<N;i++)for(int k=0;k<N;k++){
            arr[i][k]= sc.nextInt();
            if(arr[i][k]>max_value)max_value=arr[i][k];
        }

        Search_Case(0,_case);
        System.out.println(max_value);
    }
}
