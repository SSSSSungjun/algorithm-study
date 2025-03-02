import java.util.*;

class ResultString{
    int modular;
    String rs;

    ResultString(int modular, String rs){
        this.modular=modular;
        this.rs=rs;
    }
}
public class Main {

    private static String 구사과가_좋아하는_수(int N){
        boolean visited[]=new boolean[20001];

        ArrayDeque<ResultString> queue=new ArrayDeque<>();
        queue.offerLast(new ResultString(1,"1"));
        visited[1%N]=true;
        int[] next_mod=new int[2];

        while(!queue.isEmpty()){
            ResultString cur=queue.pollFirst();
            int cur_mod=cur.modular;
            String cur_rs= cur.rs;

            for(int d=0;d<=1;d++){
                StringBuilder next_rs=new StringBuilder(cur_rs);
                next_mod[d]=(cur_mod*10+d)%N;
                next_rs.append((char)(d+'0'));

                if(next_mod[d]==0){
                    return next_rs.toString();
                }
                if(visited[next_mod[d]])continue;

                queue.offerLast(new ResultString(next_mod[d],next_rs.toString()));
                visited[next_mod[d]]=true;
            }
        }
        return "BRAK";

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int TC=sc.nextInt();

        for(int tc=0;tc<TC;tc++){
            System.out.println(구사과가_좋아하는_수(sc.nextInt()));
        }

    }
}