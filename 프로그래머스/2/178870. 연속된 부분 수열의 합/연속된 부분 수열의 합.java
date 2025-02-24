import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {   
        HashMap<Integer, int[]> map = new HashMap<>();
        int min = 1000000;

        int sum = 0;
        int i=0, j=0;
        
        while(j < sequence.length){
            if(sum < k){
                sum += sequence[j++];
            } else if (sum > k){
                sum -= sequence[i++];
            }
            
            if(sum == k){
                int[] temp = {i, j-1};
                if(!map.containsKey(j-i)){
                    map.put(j-i, temp);
                    min = Math.min(min, j-i);
                }
                if(j < sequence.length) {
                    sum += sequence[j++];
                }
            }
        }
        
        while(i < sequence.length && sum > k){
            sum -= sequence[i++];
            if(sum == k){
                int[] temp = {i, j-1};
                if(!map.containsKey(j-i)){
                    map.put(j-i, temp);
                    min = Math.min(min, j-i);
                }
            }
        }

        return map.get(min);
    }
}