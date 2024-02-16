class Solution {
    public int solution(int num) {
        int answer = 0;
        
        while(num != 1){
            answer++;
            if(answer > 400)
                return -1;
            
            if(num %2 ==0){
                num = num/2;
            } else {
                num = num*3+1;
            }
        }
        
        
        return answer;
    }
}