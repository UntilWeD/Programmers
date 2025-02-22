class Solution {
    public int[] solution(int n) {
        int length = 0;
        for(int i=1; i <=n; i++)
            length +=i;
        
        
        int[] answer = new int[length];
        
        // 현재 인덱스
        int index = 0;
        // 숫자
        int num = 0;
        // 방향
        int direction = 0;
        // 변화량
        int temp = 0;
        for(int i=n; 0 < i; i--){
            for(int j=0; j < i; j++){
                num++;
                if(direction == 0){ // 왼쪽 아래 방향
                    index += temp++;
                } else if(direction == 1){ // 가로 방향
                    index++;
                } else if(direction == 2){ // 왼쪽 위 방향
                    index -= temp--;
                }
                answer[index] = num;
            }
            direction = (direction + 1) %3;
        }
        return answer;
    }
}