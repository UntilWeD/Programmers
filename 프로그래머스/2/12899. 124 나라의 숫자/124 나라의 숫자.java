class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        
        while(n > 0){
            int num = n % 3;
            if(num == 0){
                answer.insert(0, "4");
                n = n / 3 -1;
            } else if(num == 1){
                answer.insert(0, "1");
                n = n / 3;
            } else if(num == 2){
                answer.insert(0, "2");
                n = n / 3;
            }
        }
        
        
        return answer.toString();
    }
}