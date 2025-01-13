class Solution {
    public int solution(int n) {
        int answer = 0;
        int a=0, b=1;
        
        for(int i=2; i <=n; i++){
            answer = (a+b)%1234567;
            if(i%2==0){
                a = answer;
            }else{
                b = answer;
            }

        }
        
        return answer;
    }
}