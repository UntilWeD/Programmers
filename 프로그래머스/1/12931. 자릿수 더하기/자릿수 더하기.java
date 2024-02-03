import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<10; ++i){
            answer += n % Math.pow(10, i) / Math.pow(10, i-1);
            
            if(n % Math.pow(10, i-1) == n){
                break;
            }
            
        }

        

        return answer;
    }
}