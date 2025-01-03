import java.util.*;

class Solution {
    public String solution(String s) {
        String[] temp = s.split(" ");
        int answer[] = new int[temp.length];
        for(int i=0; i < temp.length; i++){
            answer[i] = Integer.parseInt(temp[i]);
        }
        
        Arrays.sort(answer);
        
        return answer[0] + " " + answer[answer.length-1];
    }
}