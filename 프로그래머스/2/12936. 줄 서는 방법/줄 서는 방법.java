import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        for(int i=1; i <= n; i++){
            list.add(i);
        }
        
        k--;
        
        int index=0;
        while(n > 0){
            long factorial = 1;
            for(int i=1; i< n; i++){
                factorial *= i;
            }
            
            int pos = (int)(k / factorial);
            k = k % factorial;
            
            answer[index++] = list.get(pos);
            list.remove(pos);
            
            n--;
        }
        
        
        
        return answer;
    }
    
    
}