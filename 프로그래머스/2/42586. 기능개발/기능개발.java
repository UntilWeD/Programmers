import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            int sum = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            que.offer(sum);
        }
        

        List<Integer> list = new ArrayList<>();
        
        while(!que.isEmpty()){
            System.out.println(que);
            int cur = que.peek();
            int count = 0;
            
            while(!que.isEmpty()){
                if(cur >= que.peek()){
                    que.poll();
                    count++;
                } else{
                    cur = que.peek();
                    break;
                }
            }
            list.add(count);
            
        }
        
        
        int[] answer = new int[list.size()];
        for(int i=0; i< answer.length; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}