class Solution {
    public int solution(int n) {
        int answer = 0;
        
        
        for(int i=1; i<=n; i++){
            int divisor=0;
            for(int j=1; j<=(int)Math.sqrt(i); j++){
                if(i % j ==0){
                    divisor++;
                    if(i / j != j){
                        divisor++;
                    }
                }
                if(divisor > 2)
                    break;
            }
            if(divisor == 2)
                answer++;

        }
        
        return answer;
    }
}