class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<= number; i++){
            int divisor = 0;
            for(int j=1; j<= Math.sqrt(i); j++){
                if(i%j == 0){
                    divisor++;
                    if(i/j != j){
                        divisor++;
                    }
                }

            }
            if(divisor <= limit){
                answer += divisor;
            } else{
                answer += power;
            }
        }
        
        return answer;
    }
}