import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<=m*t; i++){
            sb.append(Integer.toString(i, n));
        }
        
        p -= 1;
        while(answer.length() != t){
            answer += sb.charAt(p);
            p += m;
        }
        
        answer = answer.toUpperCase();
        return answer;
    }
}