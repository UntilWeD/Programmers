import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] late = new double[N];
        double cUser = stages.length;
        
        // 스테이지를 인덱스로 클리어하지못한 사용자 수 넣기
        for(int i = 0; i < stages.length; i++){
            if(stages[i] == N+1){
                continue;
            } else{
                late[stages[i]-1]++;
            }
        }
        
        // 스테이지(1~5)를 인덱스(0~4)로 한 late배열에 실패율 계산하여 넣기.
        for(int i=0; i<late.length; i++){
            if (cUser == 0) { // 남은 사용자가 없으면 실패율 0
                late[i] = 0;
            } else {
                late[i] = late[i] / cUser;
                cUser -= late[i] * cUser; // 실패율에 따라 cUser 갱신
            }
        }
        
        // 인덱스에 따른 값 HashMap에 정리
        HashMap<Integer, Double> map = new HashMap<>();
        for(int i=0; i< late.length; i++){
            map.put(i+1, late[i]);
        }
        
        // 내림차순 정렬
        Arrays.sort(late);
        for(int i = 0; i < late.length/2; i++) {
            double temp = late[i];
            late[i] = late[late.length - 1 - i];
            late[late.length - 1 - i] = temp;
        }
        
        // HashMap과 비교하여 값 넣기
        for(int i=0; i <answer.length; i++){
            for(int j=1; j<= N; j++){
                if(map.get(j) != null && late[i] == map.get(j)){
                    answer[i] = j;
                    map.remove(j);
                    break;
                }
            }
        }
        
        return answer;
    }
}