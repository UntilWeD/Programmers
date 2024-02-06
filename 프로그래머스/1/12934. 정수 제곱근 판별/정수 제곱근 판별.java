class Solution {
    public long solution(long n) {
        long answer = -1;
     
        if(n % Math.sqrt(n) == 0){
            answer = (long)(Math.pow(Math.sqrt(n)+1, 2));
        };
        
        return answer;
    }
}