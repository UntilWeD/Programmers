import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index = 27;
        
        // 1. 사전 초기화
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) ('A' + i)), i + 1);
        }
        
        
        for(int i=0; i< msg.length(); i++){
            String str = msg.charAt(i) + "";
            int j = 1;
            
            while( i + j < msg.length() && map.containsKey(str + msg.charAt(i + j))){
                str += msg.charAt(i+j);
                    j++;
            }
            
            list.add(map.get(str));
            
            if (i + j < msg.length()) {
                map.put(str + msg.charAt(i + j), index++);
            }

            i += j - 1;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}