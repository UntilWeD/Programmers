class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};
        
        // 최고, 최저 순위 구하기
        for(int i=0; i< lottos.length; i++){
            if(lottos[i] == 0){
                answer[0]--;
            } else {
                for(int j=0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        answer[0]--;
                        answer[1]--;
                    }
                }
            }
        }
        
        if(answer[0] > 6){
            answer[0] = 6;
        }
        if(answer[1] > 6){
            answer[1] = 6;
        }
        
        return answer;
    }
}