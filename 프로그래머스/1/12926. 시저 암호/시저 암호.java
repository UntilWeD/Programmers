class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for(int i=0; i< s.length(); i++){
            if(s.charAt(i) > 64 && s.charAt(i) < 91){
                answer += (char)((s.charAt(i)-'A' + n) % 26 + 'A');
            } else if(s.charAt(i) >96 && s.charAt(i) < 123){
                answer += (char)((s.charAt(i)-'a' + n) % 26 + 'a');
            } else{
                answer += " ";
            }
        }
        
        return answer;
    }
}