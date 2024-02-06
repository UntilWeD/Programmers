class Solution {
    public int solution(int n) {
        int answer = 2;
        int odd = 1;
        
        while(n>0){
            n -= odd;
            odd += 2;
        }
        
        if(n==0)
            answer=1;
        
        return answer;
    }
}