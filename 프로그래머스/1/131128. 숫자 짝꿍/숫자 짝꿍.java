import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> xh = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> yh = new HashMap<Integer, Integer>();

        for(int i=0; i<X.length(); i++){
            int digit = X.charAt(i) - '0';
            xh.put(digit, xh.getOrDefault(digit, 0) + 1);
        }
        
        for(int i=0; i<Y.length(); i++){
            int digit = Y.charAt(i) - '0';
            yh.put(digit, yh.getOrDefault(digit, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();
        
        for(int i=9;  0 <= i; i--){
            if(xh.containsKey(i) && yh.containsKey(i)){
                int count = Math.min(xh.get(i), yh.get(i));
                for(int j=0; j<count; j++){
                    answer.append(i);
                }
            }
        }
        
        if(answer.length() == 0) return "-1";
        if(answer.charAt(0) == '0') return "0";
        
        
        return answer.toString();
    }
}