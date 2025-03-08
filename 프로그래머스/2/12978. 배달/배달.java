import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N+1];
        
        
        for(int i=1; i <= N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        distance[1] = 0;
        
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int currentVillage = current[0];
            int currentTime = current[1];
            
            // 이미 현재 시간이 기록된 시간보다 클 경우
            if(currentTime > distance[currentVillage]) continue;
            
            for(int i = 0; i < road.length; i++){
                int village1 = road[i][0];
                int village2 = road[i][1];
                int nextTime = currentTime + road[i][2];
                
                if(village1 == currentVillage){
                    if(nextTime < distance[village2] && nextTime <= K){
                        distance[village2] = nextTime;
                        pq.add(new int[]{village2, nextTime});
                    }
                } else if(village2 == currentVillage){
                    if(nextTime < distance[village1] && nextTime <= K){
                        distance[village1] = nextTime;
                        pq.add(new int[]{village1, nextTime});
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(distance[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}