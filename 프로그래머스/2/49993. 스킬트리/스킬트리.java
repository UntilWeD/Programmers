import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = skill.toCharArray();
        
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i), i);
        }
        
        for(int i=0; i<skill_trees.length; i++){
            int index = 0;
            for(int j=0; j<skill_trees[i].length(); j++){
                char ch = skill_trees[i].charAt(j);
                if(map.containsKey(ch)){
                    if(ch != chars[index]){
                        answer--;
                        break;
                    }
                    index++;
                }
            }
            answer++;
        }
        
        return answer;
    }
}