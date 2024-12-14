import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        
        Set<Integer> intHashSet = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                intHashSet.add(numbers[i]+numbers[j]);
            }
        }
        List<Integer> list = new ArrayList<>(intHashSet);
        Collections.sort(list);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}