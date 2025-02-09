import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, int[]> cars = new HashMap<>();
        HashMap<String, Integer> total = new HashMap<>();
        
        // 차 시간 계산
        for(int i=0; i<records.length; i++){
            String[] info = records[i].split(" ");
            String[] temp = info[0].split(":");
            int[] current =  new int[]{Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
            
            if(info[2].equals("IN")){
                cars.put(info[1], current);
            } else{
                int[] preTime = cars.get(info[1]);
                int sum = 0;
                
                current[0] = current[0] - preTime[0];
                current[1] = current[1] - preTime[1];
                
                sum = current[0] * 60 + current[1];
                
                total.put(info[1], total.getOrDefault(info[1], 0) + sum);
                
                cars.remove(info[1]);
            }
        }
        
        // 마지막 차 계산
        if(!cars.isEmpty()){
            for(String key : cars.keySet()){
                int sum = 0;
                int[] preTime = cars.get(key);
                
                preTime[0] = 23 - preTime[0];
                preTime[1] = 59 - preTime[1];
                
                sum = preTime[0] * 60 + preTime[1];
                
                total.put(key, total.getOrDefault(key, 0) + sum);
            }
        }
        
        // 요금 계산
        for(String key : total.keySet()){
            if(fees[0] > total.get(key)){
                total.put(key, fees[1]);
            } else{
                int sum = total.get(key) - fees[0];
                
                sum = fees[1] + (int)(Math.ceil((double)sum / fees[2]) * fees[3]);
                
                total.put(key, sum);
            }
        }
        
        // key 정렬
        int index = 0;
        String[] temp = new String[total.size()];
        for(String key : total.keySet()){
            temp[index] = key;
            index++;
        }
        
        Arrays.sort(temp);
        
        // answer에 넣기
        int[] answer = new int[total.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = total.get(temp[i]);
        }

        return answer;
    }
}