import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('E', 1);
        map.put('I', 2);
        map.put('O', 3);
        map.put('U', 4);
        
        for(int i = 0; i < word.length(); i++){
            int num = map.get(word.charAt(i));
            answer += (num == 0 ) ? 1 : num * calculate(i) + 1;
        }
        
         
        return answer;
    }
    
    public int calculate(int index){
        int sum = 0;
        // 최대 5 - i 만큼 5의 거듭제곱 계산
        for(int i = 0; i< 5 - index; i++){
            sum += Math.pow(5, i);
        }
        return sum;
    }
}