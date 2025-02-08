import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> auxBelt = new Stack<>();
        
        int index = 0;
        for(int i=1; i<=order.length; i++){
            if(i == order[index]){
                index++;
                answer++;
            } else{
                auxBelt.push(i);
            }
            if(!auxBelt.isEmpty() && auxBelt.peek() == order[index]){
                while(!auxBelt.isEmpty() && auxBelt.peek() == order[index]){
                    auxBelt.pop();
                    index++;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}