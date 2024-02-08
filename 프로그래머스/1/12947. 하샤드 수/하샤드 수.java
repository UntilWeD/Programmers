class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        int temp = x;
        
        for(int i=0; i < 5 ; i++){
            sum += x%10;
            x /= 10;
            if(x == 0)
                break;
        }
        if(temp%sum == 0)
            answer = true;
        
        return answer;
    }
}