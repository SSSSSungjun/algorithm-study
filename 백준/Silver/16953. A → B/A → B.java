import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int A=sc.nextInt(), B=sc.nextInt();

        int cnt=1;
        while(B!=A && B>1){
            B=(B%10==1)?B/10 :(B%2==0)? B/2 : -1;
            cnt++;
        }
        System.out.println((B==A)?cnt:-1);
    }
}