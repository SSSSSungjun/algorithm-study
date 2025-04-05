import java.util.*;
class Booktime{
    int startTime;
    int endTime; //청소 시간 포함
    
    Booktime(String st, String end){
        startTime=Integer.parseInt(st.replace(":",""));
        endTime=Integer.parseInt(end.replace(":",""));
        endTime=(endTime%100>=50)?endTime+50 : endTime+10;
      
    }
}

class Solution {
 
    public int solution(String[][] book_time) {
        
        PriorityQueue<Booktime> pqTime= new PriorityQueue<Booktime>( (a, b)->{
            int result=a.startTime-b.startTime;
            if(result==0)result=a.endTime-b.endTime;
            return result;
        });
        
        PriorityQueue<Integer> pqEnd = new PriorityQueue<>();
        
        for(int i=0;i<book_time.length;i++){
            Booktime booktime = new Booktime(book_time[i][0],book_time[i][1]);
            pqTime.offer(booktime);
            pqEnd.offer(booktime.endTime);
        }
        
        int roomCnt=0;
        while(!pqTime.isEmpty()){
            Booktime bk=pqTime.poll();
            
            if(bk.startTime<pqEnd.peek()){
                roomCnt++;
            }else{
                pqEnd.poll();
            }
        }
      
        return roomCnt;
    }
}