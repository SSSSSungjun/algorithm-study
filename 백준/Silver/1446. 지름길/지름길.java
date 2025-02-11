
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        int N=sc.nextInt(), D=sc.nextInt();

        int[] path=new int[D+1];
        Arrays.fill(path,10001);

        List<ArrayList<int[]>> list=new ArrayList<>();
        for(int i=0;i<D+1;i++) list.add(new ArrayList<>());


        for(int i=0;i<N;i++){
            int st=sc.nextInt(),end=sc.nextInt(),s_cut=sc.nextInt();
            if(end>D)continue;
            list.get(st).add(new int[]{end,s_cut});
        }
        path[0]=0;
        for(int i=0;i<=D;i++){
            if(i!=0)path[i]=Math.min(path[i-1]+1,path[i]);
            if(list.get(i).size()!=0){
                for(int[] k : list.get(i)){
                    path[k[0]]=Math.min(path[k[0]],path[i]+k[1]);
                }
            }
        }
        System.out.println(path[D]);
    }
}
