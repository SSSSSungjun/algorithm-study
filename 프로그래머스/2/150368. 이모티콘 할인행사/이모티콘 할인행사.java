import java.util.*;

class Solution {
    
    public static final int[] saleRatio={10,20,30,40};
    public static int[][] kusers;
    public static int[] kemoticons;
    
    public static int emo_len=0;
    public static int max_membership=0;
    public static int max_profit=0;
    
    public int[] solution(int[][] users, int[] emoticons) {
         
        kusers=new int[users.length][2];
        kemoticons=new int[emoticons.length];
        
        for(int i=0;i<users.length;i++){
            kusers[i]=new int[]{users[i][0],users[i][1]};
        }
        for(int i=0;i<emoticons.length;i++){
            kemoticons[i]=emoticons[i];
        }
        
        
        emo_len=emoticons.length;    
        permutation_R(0,new int[emo_len]);
        
        
        return new int[]{max_membership,max_profit};
    }
    
    
    
    public static void permutation_R(int idx,int[] _case){
            
        if(idx==emo_len){
            promotion(_case);
            return;
        }
        
        
        for(int i=0;i<4;i++){
            _case[idx]=saleRatio[i];
            permutation_R(idx+1,_case);
        }
    }
    
    public static void promotion(int[] _case){
        int[] saleEmo=new int[_case.length];
        
        int profit=0;
        int membership=0;
        
        for(int i=0;i<kusers.length;i++){
            
            int userProfit=0;
            
            for(int k=0;k<_case.length;k++){
                if(_case[k]>=kusers[i][0]){
                    userProfit+=kemoticons[k]*(100-_case[k])/100;
                }
            }   
            
            if(userProfit>=kusers[i][1]){
                membership++;
            }else{
                profit+=userProfit;
            }
        
        }
        
        if(membership>max_membership){
            max_membership=membership;
            max_profit=profit;
        }else if (membership==max_membership){
            max_profit=Math.max(profit,max_profit);
        }
        
          
    }
    
    
}