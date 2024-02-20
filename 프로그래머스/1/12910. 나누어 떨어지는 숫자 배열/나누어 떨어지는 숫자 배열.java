import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> intlist = new ArrayList<Integer>();
        
        
        for(int i=0; i< arr.length; i++){
            if(arr[i] % divisor == 0){
                intlist.add(arr[i]);
            }
        }
        
        if(intlist.size() == 0)
            return new int[]{-1};
        
        int[] answer = intlist.stream().mapToInt(i->i).toArray();


        Arrays.sort(answer);
        
        
        return answer;
    }
}