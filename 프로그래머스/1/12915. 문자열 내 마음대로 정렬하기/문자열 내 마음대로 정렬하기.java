import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        
        for(int i=0; i<strings.length; i++){
            answer[i] = strings[i].charAt(n) + "";
        }
        
        Arrays.sort(answer);
        for(int i=0; i<strings.length; i++){
            for(int j=0; j<answer.length; j++){
                if(strings[i].charAt(n) == answer[j].charAt(0)){
                    if(answer[j].length() > 1)
                        continue;
                    answer[j] = strings[i];
                    break;
                }
            }
        }

        
        return answer;
    }
}