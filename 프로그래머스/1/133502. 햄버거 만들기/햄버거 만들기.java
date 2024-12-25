import java.util.*;

class Solution {
    // 1 = 빵, 2 = 야채, 3 = 고기
    public int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<ingredient.length; i++){
            sb.append(ingredient[i]);

            if(sb.length() >= 4 && sb.substring(sb.length()-4).equals("1231")){
                sb.delete(sb.length()-4, sb.length());
                answer++;
            }
        }
    
        
        
        
        return answer;
    }
}