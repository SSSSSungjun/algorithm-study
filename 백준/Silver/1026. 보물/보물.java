import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static int N;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        N=sc.nextInt();
        PriorityQueue<Integer> A=new PriorityQueue<>();
        PriorityQueue<Integer> B=new PriorityQueue<>();
        int result=0;
        for(int i=0;i<N;i++){
            A.offer(sc.nextInt());
        }

        for(int i=0;i<N;i++){
            B.offer(-sc.nextInt());
        }

        for(int i=0;i<N;i++){
            result+=(A.poll()*(-B.poll()));
        }
        System.out.println(result);
    }
}