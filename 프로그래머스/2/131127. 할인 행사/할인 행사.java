import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i=0; i<=discount.length-10; i++){
            Map<String, Integer> tempMap = new HashMap<>();
            
            for(int j=i; j<i+10; j++){
                tempMap.put(discount[j], tempMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean canBuy = true;
            for(String item : want){
                if(tempMap.getOrDefault(item, 0) != wantMap.get(item)){
                    canBuy = false;
                    break;
                }
            }
            
            if(canBuy){
                answer++;
            }
        }
        
        return answer;
    }
}