import java.util.*;

class Solution {
    
    private static int[] winCnt;
    private static int[] loseCnt;
    private static ArrayList<ArrayList<Integer>> win;
    private static ArrayList<ArrayList<Integer>> lose;
    
    
    public int solution(int n, int[][] results) {
        
        winCnt=new int[n+1];
        loseCnt=new int[n+1];
        
        win=new ArrayList<>();
        lose=new ArrayList<>();
        
        for(int i=0;i<n+1;i++)win.add(new ArrayList<>());
        for(int i=0;i<n+1;i++)lose.add(new ArrayList<>());
        
        for(int[] v : results){
            win.get(v[0]).add(v[1]);
            lose.get(v[1]).add(v[0]);
        } //진놈들 나열하기
        
        int answer = 0;
        
        for(int i=1;i<n+1;i++){
            boolean[] visitedW=new boolean[n+1];
            boolean[] visitedL=new boolean[n+1];
            
            ArrayDeque<Integer> stackW= new ArrayDeque<>();
            ArrayDeque<Integer> stackL= new ArrayDeque<>();
            
            stackW.offerLast(i);
            stackL.offerLast(i);
            visitedW[i]=true;
            visitedL[i]=true;
            
            while(!stackW.isEmpty()){
                int cur=stackW.pollLast();
                
                for(int next : win.get(cur)){
                    
                    if(visitedW[next])continue;
                    
                    visitedW[next]=true;
                    stackW.offerLast(next);
                    winCnt[i]++;
      
                }
            }
            
            while(!stackL.isEmpty()){
                int cur=stackL.pollLast();
                
                for(int next : lose.get(cur)){
                    
                    if(visitedL[next])continue;
                    
                    visitedL[next]=true;
                    stackL.offerLast(next);
                    loseCnt[i]++;
      
                }
            }
        }
        
        for(int i=1;i<n+1;i++){
            System.out.println(winCnt[i]+" "+loseCnt[i]);
            if(winCnt[i]+loseCnt[i]==n-1)answer++;
        }
        
        return answer;
    }
}