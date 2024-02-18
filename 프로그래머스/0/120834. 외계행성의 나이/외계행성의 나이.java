import java.util.*;

class Solution {
    public String solution(int age) {
        String answer = "";

        String Stemp = "";
        
        Stemp = Integer.toString(age);
        
        for(int i=0; i < Stemp.length(); i++){
            answer += (char)(Stemp.charAt(i)-'0'+97);
        }
        
            

        
        return answer;
    }
}