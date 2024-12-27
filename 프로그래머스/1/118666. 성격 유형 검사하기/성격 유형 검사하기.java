import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        h1.put('R',0);
        h1.put('T',0);
        h1.put('C',0);
        h1.put('F',0);
        h1.put('J',0);
        h1.put('M',0);
        h1.put('A',0);
        h1.put('N',0);
        char[][] all = {{'R', 'T'}, {'C','F'}, {'J', 'M'}, {'A', 'N'}};
        
        // choices[i] - 1
        int[] score = {-3, -2, -1, 0, 1, 2, 3};
        
        
        for(int i=0; i < choices.length; i++){
            int temp = score[choices[i] -1];
            if(temp < 0){
                h1.put(survey[i].charAt(0), h1.get(survey[i].charAt(0))+(temp*-1));
            } else if(temp > 0){
                h1.put(survey[i].charAt(1), h1.get(survey[i].charAt(1))+temp);
            }
        }
        
        String answer = "";
        for(int i=0; i<all.length; i++){
            if(h1.get(all[i][0]) > h1.get(all[i][1])){
                answer += all[i][0];
            } else if(h1.get(all[i][0]) < h1.get(all[i][1])){
                answer += all[i][1];
            } else {
                answer += (all[i][0] > all[i][1] ) ? all[i][1] : all[i][0];
            }
        }
        
    
        return answer;
    }
}