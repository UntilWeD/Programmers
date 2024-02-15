import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> intlist = new ArrayList<>();
        
        for(int i=1; i<=n; i++){
            if(n%i==0){
                intlist.add(i);
            }
        }
        
        int[] answer = new int[intlist.size()];
        for (int i = 0; i < intlist.size(); i++) {
            answer[i] = intlist.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}