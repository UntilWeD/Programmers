import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i< tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());

        // Collections.sort()를 사용하여 내림차순 정렬
        Collections.sort(list, Collections.reverseOrder());
        
        while(k > 0){
            k -= list.get(0);
            list.remove(0);
            answer++;
        }
        
        
        
        
        
        return answer;
    }
}