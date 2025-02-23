import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            int n=sc.nextInt();

            if(n==0){
                System.out.println((pq.isEmpty())?0:-pq.poll());
            }else{
                pq.offer(-n);
            }
        }
    }
}