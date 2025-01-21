import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 5;
        
        Queue<String> que = new LinkedList<>();
        que.offer(cities[0].toLowerCase());

        if(cacheSize == 0){
            return cities.length * 5;
        } else{
            for(int i=1; i<cities.length; i++){
                String city = cities[i].toLowerCase();
                
                if(que.contains(city)){
                    answer += 1;
                    que.remove(city);
                } else{
                    answer += 5;
                }
                que.offer(city);
                if(que.size() > cacheSize){
                    que.poll();
                }
            }
        }
            
        return answer;
    }
}