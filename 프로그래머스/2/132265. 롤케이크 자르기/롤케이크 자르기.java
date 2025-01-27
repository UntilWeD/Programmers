import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=topping.length-1; i >= 0; i--){
            // 만약 키가 존재하지 않는다면
            if(!map.containsKey(topping[i])){
                map.put(topping[i], i);
            }
        }
        
        for(int i=0; i < topping.length-1; i++){
            set.add(topping[i]);
            if(map.get(topping[i]) == i)
                map.remove(topping[i]);
            if(set.size() == map.keySet().size())
                answer++;
        }
        
        
        return answer;
    }
}