import java.util.*;
class Value{
    long value;
    int junk;
    Value(long value,int junk){
        this.value=value;
        this.junk=junk;
    }
}//의도적으로 중복을 허용하려고 함

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        TreeSet<Value> tree;

        int T=sc.nextInt();

        for(int t=0;t<T;t++){
            int N=sc.nextInt();
            tree=new TreeSet<>((a,b)->{
                int result=Long.compare(a.value,b.value);
                if(result==0) result=Integer.compare(a.junk,b.junk);
                return result;
            }); //compare도 확실하게 정의 해야 의도적으로 중복 값 받음

            for(int i=0;i<N;i++){
                char C=sc.next().charAt(0);
                long V=sc.nextInt();

                if(C=='I') tree.add(new Value(V,i));

                if(C=='D' && !tree.isEmpty()){

                    if(V==-1)tree.pollFirst();
                    if(V==1)tree.pollLast();
                }
            }

            System.out.println((tree.isEmpty())? "EMPTY" : tree.last().value+" "+tree.first().value);
        }
    }
}
