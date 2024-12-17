import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> temple = new LinkedList<>();
        
        for(int i=0; i < score.length; i++){
            temple.add(score[i]);
            Collections.sort(temple);
            
            if(temple.size() == k+1)
                temple.remove(0);

            answer[i] = temple.get(0);
        }
        
        
        return answer;
    }
}