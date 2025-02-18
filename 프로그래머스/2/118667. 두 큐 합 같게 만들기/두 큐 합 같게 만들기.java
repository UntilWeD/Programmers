import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        
        // 큐 초기화
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        for(int i=0; i <queue1.length; i++){
            que1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i=0; i <queue2.length; i++){
            que2.offer(queue2[i]);
            sum2 += queue2[i];
        }
        
        long total = (sum1 + sum2) / 2;
        while(sum1 != total && sum2 != total){
            if(sum1 < sum2){
                int num = que2.poll();
                que1.offer(num);
                sum1 += num;
                sum2 -= num;
            }else{
                int num = que1.poll();
                que2.offer(num);
                sum1 -= num;
                sum2 += num;
            }
            answer++;
            if(answer > queue1.length*3)
                return -1;
        }
        
        
        return answer;
    }

}