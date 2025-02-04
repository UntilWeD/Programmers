import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        while(pq.size() > 1 && pq.peek() < K){
            int sum = 0;
            sum += pq.poll() + pq.poll()*2;
            pq.offer(sum);
            answer++;
        }
        
        if(pq.peek() < K)
            return -1;
        
        return answer;
    }
}