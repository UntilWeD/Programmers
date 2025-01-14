class Solution {
    public long solution(int n) {
        int a = 1;
        int b = 2;
        
        if(n == 1){
            return a;
        } else if(n == 2){
            return b;
        }
        
        // 피보나치와 같음
        for(int i=2; i<n; i++){
            if(i%2 == 0){
                a = (a+b)%1234567;
            } else{
                b = (a+b)%1234567;
            }
        }
        if(n % 2 != 0){
            return a;
        } else{
            return b;
        }
        
    }
}