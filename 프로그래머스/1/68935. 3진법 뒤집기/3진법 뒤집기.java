import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String sum = "";
        while(true){
            sum += (n % 3) + "";
            if(n/3 == 0){
                break;
            }
            n = n/3;
        }
        System.out.println(sum);
        
        for(int i= sum.length() -1; 0 <= i ; i--){
            answer +=  Math.pow(3, (sum.length() - 1 - i)) * ((int)sum.charAt(i) - '0');
        }
        
        return answer;
    }
}