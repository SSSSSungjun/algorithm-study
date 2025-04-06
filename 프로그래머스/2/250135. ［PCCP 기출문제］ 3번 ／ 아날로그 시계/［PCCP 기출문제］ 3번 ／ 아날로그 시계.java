class Solution {
    
    public static final int MOVES=720;
    public static final int MOVEM=12;
    //public static final int MOVEH=1;
    public static final int BASE_MS=720;
    public static final int BASE_H=3600;
    public static final int MAX_V=720*60;
    
    
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        int answer=0;
        int startTime= h1*3600+m1*60+s1;
        int endTime= h2*3600+m2*60+s2;
        
        int angleS=s1*BASE_MS;
        int angleM=m1*BASE_MS+MOVEM*s1;
        int angleH=h1*BASE_H+m1*60+s1;
        
        int prevS=angleS-MOVES;
        int prevM=angleM-MOVEM;
        int prevH=angleH-1;
        
     
        for(int i=startTime;i<=endTime;i++){
            
           if(i<=startTime+3)
                System.out.println(angleH+" "+angleM+" "+angleS);
            
            if(prevS<prevM && angleS>=angleM)answer++;
            if(prevS<prevH && angleS>=angleH)answer++;
            
            if(i==startTime && prevS<prevM && angleS>angleM)answer--;
            if(i==startTime && prevS<prevH && angleS>angleH)answer--;
            
            if(angleS == angleH && angleH == angleM) answer--;
            
            
            if(angleS>=MAX_V)angleS%=MAX_V;
            if(angleM>=MAX_V)angleM%=MAX_V;
            if(angleH>=MAX_V)angleH%=MAX_V;
            
            prevS=angleS;
            prevM=angleM;
            prevH=angleH;
            
            angleS+=MOVES;
            angleM+=MOVEM;
            angleH+=1;
           
        }
  
        
       
        return answer;
    }
}
