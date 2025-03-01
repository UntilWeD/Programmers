import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i <weights.length; i++){
            map.put(weights[i], map.getOrDefault(weights[i], 0) + 1);
        }
        
        for(int weight : map.keySet()){

            int count = map.get(weight);
            if(count > 1){
                answer += (long) count * (count-1) / 2;
            }
            
            int[][] ratios = {{3, 2}, {4, 2}, {4, 3}};

            for (int[] ratio : ratios) {
                int numerator = ratio[0];
                int denominator = ratio[1];

                if (weight * numerator % denominator == 0) {
                    int pairWeight = weight * numerator / denominator;
                    if (map.containsKey(pairWeight)) {
                        answer += (long) count * map.get(pairWeight);
                    }
                }
            }
        }
        
        return answer;
    }
    
    

}