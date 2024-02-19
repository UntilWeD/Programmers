import java.util.*;

class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String snum = Integer.toString(num);
        
        for(int i=0; i< snum.length(); i++){
            if(snum.charAt(i) -'0' == k){
                answer = i+1;
                break;
            }
        }
        
        
        return answer;
    }
}