import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int index = 0;
        int bridge_weight = 0;
        
        // 트럭이 들어간 시점 저장
        Queue<Integer> times = new LinkedList<>();
        // 현재 다리에 있는 트럭의 인덱스 저장
        Queue<Integer> weights = new LinkedList<>();
        
        while(index < truck_weights.length){
            answer++;
            // 다리에서 트럭이 얼마나 있었는지 체크
            if(!times.isEmpty() && times.peek() + bridge_length == answer){
                times.poll();
                bridge_weight -= weights.poll();
            }
            
            
            // 다리에 트럭 건너는 것 체크
            if(times.size() <= bridge_length && bridge_weight + truck_weights[index] <= weight){
                times.offer(answer);
                weights.offer(truck_weights[index]);
                bridge_weight += truck_weights[index];
                index++;
            }
        }
        
        while(!times.isEmpty()){
            answer++;
            if(!times.isEmpty() && times.peek() + bridge_length == answer){
                times.poll();
            }
        }
        
        return answer;
    }
}