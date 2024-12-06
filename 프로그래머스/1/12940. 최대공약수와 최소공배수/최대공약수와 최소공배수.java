class Solution {
    public int[] solution(int n, int m) {
        
        int[] answer = {1, 1};
        if(n > m){
            for(int i=1; i < n; i++){
                if(n % i == 0 && m % i== 0){
                    answer[0] = i;
                }
            }
        } else{
            for(int i=1; i < m; i++){
                if(n % i == 0 && m % i==0){
                    answer[0] = i;
                }
            }
        }
        while(true){
            if(answer[1] % n == 0 & answer[1] % m == 0){
                return answer;
            }
            ++answer[1];
        }

        
    
    }
}