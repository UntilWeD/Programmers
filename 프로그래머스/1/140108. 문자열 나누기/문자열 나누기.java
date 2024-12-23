class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = ' ';
        int is=0;
        int not=0;
        
        for(int i=0; i<s.length(); i++){
            if(x == ' ')
                x = s.charAt(i);
                
            if(s.charAt(i) == x){
                is++;
            } else{
                not++;
            }

            // x의 횟수와 아닌 횟수가 같을때
            if(is == not){
                s=s.substring(i+1);
                i=-1;
                x=' ';
                answer++;
                is=0;
                not=0;
            }
            if(i+1 == s.length() && is != not)
                answer++;
        }
        
        
        return answer;
    }
}