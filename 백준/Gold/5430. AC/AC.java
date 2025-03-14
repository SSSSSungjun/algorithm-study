
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T=nextInt(br.readLine());

        for(int t=1;t<=T;t++){
            String inst=br.readLine();
            int N=nextInt(br.readLine());

            ArrayDeque<Integer> deque= new ArrayDeque<>();

            StringBuilder inputString = new StringBuilder(br.readLine());
            inputString.deleteCharAt(0);
            inputString.deleteCharAt(inputString.length() - 1);

            String inputArr =inputString.toString();
            //1부터시작해서 길이 전까지 끝내는.


            int arr[] = new int[N];
            if(N>1)
                arr= Arrays.stream(inputArr.split(",")).mapToInt(Integer::parseInt).toArray();
            else if(N==1)
                arr[0]=nextInt(inputArr);

            for(int i : arr){
                deque.offerLast(i);
            }


            //여기서부터는 명령어에 따라 처리
            boolean isLeft=true; //1번 deque쓸지 2번쓸지 정한다.
            boolean error=false; //에러뜨면 바로 나가게.
            for(int i=0;i<inst.length();i++){

                if(inst.charAt(i)=='R'){
                   isLeft=!isLeft;
                }

                if(inst.charAt(i)=='D'){
                    if(deque.isEmpty()){
                        error=true;
                        break;
                    }
                    if(isLeft){
                        deque.pollFirst();
                    }else{
                        deque.pollLast();
                    }

                }
            }//명령어에 따른 처리 코드

            if(error){
                System.out.println("error");
                continue;
            }

            StringBuilder sb =new StringBuilder();
            sb.append('[');
            if(isLeft){
                while(!deque.isEmpty()){
                    sb.append(deque.pollFirst());
                    sb.append((deque.size()!=0) ? "," : "");
                }
            }else{
                while(!deque.isEmpty()){
                    sb.append(deque.pollLast());
                    sb.append((deque.size()!=0) ? "," : "");
                }
            }
            sb.append("]");

            System.out.println(sb);
        }
    }

    public static int nextInt(String value){
        return Integer.parseInt(value);
    }
}
