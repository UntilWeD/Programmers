class Solution {
    public int solution(int n, int t) {
        int answer = n;
        
        while(0 < t){
            answer *= 2;
            t--;
        }
        
        return answer;
    }
}