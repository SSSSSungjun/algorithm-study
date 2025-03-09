import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int N=sc.nextInt();
        int[] numArr= new int[N+1];

        TreeSet<Integer> cycle =new TreeSet<>();

        for(int i=1;i<=N;i++){
            numArr[i]= sc.nextInt();
        }

        for(int i=1;i<=N;i++){
            ArrayDeque<Integer> stack=new ArrayDeque<>();
            stack.offerLast(i);

            TreeSet<Integer> visited=new TreeSet<>();
            visited.add(i);

            int lastValue=0;
            while(!stack.isEmpty()){
                int next=numArr[stack.pollLast()];

                lastValue=next;

                if(visited.contains(next))continue;

                visited.add(next);
                stack.offerLast(next);
            }

            if(lastValue==i){
                while(!visited.isEmpty()){
                    cycle.add(visited.pollFirst());
                }
            }

        }

        System.out.println(cycle.size());
        while(!cycle.isEmpty()){
            System.out.println(cycle.pollFirst());
        }


    }
}
