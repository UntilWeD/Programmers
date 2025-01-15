import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for(int i=1; i<words.length; i++){
            if(set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                // 탈락하는 사람의 번호
                answer[0] = (i+1) % n;
                answer[0] = answer[0] == 0 ? n : answer[0]; 
                // 자신의 몇번째에 탈락하는지
                answer[1] = (i+1)/n + ((i+1)%n != 0 ? 1 : 0);
                
                return answer;
            }
            set.add(words[i]);
        }

        
        return answer;
    }
}