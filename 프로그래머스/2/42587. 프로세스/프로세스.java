import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            que.offer(priorities[i]);
        }
        
        System.out.println(que.toString());
        
        while(!que.isEmpty()){
            int max = 0;
            for(int num : que){
                max = Math.max(max, num);
            }
            
            if(max > que.peek()){
                que.add(que.poll());
            } else{
                answer++;
                if(location == 0){
                    return answer;
                } else{
                    que.poll();
                }
                
            }
            
            if(location == 0){
                location = que.size()-1;
            } else{
                location--;
            }
            
        }
        
        
        
        
        return answer;
    }
}