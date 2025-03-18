
import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] parents;

    static int find(int n) {
        if(parents[n]==n)return n;

        return parents[n]=find(parents[n]);
    }

    static void Union(int a, int b) {
        int findA=find(a);
        int findB=find(b);

        if(findA>findB) {
            parents[findA]=findB;
        }else {
            parents[findB]=findA;
        }

    }

    static boolean isUnion(int a, int b) {
        return parents[a]==parents[b];
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] nm=br.readLine().split(" ");
        N=Integer.parseInt(nm[0]); // 사람 수
        M=Integer.parseInt(nm[1]); // 파티 수
        parents=new int[N+1];

        for(int i=0;i<N+1;i++)parents[i]=i;

        int[] known= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //거짓말 데이터.

        for(int i=2;i<known.length;i++){
            Union(known[i-1],known[i]);
        } //진실을 아는 자

        int[][] party=new int[M][];

        for(int i=0;i<M;i++){
            party[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(party.length!=2){
                for(int k=2;k<party[i].length;k++){
                    Union(party[i][k-1],party[i][k]);
                }
            }

        } //파티참여자 전부다 유니온

        for(int i=1;i<N+1;i++)find(i); //파인드갱신


        int result=0;
        if(known.length==1)result=M;
        else{
            for(int i=0;i<M;i++){
                if(!isUnion(known[1],party[i][1])) result++;
            }
        }
        //System.out.println(Arrays.toString(parents));
        System.out.println(result);

    }

}

