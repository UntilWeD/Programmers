import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";

        for(int i=0; i< my_string.length(); i++){
            if(answer.indexOf(my_string.charAt(i)) < 0){
                answer += my_string.charAt(i);
            }
        }
        
        return answer;
    }
}