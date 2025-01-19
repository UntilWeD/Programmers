import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left+1)];
        
        // left, right의 좌표 = (left/n, left%n), (right/n, right%n), 
        for(int i=0; i < answer.length; i++){
            answer[i] = (int)Math.max(left/n, left%n)+1;
            left++;
        }
        
        return answer;
    }
}