import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        
        for(int i=0; i<dungeons.length; i++){
            int fatigue = k;
            List<Integer> list = new ArrayList<>();
            // 모든 인덱스 추가
            for(int j=0; j< dungeons.length; j++){
                list.add(j);
            }
            // i 인덱스 제외
            list.remove(i);
            
            // i인덱스에 대해 피로도 연산 후 던전에 더 갈 수 있다면 goDungeons메서드 실행
            if(fatigue >= dungeons[i][0]){
                fatigue -= dungeons[i][1];
                answer = Math.max(answer ,1 + goDungeons(fatigue, dungeons, list));
            }
        }
        
        return answer;
    }
    
    public int goDungeons(int fatigue, int[][] dungeons, List<Integer> list){
        // 더 이상 갈 수 있는 곳이 없을 경우
        if(list.isEmpty()){
            return 0;
        } 
        
        int max = 0;
        
        for(int x : list){
            // 다른 던전에 갈 수 있는 경우
            if(fatigue >= dungeons[x][0]){
                int temp = fatigue - dungeons[x][1];

                List<Integer> remainList = new ArrayList<>();

                for(int y : list){
                    if(y != x)
                        remainList.add(y);
                }
                
                max = Math.max(max ,1+goDungeons(temp, dungeons, remainList));
            }
        }
        
        
        return max;
    }
    
}