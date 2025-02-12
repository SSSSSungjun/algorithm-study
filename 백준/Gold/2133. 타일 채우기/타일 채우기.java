import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int N=new Scanner(System.in).nextInt();
        int[] arr= new int[31];
        arr[2]=3;
        arr[4]=11;
        int sum=2;
        for(int i=6;i<=N;i+=2){
            arr[i]=arr[i-2]*4-arr[i-4];
        }

        System.out.println(arr[N]);
    }
}
