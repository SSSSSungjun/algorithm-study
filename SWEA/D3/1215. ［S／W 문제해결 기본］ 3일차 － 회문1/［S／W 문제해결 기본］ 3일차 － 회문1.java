import java.util.*;

public class Solution {
    public static int reverse_same(char[][] arr,int n,int a,int b){
        int v1=1,v2=1;
        for(int i=0;i<n/2;i++){
            if(arr[a][b+i]!=arr[a][(b+n-1)-i])v1=0;
            if(arr[b+i][a]!=arr[(b+n-1)-i][a])v2=0;
        }
        return v1+v2;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        for(int tc=0;tc<10;tc++){
            char[][] arr=new char[8][8];
            int N=sc.nextInt();
            int result=0;
            for(int i=0;i<8;i++)arr[i]=sc.next().toCharArray();
            for(int i=0;i<8;i++) {
                for (int k = 0; k <= 8 - N; k++) {
                    result+=reverse_same(arr,N,i,k);
                }
            }
            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
