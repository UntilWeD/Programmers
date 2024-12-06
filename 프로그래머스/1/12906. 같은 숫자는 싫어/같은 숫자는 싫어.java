import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int temp = 0;
        List<Integer> intArray = new ArrayList<>();
        
        intArray.add(arr[0]);
        for(int i=0; i< arr.length; i++){
            if(arr[i] == intArray.get(temp)){
                continue;
            }
            intArray.add(arr[i]);
            temp++;
        }
        
        int[] answer = new int[intArray.size()];
        
        for(int i=0; i< intArray.size(); i++){
            answer[i] = intArray.get(i);
        }
    
        return answer;
    }
}